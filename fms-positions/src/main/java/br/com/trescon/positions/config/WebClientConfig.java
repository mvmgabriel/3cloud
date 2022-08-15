package br.com.trescon.positions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class WebClientConfig {


	// serve para registar em memoria o client que esta configurado no properties
	@Bean
	OAuth2AuthorizedClientService auth2AuthorizedClientService(ClientRegistrationRepository clientRegistrationRepository) {
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
	}

	//Gerencia os tokens backend para backend
	@Bean
	AuthorizedClientServiceOAuth2AuthorizedClientManager clientManager(
			ClientRegistrationRepository clientRegistrationRepository,
			OAuth2AuthorizedClientService auth2AuthorizedClientService
			) {
		var authorizedClientProvider =
				OAuth2AuthorizedClientProviderBuilder
				.builder()
				.clientCredentials()
				.build();

		var clientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager(
				clientRegistrationRepository,
				auth2AuthorizedClientService
				);

		clientManager.setAuthorizedClientProvider(authorizedClientProvider);

		return clientManager;
	}
}
