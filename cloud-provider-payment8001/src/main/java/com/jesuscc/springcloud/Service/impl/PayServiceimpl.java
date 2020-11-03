package com.jesuscc.springcloud.Service.impl;/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.Service.PaymentService;
import com.jesuscc.springcloud.dao.PaymentDao;
import com.jesuscc.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PayServiceimp
 * @Author wangcc
 * @Date 14:00 2020/10/28
 **/
@Service
public class PayServiceimpl implements PaymentService {

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
