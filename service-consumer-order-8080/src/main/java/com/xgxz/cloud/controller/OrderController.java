package com.xgxz.cloud.controller;

import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.xgxz.cloud.feign.PayFeign;
import com.xgxz.cloud.response.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * ClassName: OrderConsumer
 * Package: com.xgxz.cloud.controller
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/18 22:05
 * @Version 1.0
 */
@Slf4j
@Tag(name = "测试OpenFeign调用")
@RestController
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private PayFeign payFeign;

    @Operation(summary = "添加方法")
    @PostMapping("/add")
    public ResultData<String> addOrder(@RequestBody PayDTO dto) {

        return payFeign.add(dto);
    }

    @Operation(summary = "根据id获取方法")
    @GetMapping("/getById/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Long id) {

        log.info("consumer调用开始: {}", LocalDateTime.now());

        ResultData<Pay> result = payFeign.getById(id);

        log.info("consumer调用结束: {}", LocalDateTime.now());

        return result;
    }

    @GetMapping("/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request) {

        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            log.info("请求头名: {}, 请求头值: {}", headName, headValue);
        }

        return ResultData.success("gateway 过滤器: " + LocalDateTime.now());
    }
}
