package com.service.mongodb.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	  public Docket api() {
	      return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.service.mongodb.controller"))
	        .paths(PathSelectors.any())
	        .build()
	        .apiInfo(this.informacoesApi().build())
	        .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
	  }
	
	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Rest API com MongoDB v3.6");
		apiInfoBuilder.description("Springboot REST API com MongoDB v3.6");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("http://localhost:8080/mongoapi/pessoa/hello");
		apiInfoBuilder.license("Licença");
		apiInfoBuilder.licenseUrl("http://localhost:8080/mongoapi/pessoa/hello");
 
		return apiInfoBuilder;
 
	}
	
	//Valor padrao para endpoints que nao foram customizados
	private List<ResponseMessage> responseMessageForGET()
	{
	    return new ArrayList<ResponseMessage>() {{
	        /*add(new ResponseMessageBuilder()
	            .code(500)
	            .message("500 Erro")
	            .responseModel(new ModelRef("Error"))
	            .build());*/
	        add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Não encontrado")
	            .build());
	    }};
	}
}
