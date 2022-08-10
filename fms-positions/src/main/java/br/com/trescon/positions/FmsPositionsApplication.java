package br.com.trescon.positions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FmsPositionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsPositionsApplication.class, args);
	}

}
