package com.jesuscc.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangcc
 * @create
 */
public interface PaymentService {

    public String paymentInfo_Ok(Integer id);

    public String paymentInfo_timeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
