package com.jining.exception;

import com.jining.errors.ErrorCodeEnum;
import lombok.Data;

/**
 * @ClassName BizException
 * @Date 2022/10/29 5:26 PM
 * @Author Goslly
 * @Description 自定义业务异常类的父类，业务中所有自定义的异常，都需要继承该类
 **/
@Data
public class BizException extends RuntimeException {

    /**
     * 自定义异常错误码
     */
    int code;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ErrorCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "BizException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
