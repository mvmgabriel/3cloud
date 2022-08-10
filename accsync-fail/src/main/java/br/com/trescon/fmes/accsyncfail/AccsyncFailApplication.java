package br.com.trescon.fmes.accsyncfail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( "br.com.trescon.fmes.accsyncfail" )
@EnableEurekaClient
public class AccsyncFailApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccsyncFailApplication.class, args);
	}

}
