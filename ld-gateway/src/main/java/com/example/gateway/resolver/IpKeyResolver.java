package com.example.gateway.resolver;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class IpKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //return Mono.just(exchange.getRequest().getPath().value());
        return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
