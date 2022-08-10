package br.com.trescon.instruments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FmsInstrumentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsInstrumentsApplication.class, args);
	}

}
