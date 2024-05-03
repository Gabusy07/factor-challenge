package com.factor.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI(){
        Components components = new Components();
        return new OpenAPI().components(components)
                .info(new Info()
                        .title("Springboot_Swagger Project OpenAPI Docs")
                        .version("0.0.1").description("Doc Description"));
    }

}