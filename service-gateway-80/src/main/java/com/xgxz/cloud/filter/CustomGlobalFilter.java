package com.xgxz.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: CustomGlobalFilter
 * Package: com.xgxz.cloud.filter
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/20 22:51
 * @Version 1.0
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    public static final String BEGIN_VISIT_TIME = "begin_visit_time";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        exchange.getAttributes().put(BEGIN_VISIT_TIME, System.currentTimeMillis());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);

            if (beginVisitTime != null) {
                log.info("访问接口主机: {}", exchange.getRequest().getURI().getHost());
                log.info("访问接口端口: {}", exchange.getRequest().getURI().getPort());
                log.info("访问接口URL: {}", exchange.getRequest().getURI().getPath());
                log.info("访问接口URL后面参数: {}", exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口时长: {} 毫秒", (System.currentTimeMillis() - beginVisitTime));
                log.info("-----------------------------------------------------------------");

                System.out.println();
            }
        }));
    }

    @Override
    public int getOrder() {

        return 0;
    }
}
