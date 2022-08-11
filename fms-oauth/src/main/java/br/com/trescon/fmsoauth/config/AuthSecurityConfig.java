package br.com.trescon.fmsoauth.config;

import java.io.InputStream;
import java.security.KeyStore;
import java.time.Duration;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@EnableWebSecurity
@Configuration
public class AuthSecurityConfig {
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
		return http.formLogin(Customizer.withDefaults()).build();
	}
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		return http.formLogin(Customizer.withDefaults()).build();
	}

	@Bean
	RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder) {
		
		RegisteredClient awuserClient = RegisteredClient
				.withId("1")
				.clientId("awuser")
				.clientSecret(passwordEncoder.encode("123456"))
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.scope("users:read")
				.scope("users:write")
				.tokenSettings(TokenSettings.builder()
						.accessTokenTimeToLive(Duration.ofMinutes(5))
						.build())
				.clientSettings(ClientSettings.builder()
						.requireAuthorizationConsent(false)
						.build())
				.build();
		
		return new InMemoryRegisteredClientRepository(Arrays.asList(awuserClient));
	}
	
	@Bean
	ProviderSettings providerSettings(AuthProperties authProperties) {
		return ProviderSettings.builder()
				.issuer(authProperties.getProviderUri()) //"http://localhost:8080" -> porta authserver
				.build();
	}
	
	@Bean
	JWKSet jwkSet(AuthProperties authProperties) throws Exception {
		//Arquivo em uma pasta externa ?
		final String jksPath = authProperties.getJks().getPath();
		final InputStream inputStream = new ClassPathResource(jksPath).getInputStream();
		
		final KeyStore keyStore = KeyStore.getInstance("JKS"); //TYPE
		keyStore.load(inputStream, authProperties.getJks().getStorepass().toCharArray());
		
		
		RSAKey rsaKey = RSAKey.load(keyStore,
				authProperties.getJks().getAlias(),
				authProperties.getJks().getKeypass().toCharArray());
		
		return new JWKSet(rsaKey);
	}
	
	//PODE TER DIVERSAS CHAVES JWK EM UM PROJETO
	/*
	JWKSource<SecurityContext> jwtSource(JWKSet jwkSet) {
		//return (())
	}
	*/
	
	@Bean
	JwtEncoder jwtEncoder() {
		return new NimbusJwtEncoder(null);
	}
	
}