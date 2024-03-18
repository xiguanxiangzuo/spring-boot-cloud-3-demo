package com.xgxz.cloud.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultData<T> {

    private Integer code;

    private String message;

    private T data;

    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }



    public static <T> ResultData<T> success() {

        ResultData<T> resultData = new ResultData<>();

        resultData.setCode(ResponseCodeEnum.SUCCESS.getCode());

        resultData.setMessage(ResponseCodeEnum.SUCCESS.getMessage());

        return resultData;
    }

    public static <T> ResultData<T> success(T data) {

        ResultData<T> resultData = new ResultData<>();

        resultData.setCode(ResponseCodeEnum.SUCCESS.getCode());

        resultData.setMessage(ResponseCodeEnum.SUCCESS.getMessage());

        resultData.setData(data);

        return resultData;
    }

    public static <T> ResultData<T> error() {

        ResultData<T> resultData = new ResultData<>();

        resultData.setCode(ResponseCodeEnum.RC500.getCode());

        resultData.setMessage(ResponseCodeEnum.RC500.getMessage());

        return resultData;
    }

    public static <T> ResultData<T> error(ResponseCodeEnum responseCodeEnum) {

        ResultData<T> resultData = new ResultData<>();

        resultData.setCode(responseCodeEnum.getCode());

        resultData.setMessage(responseCodeEnum.getMessage());

        return resultData;
    }

    public ResultData<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultData<T> message(String message) {
        this.setMessage(message);
        return this;
    }
}
