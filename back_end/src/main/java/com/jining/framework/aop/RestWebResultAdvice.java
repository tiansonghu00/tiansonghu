package com.jining.framework.aop;

import com.jining.dto.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName RestResultAdvice
 * @Date 2022/10/29 5:46 PM
 * @Author Goslly
 * @Description 拦截 RestController 注解类的方法返回值，并统一处理
 **/

@Slf4j
@RestControllerAdvice
public class RestWebResultAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getParameterType() != WebResult.class;
    }

    /**
     * 如果业务函数返回的就是 WebResult，不再进行二次包装；否则需要包装为 WebResult 类型再进行返回
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return java.lang.Object
     * @author Goslly
     * @date 23:40 2022/10/29
     **/
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return WebResult.ok().data(body);

    }
}
