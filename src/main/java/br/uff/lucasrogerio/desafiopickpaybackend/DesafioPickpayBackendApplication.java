package br.uff.lucasrogerio.desafiopickpaybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DesafioPickpayBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPickpayBackendApplication.class, args);
	}

}
