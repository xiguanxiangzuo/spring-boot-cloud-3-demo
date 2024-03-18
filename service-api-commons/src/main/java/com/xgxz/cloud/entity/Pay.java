package com.xgxz.cloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 支付交易表
 * </p>
 *
 * @author 习惯向左
 * @since 2024-03-17
 */
@Data
@TableName("t_pay")
@Schema(name = "Pay", description = "支付交易表")
public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @Schema(description = "支付流水号")
    @TableField("pay_no")
    private String payNo;

    @Schema(description = "订单流水号")
    @TableField("order_no")
    private String orderNo;

    @Schema(description = "用户id")
    @TableField("user_id")
    private Integer userId;

    @Schema(description = "交易金额")
    @TableField("amount")
    private BigDecimal amount;

    @Schema(description = "删除标志，0:不删除，1:删除")
    @TableField("is_deleted")
    private Boolean deleted;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}