package br.com.trescon.fmsgateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApiGatewayConfiguration {

	/*
    @Bean
    RouteLocator gatewaryRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                		.uri("http://httpbin.org:80")
                		)
                .route(p -> p.path("/fms-intruments/**")
                		.uri("lb://instruments"))
                .build();
    }
    */
}
