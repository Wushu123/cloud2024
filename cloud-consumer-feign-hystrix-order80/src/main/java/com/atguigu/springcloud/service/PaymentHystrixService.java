package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentHystrixService
 * @Description TODO
 * @Author 向日葵
 * @Date 2024/4/10 10:51
 * @Version 1.0
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallBackService.class)
public interface  PaymentHystrixService {
    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id);
    @GetMapping("/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id);
}
