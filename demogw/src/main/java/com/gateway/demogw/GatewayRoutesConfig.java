package com.gateway.demogw;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.stripPrefix;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayRoutesConfig {
    @Bean
    RouterFunction<ServerResponse> gatewayRoutes() {
//localhost:8080/java1/api/full
        return route("ms-vuelos_route")
//                .POST("ms-vuelos_route/v1/**")
                .GET("ms-vuelos/v1/**", http())
                // Nota: primero setea URI target y luego stripPrefix (ejemplo oficial)
                .before(uri("http://localhost:8081"))
                .before(stripPrefix(1))
                .build()
//localhost:8080/java2/api/**
                .and(route("ms-menu_route")
                        .GET("ms-menu/api/**", http())
                        .before(uri("http://localhost:8083"))
                        .before(stripPrefix(1))
                        .build()
                );
    }
}
