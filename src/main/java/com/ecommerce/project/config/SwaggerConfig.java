package com.ecommerce.project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme bearScheme=new SecurityScheme().type(SecurityScheme.Type.HTTP).
                scheme("bearer").bearerFormat("JWT")
                .description("JWT Bearer Token");

        SecurityRequirement securityRequirement=new SecurityRequirement()
                .addList("Bearer Authentication");

        return new OpenAPI().
                info(new Info().title("Spring Boot Ecommerce Api")
                        .version("v0.0.1").description("Spring Boot Ecommerce Api Project")
                        .license(new License().name("Apache 2.0").url(""))
                        .contact(new Contact().name("Aniket Sen")
                                .email("aniketdgp5@gmail.com"))).
                components(new
                        Components().addSecuritySchemes
                        ("Bearer Authentication",bearScheme))
                .addSecurityItem(securityRequirement);

    }
}
