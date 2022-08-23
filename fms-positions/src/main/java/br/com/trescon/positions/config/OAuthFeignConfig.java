package br.com.trescon.positions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import feign.RequestInterceptor;

@Configuration
public class OAuthFeignConfig {
	
	final static String CLIENT_REGISTRATION_ID = "fms";
	final static String PRINCIPAL = "fms-instrument";
	
    public OAuthFeignConfig() {
    }

	@Bean
	RequestInterceptor requestInterceptor(AuthorizedClientServiceOAuth2AuthorizedClientManager clientManager) throws Exception {
		OAuth2AuthorizeRequest auth2AuthorizeRequest = 
				OAuth2AuthorizeRequest.withClientRegistrationId(CLIENT_REGISTRATION_ID)
				.principal(PRINCIPAL)
				.build();
		
		OAuth2AuthorizedClient authorize = clientManager.authorize(auth2AuthorizeRequest);
		
		if(authorize != null) {
			OAuth2AccessToken accessToken = authorize.getAccessToken();
			return requestTemplate -> {
				System.out.println("TOKEN");
				System.out.println(accessToken.getTokenValue());
				requestTemplate.header("Authorization", "Bearer " + accessToken.getTokenValue());
			};
		} else {
			throw new Exception("Falha na autenticação");
		}
				
	}

}
