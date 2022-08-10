package br.com.trescon.fmsusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class FmsUsersApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	public static void main(String[] args) {
		SpringApplication.run(FmsUsersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCRYPT = " + passwordEnconder.encode("admin"));
	}

}
