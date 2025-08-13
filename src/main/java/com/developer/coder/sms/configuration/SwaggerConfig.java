package com.developer.coder.sms.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public static final String title = "Library";
    public static final String description = "by Enakshi";
    public static final String version = "0.1";
    public static final String termsOfServiceUrl = "https://tuespotsolution.com";
    public static final String contactName = "078144-78557";
    public static final String license = "tuespotsolutions.com";
    public static final String licenseUrl = "https://tuespotsolution.com";

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .termsOfService(termsOfServiceUrl)
                        .contact(new Contact().name(contactName))
                        .license(new License().name(license).url(licenseUrl))
                );
    }
}
