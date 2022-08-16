package br.com.trescon.fmsoauth.config;

import java.io.InputStream;
import java.security.KeyStore;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import br.com.trescon.fmsoauth.entities.UserDomain;
import br.com.trescon.fmsoauth.entities.UserEntity;
import br.com.trescon.fmsoauth.services.UserService;

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
	OAuth2TokenCustomizer<JwtEncodingContext> jwtEncondingContextOAuth2TokenCustomizer(UserService userService) {
		//todo
		return (context -> {
			Authentication authentication = context.getPrincipal();
			
			if(authentication.getPrincipal() instanceof User) {
				final User user = (User) authentication.getPrincipal();
				
				try {
					final UserEntity userDomain = userService.findUserByEmail(user.getUsername());
					
					
					Set<String> authorities = new HashSet<>();
					for(GrantedAuthority authority: user.getAuthorities()) {
						authorities.add(authority.toString());
					}
					
					context.getClaims().claim("user_id", userDomain.getId().toString());
					context.getClaims().claim("user_fullname", userDomain.getName());
					context.getClaims().claim("authorities", authorities);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
	}

	@Bean
	RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder, JdbcTemplate jdbcTemplate) {
		
		RegisteredClient fmsUserClient = RegisteredClient
				.withId("1")
				.clientId("fms")
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
		
        RegisteredClient fmsi = RegisteredClient
                .withId("3")
                .clientId("fmsi")
                .clientSecret(passwordEncoder.encode("123456"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("http://localhost:3000/authorized")
                .redirectUri("https://oidcdebugger.com/debug")
                .redirectUri("https://oauth.pstmn.io/v1/callback")
                .scope("myuser:read")
                .scope("myuser:write")
                .scope("posts:write")
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofMinutes(15))
                        .refreshTokenTimeToLive(Duration.ofDays(1))
                        .reuseRefreshTokens(false)
                        .build())
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(true)
                        .build())
                .build();

		RegisteredClient fmsInstrumentClient = RegisteredClient //ex blog
				.withId("2")
				.clientId("fms-instruments")
				.clientSecret(passwordEncoder.encode("123456"))
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
				.redirectUri("http://localhost:3000/authorized")  //SIMULANDO UM FRONT END
				.redirectUri("https://oidcdebugger.com/debug")  //SIMULANDO UM FRONT END
				.redirectUri("https://oidcdebugger.com/debug")  //SIMULANDO UM FRONT END
				.scope("myuser:read")
				.scope("myuser:write")
				.scope("posts:write") //exemplos
				.tokenSettings(TokenSettings.builder()
						.accessTokenTimeToLive(Duration.ofMinutes(5))
						.refreshTokenTimeToLive(Duration.ofDays(1))
						.reuseRefreshTokens(false) // REGERA UM NOVO REFRESH TOKEN E INVALIDA O ANTERIOR
						.build())
				.clientSettings(ClientSettings.builder()
						.requireAuthorizationConsent(false) //mostra tela
						.build())
				.build();
		
		//return new InMemoryRegisteredClientRepository(Arrays.asList(fmsUserClient, fmsInstrumentClient, fmsi));
		JdbcRegisteredClientRepository clientRepository =  new JdbcRegisteredClientRepository(jdbcTemplate);
		
		// Executar 1 vez para salvar
		// TESTE
		//clientRepository.save(fmsUserClient);
		//clientRepository.save(fmsInstrumentClient);
		//clientRepository.save(fmsi);
		
		return clientRepository;
	}
	
	@Bean
	OAuth2AuthorizationService oAuth2AuthorizationService(JdbcOperations jdbcOperations,
			RegisteredClientRepository registeredClientRepository) {
		return new JdbcOAuth2AuthorizationService(jdbcOperations, registeredClientRepository);
	}
	
	@Bean
	OAuth2AuthorizationConsentService oAuth2AuthorizationConsentService(JdbcOperations jdbcOperations,
			RegisteredClientRepository registeredClientRepository) {
		return new JdbcOAuth2AuthorizationConsentService(jdbcOperations, registeredClientRepository);
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
	@Bean
	JWKSource<SecurityContext> jwtSource(JWKSet jwkSet) {
		return ((jwkSelector, securityContext) -> jwkSelector.select(jwkSet));
	}
	
	@Bean
	JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
		return new NimbusJwtEncoder(jwkSource);
	}
	
}