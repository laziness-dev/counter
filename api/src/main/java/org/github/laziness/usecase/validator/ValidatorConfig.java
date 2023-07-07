package org.github.laziness.usecase.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {

    @Bean
    public IPv4Validator iPv4Validator() {
        return new IPv4Validator();
    }

    @Bean
    public UrlValidator urlValidator() {
        return new UrlValidator();
    }
}
