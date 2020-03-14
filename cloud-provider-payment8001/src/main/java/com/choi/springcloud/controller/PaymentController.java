package com.choi.springcloud.controller;

import com.choi.springcloud.entities.CommonResult;
import com.choi.springcloud.entities.Payment;
import com.choi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by ChoiBin on 2020/3/13
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        log.info("-----插入结果：" + result);

        if(result > 0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(400,"插入失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        log.info("-----插入结果：" + payment);

        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(400,"查询失败，查询id:" + id,null);
        }
    }
}
