package com.jining.framework.annos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName RestResult
 * @Date 2022/10/29 5:12 PM
 * @Author Goslly
 * @Description 给需要进行 Rest 返回结果标准化的方法加上该注解
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestResult {

}
