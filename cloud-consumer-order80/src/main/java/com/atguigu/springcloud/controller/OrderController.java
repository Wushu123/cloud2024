package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 向日葵
 * @Date 2024/4/8 15:05
 * @Version 1.0
 **/
@Slf4j
@RestController
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

//    @Resource
//    private LoadBalancer loadBalancer;

//    @Resource
//    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

//    @GetMapping(value = "/consumer/payment/lb")
//    public String getPaymentLB() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//
//        if (instances == null || instances.size() <= 0) {
//            return null;
//        }
//
//        ServiceInstance serviceInstance = loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//
//        return restTemplate.getForObject(uri + "/payment/lb", String.class);
//
//    }

}

