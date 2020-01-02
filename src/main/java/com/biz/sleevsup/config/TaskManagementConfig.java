package com.biz.sleevsup.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableAutoConfiguration
@Configuration
@EnableSwagger2
public class TaskManagementConfig {
    private final Logger logger= LoggerFactory.getLogger(TaskManagementConfig.class);

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Sleevsup-Task-Management")
                .useDefaultResponseMessages(false).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sleevsup-Task-Management-Backend")
                .description("Sleevsup Task Management API Document")
                .termsOfServiceUrl("")
                .contact(new Contact("Rasindu Roohansa", "", "rasinduroohansa@gmail.com"))
                .licenseUrl("").build();
    }
}
