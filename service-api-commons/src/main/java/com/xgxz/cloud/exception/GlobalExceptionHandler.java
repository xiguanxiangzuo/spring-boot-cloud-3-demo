package com.xgxz.cloud.exception;

import com.xgxz.cloud.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.xgxz.cloud.exception
 * Description:
 *
 * @Author 习惯向左
 * @Create 2024/3/17 12:00
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {

        log.error("全局异常信息: {}", e.getMessage());
        log.error(String.valueOf(e));

        return ResultData.error();
    }

}
