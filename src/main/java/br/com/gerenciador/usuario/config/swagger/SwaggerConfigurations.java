package br.com.gerenciador.usuario.config.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket applicationApi() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("br.com.gerenciador.usuario"))//
				.paths(PathSelectors.ant("/**"))//
				.build()//
				.useDefaultResponseMessages(false)//
				.globalResponseMessage(RequestMethod.GET, this.responseMessageForGET())//
				.apiInfo(this.apiInfo());
	}

	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {
			{//
				add(new ResponseMessageBuilder()//
						.code(200)//
						.message("200 message")//
						.build());
			}
		};
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("Gerenciador de Permissão para Votação REST API")//				
				.version("1.0.0")//
				.build();
	}
}
