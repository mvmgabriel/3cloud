package br.com.trescon.fmes.partacct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( "br.com.trescon.fmes.partacct" )
@EnableEurekaClient
@EnableFeignClients
public class PartacctApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartacctApplication.class, args);
	}

}
