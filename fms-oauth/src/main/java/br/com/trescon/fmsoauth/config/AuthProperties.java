package br.com.trescon.fmsoauth.config;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties("aw.auth")
public class AuthProperties {

	@NotBlank
	private String providerUri;

	public String getProviderUri() {
		return providerUri;
	}

	public void setProviderUri(String providerUri) {
		this.providerUri = providerUri;
	}

}