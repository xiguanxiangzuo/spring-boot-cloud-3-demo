package com.xgxz.cloud.factory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * ClassName: MyGatewayFilterFactory
 * Package: com.xgxz.cloud.factory
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/22 21:23
 * @Version 1.0
 */
@Slf4j
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    @Override
    public GatewayFilter apply(Config config) {

        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

                ServerHttpRequest request = exchange.getRequest();

                log.info("进入自定义网关过滤器MyGatewayFilterFactory, status: {}", config.getStatus());

                if (request.getQueryParams().containsKey("xgxz")) {

                    return chain.filter(exchange);
                }
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);

                return exchange.getResponse().setComplete();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {

        return List.of("status");
    }

    @Data
    public static class Config {

        private String status;
    }
}
