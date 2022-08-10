package br.com.trescon.fmes.erkserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErkServerApplication.class, args);
	}

}
