package br.com.trescon.fmsoauth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt.config")
public class JwtConfiguration {

	private String jwtSecret = "MY_SECRET_KEY_TEST";
	private Long expiratino = 3600l;
}
