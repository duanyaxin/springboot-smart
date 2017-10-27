package org.zt.ccty.springboot_mybatis_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.models.dto.ApiInfo;
//import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.zt.ccty.springboot_mybatis_demo.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	
	
	private springfox.documentation.service.ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring boot中使用Swagger2构建RESTful APIs")
				.description("author by jack duan")
				.termsOfServiceUrl("http://127.0.0.1:9090")
				.contact("jack duan")
				.version("1.0")
				.build();
	}
}
