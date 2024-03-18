package com.xgxz.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FeignConfig
 * Package: com.xgxz.cloud.config
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/18 22:54
 * @Version 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer() {

        // feign 默认配置是不走重试策略的
        //return Retryer.NEVER_RETRY;

        // 最大请求次数为 3, 初始间隔时间为100ms，重试最大时间间隔为1s
        return new Retryer.Default(100, 1, 3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {

        return Logger.Level.FULL;
    }
}
