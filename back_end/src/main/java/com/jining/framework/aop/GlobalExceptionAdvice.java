package com.jining.framework.aop;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jining.dto.WebResult;
import com.jining.errors.ErrorCodeEnum;
import com.jining.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @ClassName GlobalExceptionAdvice
 * @Date 2022/10/29 5:12 PM
 * @Author Goslly
 * @Description 对 controller 层没有捕获的异常进行统一处理
 **/

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    /**
     * 通用异常处理方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public WebResult error(Exception e) {
        log.error(" an uncaught exception occurs.", e);
        return WebResult.fail().data(e.getMessage());
    }

    /**
     * 指定处理空指针异常方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public WebResult error(NullPointerException e) {
        log.error(" an un caught nullPointerException occurs.", e);
        return WebResult.fail(ErrorCodeEnum.NULL_POINT);
    }

    /**
     * 指定处理空http-4xx方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public WebResult error(HttpClientErrorException e) {
        log.error(" an un caught httpClientErrorException occurs.", e);
        return WebResult.fail(ErrorCodeEnum.HTTP_CLIENT_ERROR);
    }

    /**
     * 自定义定异常处理方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public WebResult error(BizException e) {
        log.error(" an un caught Exception occurs.", e);
        return WebResult.fail().message(e.getMessage()).code(e.getCode());
    }


    /**
     * Http请求读取失败处理
     *
     * @param e
     * @return com.liangshangang.dto.WebResult
     * @author Goslly
     * @date 23:43 2022/10/29
     **/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public WebResult error(HttpMessageNotReadableException e) {
        // 获取Cause
        Throwable cause = e.getCause();

        // 类别判断
        if (cause instanceof InvalidFormatException) {
            // 由JSON解析错误(Bad Argument)引起的Http请求读取失败
            InvalidFormatException invalidFormatException = (InvalidFormatException) cause;
            log.error("JSON parse failed since the Bad Argument of Type: {}, Value: {}.",
                    invalidFormatException.getValue().getClass().getName(),
                    invalidFormatException.getValue().toString());
            return WebResult.fail(ErrorCodeEnum.PARAM_ERROR);
        } else {
            // 其余原因引起, 重新抛出
            throw e;
        }
    }


}