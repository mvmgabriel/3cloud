package br.com.trescon.fmes.accsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccsyncApplication.class, args);
	}

}
