package com.choi.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by ChoiBin on 2020/3/28
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService---------paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService---------paymentInfo_Timeout";
    }
}
