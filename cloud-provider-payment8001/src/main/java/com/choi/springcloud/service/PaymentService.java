package com.choi.springcloud.service;

import com.choi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ChoiBin on 2020/3/13
 */
public interface PaymentService {


    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
