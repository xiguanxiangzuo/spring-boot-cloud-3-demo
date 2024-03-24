package com.xgxz.cloud.feign;

import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.xgxz.cloud.feign.fallback.FeignSentinelFallBack;
import com.xgxz.cloud.response.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName: OrderFeign
 * Package: com.xgxz.cloud.feign
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/18 21:49
 * @Version 1.0
 */
@FeignClient(value = "service-gateway", fallback = FeignSentinelFallBack.class)
public interface PayFeign {

    @Operation(summary = "新增", description = "新增支付流水方法")
    @PostMapping("/admin/pay/add")
    ResultData<String> add(@RequestBody PayDTO dto);


    @GetMapping("/admin/pay/getById/{id}")
    ResultData<Pay> getById(@PathVariable("id") Long id);
}
