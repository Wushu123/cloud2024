//package com.atguigu.springcloud.config;
//
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @ClassName MyLB
// * @Description TODO
// * @Author 向日葵
// * @Date 2024/4/9 15:13
// * @Version 1.0
// **/
//@Component//需要跟主启动类同包，或者在其子孙包下。
//public class MyLB implements LoadBalancer{
//    private AtomicInteger atomicInteger = new AtomicInteger(0);
//
//
//    private final int getAndIncrement(){
//        int current;
//        int next;
//        do{
//            current = this.atomicInteger.get();
//            next = current>=2147483647?0:current+1;
//        }while(!this.atomicInteger.compareAndSet(current,next));
//            System.out.println("*****第几次访问，次数next: "+next);
//            return next;
//    }
//    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
//    @Override
//    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
//        int index = getAndIncrement() % serviceInstances.size();
//        return serviceInstances.get(index);
//    }
//}
