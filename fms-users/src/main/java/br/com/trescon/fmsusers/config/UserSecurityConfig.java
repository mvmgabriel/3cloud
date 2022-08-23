package br.com.trescon.fmsusers.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserSecurityConfig {
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable()
                .oauth2ResourceServer()
                    .jwt()
                    .jwtAuthenticationConverter(jwtAuthenticationConverter()); // Carregar permissoes de usuario
        
        return http.build();
    }
    
    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(
                jwt -> {
                    List<String> userRoleAuthorities = jwt.getClaimAsStringList("authorities"); // pega do token

                    if(userRoleAuthorities == null) {
                        userRoleAuthorities = Collections.emptyList();
                    }

                    JwtGrantedAuthoritiesConverter scopesConverter = new JwtGrantedAuthoritiesConverter();

                    Collection<GrantedAuthority> scopeAuthorities = scopesConverter.convert(jwt);
                    scopeAuthorities.addAll(userRoleAuthorities.stream().map(SimpleGrantedAuthority::new).toList());
                    
                    //ESSE CONVERTER É POR CAUSA DA CUSTOMIZAÇÃO

                    return scopeAuthorities;
                }
        );

        return converter;
    }

}
