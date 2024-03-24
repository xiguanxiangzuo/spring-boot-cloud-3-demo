package com.xgxz.cloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xgxz.cloud.service.FlowLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ClassName: FlowLimitServiceImpl
 * Package: com.xgxz.cloud.service.impl
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/24 15:28
 * @Version 1.0
 */
@Slf4j
@Service
public class FlowLimitServiceImpl implements FlowLimitService {

    @SentinelResource(value = "common")
    @Override
    public void common() {

        log.info("---------FlowLimitServiceImpl come in---------");
    }
}
