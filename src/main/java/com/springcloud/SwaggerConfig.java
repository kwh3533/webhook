package com.springcloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		ApiInfo apiinfo = new ApiInfoBuilder().title("Webhook").description("Notify change of Configmng").version("1.0").build();
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
							.apiInfo(apiinfo)
							.select()
							.apis(RequestHandlerSelectors.basePackage("com.springcloud"))
							.paths(PathSelectors.any())
							.build();
		
		return docket;
	}
}
