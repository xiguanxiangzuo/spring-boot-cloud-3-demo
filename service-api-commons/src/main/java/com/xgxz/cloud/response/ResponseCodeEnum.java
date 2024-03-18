package com.xgxz.cloud.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
@AllArgsConstructor
public enum ResponseCodeEnum {

    SUCCESS(200, "success"),

    RC201(201, "服务开启降级保护, 请稍后再试"),

    RC202(202, "热点参数限流, 请稍后再试"),

    RC203(203, "系统规则不满足要求, 请稍后再试"),

    RC204(204, "授权规则不通过, 请稍后再试"),

    RC400(400, "请求方式错误"),

    RC401(401, "匿名用户访问无权限资源时的异常"),

    RC403(403, "访问越权"),

    RC404(404, "404页面找不到"),

    RC500(500, "服务器内部错误"),

    RC375(375, "数学运算异常, 请稍后再试"),

    INVALID_TOKEN(2001, "访问令牌不合法"),

    ;

    private final Integer code;

    private final String message;

    public static ResponseCodeEnum getResponseCodeEnum(Integer code) {

        return Arrays.stream(ResponseCodeEnum.values()).filter(x -> x.getCode().equals(code)).findFirst().orElse(null);
    }

}
