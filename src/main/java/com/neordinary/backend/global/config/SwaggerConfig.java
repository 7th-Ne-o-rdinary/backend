package com.neordinary.backend.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    private String version = "1.0.0";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addServersItem(new Server().url("/"))
                .components(new Components().addSecuritySchemes("access-token",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(apiInfo())
                .tags(tagList());
    }

    private Info apiInfo() {
        return new Info()
                .title("너디너리 해커톤 Server")
                .description("너디너리 해커톤 API를 확인할 수 있습니다.")
                .version(version);
    }

    private List<Tag> tagList() {
        return List.of(
                new Tag().name("Auth").description("인증 관련 API")
        );
    }
}