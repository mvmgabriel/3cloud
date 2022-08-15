package br.com.trescon.positions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import feign.RequestInterceptor;

public class OAuthFeignConfig {
	
    public OAuthFeignConfig() {
    }

	@Bean
	RequestInterceptor requestInterceptor(AuthorizedClientServiceOAuth2AuthorizedClientManager clientManager) throws Exception {
		OAuth2AuthorizeRequest auth2AuthorizeRequest = 
				OAuth2AuthorizeRequest.withClientRegistrationId("fms")
				.principal("FMS-AUTH-SERVICE")
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
