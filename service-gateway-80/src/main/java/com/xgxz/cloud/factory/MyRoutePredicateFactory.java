package com.xgxz.cloud.factory;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: MyRoutePredicateFactory
 * Package: com.xgxz.cloud
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/20 21:15
 * @Version 1.0
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {

        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {

                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");

                if (userType == null) {

                    return false;
                }
                return userType.equalsIgnoreCase(config.getUserType());
            }
        };
    }

    @Data
    @Validated
    public static class Config {

        @NotEmpty
        private String userType;
    }
}
