package com.xgxz.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgxz.cloud.dto.PayDTO;
import com.xgxz.cloud.entity.Pay;
import com.xgxz.cloud.mapper.PayMapper;
import com.xgxz.cloud.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付交易表 服务实现类
 * </p>
 *
 * @author 习惯向左
 * @since 2024-03-17
 */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {

    @Override
    public void save(PayDTO dto) {

        Pay pay = new Pay();

        BeanUtils.copyProperties(dto, pay);

        baseMapper.insert(pay);
    }
}
