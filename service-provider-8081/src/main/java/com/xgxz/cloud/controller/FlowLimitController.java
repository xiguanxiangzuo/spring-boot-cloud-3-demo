package com.xgxz.cloud.controller;

import com.xgxz.cloud.service.FlowLimitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: FlowLimitController
 * Package: com.xgxz.cloud.controller
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/24 15:01
 * @Version 1.0
 */
@Slf4j
@Tag(name = "流量控制")
@RequestMapping("/admin/flow")
@RestController
public class FlowLimitController {

    @Autowired
    private FlowLimitService flowLimitService;

    @Operation(summary = "testA")
    @GetMapping("/testA")
    public String testA(){

        return "----------testA";
    }

    @Operation(summary = "testB")
    @GetMapping("/testB")
    public String testB(){

        return "----------testB";
    }

    @Operation(summary = "testC")
    @GetMapping("/testC")
    public String testC(){

        flowLimitService.common();

        return "----------testC";
    }

    @Operation(summary = "testD")
    @GetMapping("/testD")
    public String testD(){

        flowLimitService.common();

        return "----------testD";
    }
}
