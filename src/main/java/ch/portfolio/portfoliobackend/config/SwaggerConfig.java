package ch.portfolio.portfoliobackend.config;

import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SwaggerConfig {
    @Bean
    public OperationCustomizer customize(){
        // Add multiple custom headers
        return (operation, handlerMethod) -> {
            operation.addParametersItem(new Parameter().in("header").name("Authorization").required(false).description("Bearer Token"));
            operation.addParametersItem(new Parameter().in("header").name("X-XSRF-TOKEN").required(false).description("CSRF Token"));
            return operation;
        };
    }
}
