package com.atguigu.springcloud.config;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Description TODO
 * @Author 向日葵
 * @Date 2024/4/9 16:40
 * @Version 1.0
 **/
@Configuration
public class FeignConfig {
   @Bean
   public Logger.Level feignLoggerLevel(){
       //NONE:不记录任何信息
       //BASIC:仅记录请求方法、URL以及响应状态码和执行时间
       //HEADERS:记录请求和响应的头信息
       //FULL:记录所有请求与响应的明细，包括头信息、请求体、元数据
       return Logger.Level.FULL;
   }
}
