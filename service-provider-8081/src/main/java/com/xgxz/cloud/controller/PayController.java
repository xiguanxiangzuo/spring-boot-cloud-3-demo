package com.xgxz.cloud.controller;

import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.xgxz.cloud.response.ResultData;
import com.xgxz.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 支付交易表 前端控制器
 * </p>
 *
 * @author 习惯向左
 * @since 2024-03-17
 */
@Tag(name = "支付")
@Slf4j
@RestController
@RequestMapping("/admin/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @Operation(summary = "新增", description = "新增支付流水方法")
    @PostMapping("/add")
    public ResultData<String> add(@RequestBody PayDTO dto) {

        payService.save(dto);

        return ResultData.success();
    }

    @GetMapping("/getById/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Long id) {

        log.info("调用开始: {}", LocalDateTime.now());

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        Pay pay = payService.getById(id);

        log.info("调用结束: {}", LocalDateTime.now());

        return ResultData.success(pay);
    }
}
