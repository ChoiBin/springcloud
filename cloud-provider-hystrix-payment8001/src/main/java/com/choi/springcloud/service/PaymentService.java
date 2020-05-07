package com.choi.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.concurrent.TimeUnit;

/**
 * Created by ChoiBin on 2020/3/26
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：" +Thread.currentThread().getName() + "paymentInfo_OK,id " + id + "\t";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        int age = 10 / 0;
        int time = 4;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" +Thread.currentThread().getName() + "paymentInfo_OK,id " + id + "\t" +"耗时:" + time;
    }

    public String paymentInfo_TimeoutHandler(Integer id){

        return "线程池：" +Thread.currentThread().getName() + "8001系统繁忙，请稍后再试，paymentInfo_TimeoutHandler,id " + id ;
    }

    /**
     *
     * 服务熔断
     *
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id < 0){
            throw new RuntimeException("---id不能为负数");
        }

        String num = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号为：" + num;
    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能为负数，请稍后再试！！" + "id:" + id;
    }


}
