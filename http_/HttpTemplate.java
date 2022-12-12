package com.tian.http_;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings({"all"})
public class HttpTemplate {

    public static String httpGet(String url){
        RestTemplate restTemplate=new RestTemplate();
        String result=restTemplate.exchange(url, HttpMethod.GET,null,String.class).getBody();
        return result;
    }

    public static String httpPost(String url,String name){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.postForEntity(url,name,String.class).getBody();
    }

    public static void main(String str[]){
        //System.out.println(HttpTemplate.httpGet("http://localhost:8080/test"));
        System.out.println(HttpTemplate.httpPost("http://localhost:8080/testPost1","ming"));
    }
}