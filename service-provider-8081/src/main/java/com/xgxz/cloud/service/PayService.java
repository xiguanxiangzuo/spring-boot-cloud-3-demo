package com.xgxz.cloud.service;

import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 支付交易表 服务类
 * </p>
 *
 * @author 习惯向左
 * @since 2024-03-17
 */
public interface PayService extends IService<Pay> {

    void save(PayDTO dto);
}
