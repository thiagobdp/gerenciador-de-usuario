package br.com.gerenciador.assembleias;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GerenciadorDeAssembleiasApplication {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(GerenciadorDeAssembleiasApplication.class, args);
	}	
}
