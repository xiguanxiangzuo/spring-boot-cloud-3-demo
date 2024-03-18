package com.xgxz.cloud.controller;

import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.xgxz.cloud.feign.PayFeign;
import com.xgxz.cloud.response.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: OrderConsumer
 * Package: com.xgxz.cloud.controller
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/18 22:05
 * @Version 1.0
 */
@Tag(name = "测试OpenFeign调用")
@RestController
@RequestMapping("/admin")
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

        return payFeign.getById(id);
    }
}
