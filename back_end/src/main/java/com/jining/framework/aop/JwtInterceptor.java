package com.jining.framework.aop;

import com.jining.errors.ErrorCodeEnum;
import com.jining.exception.BizException;
import com.jining.utils.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 程宇航
 * @version 1.0
 * @date 2022-12-08 19:44
 * @description
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("token");

        // token不存在时，返回信息
        if (token == null) {
            throw new BizException(ErrorCodeEnum.TOKEN_NONE);
        }
        // 对token进行验证,验证
        if (!JwtUtil.checkToken(token)) {
            throw new BizException(ErrorCodeEnum.TOKEN_FAIL_VERIFY);
        }
        // 判断token是否过期
        if(JwtUtil.isExpiration(token)){
            throw new BizException(ErrorCodeEnum.TOKEN_OVERDUE);
        }
        return true;
    }
}
