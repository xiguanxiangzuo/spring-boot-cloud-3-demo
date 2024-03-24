package com.xgxz.cloud.feign.fallback;

import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.xgxz.cloud.feign.PayFeign;
import com.xgxz.cloud.response.ResultData;
import org.springframework.stereotype.Component;

/**
 * ClassName: FeignSentinelFallBack
 * Package: com.xgxz.cloud.feign.fallback
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/24 22:48
 * @Version 1.0
 */
@Component
public class FeignSentinelFallBack implements PayFeign {

    @Override
    public ResultData add(PayDTO dto) {

        return ResultData.error().code(500).message("对方服务宕机或者不可用, fallback 服务降级");
    }

    @Override
    public ResultData<Pay> getById(Long id) {
        return null;
    }
}
