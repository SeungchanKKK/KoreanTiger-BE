package com.geupjo.koreantiger.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    private static final String PACKAGE_PATH = "com.geupjo.koreantiger.controller";
    private static final String HELLO_API_PATH_PREFIX = "/hello/**";
    private static final String TIGER_API_V1_PATH_PREFIX = "/v1/**";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .servers(List.of(new Server().url("/")))
                .info(getInfo());
    }

    @Bean
    public GroupedOpenApi tigerAPI() {
        return GroupedOpenApi.builder()
                .group("Korean Tiger API v1")
                .packagesToScan(PACKAGE_PATH)
                .pathsToMatch(TIGER_API_V1_PATH_PREFIX)
                .build();
    }

    @Bean
    public GroupedOpenApi helloAPI() {
        return GroupedOpenApi.builder()
                .group("hello API")
                .packagesToScan(PACKAGE_PATH)
                .pathsToMatch(HELLO_API_PATH_PREFIX)
                .pathsToExclude(TIGER_API_V1_PATH_PREFIX)
                .build();
    }

    private Info getInfo() {
        return new Info()
                .title("Geupjo REST API")
                .description("Geupjo REST API OpenApi Documentation")
                .version("1.0")
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                )
                .contact(new Contact()
                        .name("Geupjo")
                        .url("https://github.com/Geupjo-Hackathon")
                );
    }
}
