package com.choi.springcloud.service;

import com.choi.springcloud.entities.Payment;

/**
 * Created by ChoiBin on 2020/3/13
 */
public interface PaymentService {


    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
