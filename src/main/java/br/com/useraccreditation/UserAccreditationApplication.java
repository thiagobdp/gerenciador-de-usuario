package br.com.useraccreditation;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UserAccreditationApplication {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(UserAccreditationApplication.class, args);
	}	
}
