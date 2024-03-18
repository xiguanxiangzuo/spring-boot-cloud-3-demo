package com.xgxz.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName: PayDTO
 * Package: com.xgxz.cloud.dto
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/17 12:28
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayDTO implements Serializable {

    private String payNo;

    private String orderNo;

    private Integer userId;

    private BigDecimal amount;
}
