package com.jesuscc.springcloud.service;

import com.jesuscc.springcloud.entities.CommonResult;
import com.jesuscc.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangcc
 * @create
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


     @GetMapping(value = "/payment/feign/timeout")
     public String paymentFeignTimeout();

     @GetMapping("/payment/get/{id}")
     public CommonResult<Payment> getPaumentById(@PathVariable("id") Long id);
}
