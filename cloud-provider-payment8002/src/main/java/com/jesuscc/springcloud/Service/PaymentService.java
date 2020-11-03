package com.jesuscc.springcloud.Service;

import com.jesuscc.springcloud.entities.Payment;

/**
 * @author wangcc
 * @create
 */
public interface PaymentService {


    int create(Payment payment);

    Payment getPaymentById(Long id);
}
