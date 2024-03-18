package com.xgxz.cloud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: SwaggerConfig
 * Package: com.xgxz.security.config
 * Description:
 *
 * @Author: 习惯向左
 * @Create: 2023/9/8 - 15:47
 * @Version: v1.0
 */
@Configuration
public class Swagger3Config {

    private Info info(){
        return new Info()
                .title("SpringCloud-API接口文档")
                .description("SpringCloud组件")
                .contact(new Contact().name("习惯向左"))
                .title("SpringCloud")
                .version("v1.0.0");
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(info());
    }

}
