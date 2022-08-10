package br.com.trescon.fmsconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class FmsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsConfigServerApplication.class, args);
	}

}
