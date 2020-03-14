package com.choi.springcloud.service.impl;

import com.choi.springcloud.dao.PaymentDao;
import com.choi.springcloud.entities.Payment;
import com.choi.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ChoiBin on 2020/3/13
 */
@Service
public class PaymenntServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
