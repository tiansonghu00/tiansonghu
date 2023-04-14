package com.jining.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName RestProtectInterceptor
 * @Date 2022/10/29 10:03 PM
 * @Author Goslly
 * @Description 此类未来用做权限处理
 **/
@Slf4j
public class RestProtectInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("request path = {}, source-IP = {}", request.getRequestURL(), getRequestIp(request));
        return true;
    }

    /**
     * 获取 http 请求的源 ip
     *
     * @param request
     * @return java.lang.String
     * @author Goslly
     * @date 1:11 2022/10/30
     **/
    private String getRequestIp(HttpServletRequest request) {
        final String UnknownIP = "unknown";
        final String LoopbackIP = "127.0.0.1";

        String strAddr = null;
        try {
            strAddr = request.getHeader("x-forwarded-for");
            if (strAddr == null || strAddr.length() == 0 || UnknownIP.equalsIgnoreCase(strAddr)) {
                strAddr = request.getHeader("Proxy-Client-IP");
            }
            if (strAddr == null || strAddr.length() == 0 || UnknownIP.equalsIgnoreCase(strAddr)) {
                strAddr = request.getHeader("WL-Proxy-Client-IP");
            }
            if (strAddr == null || strAddr.length() == 0 || UnknownIP.equalsIgnoreCase(strAddr)) {
                strAddr = request.getRemoteAddr();
                if (LoopbackIP.equals(strAddr)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    strAddr = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (strAddr != null && strAddr.length() > 15) {
                if (strAddr.indexOf(",") > 0) {
                    strAddr = strAddr.substring(0, strAddr.indexOf(","));
                }
            }
        } catch (Exception e) {
            strAddr = "";
        }

        return strAddr;
    }

}
