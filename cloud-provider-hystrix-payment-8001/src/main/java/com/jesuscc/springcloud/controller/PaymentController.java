package com.jesuscc.springcloud.controller;
/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Author wangcc
 * @Date 17:33 2020/12/9
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String  paymentInfo_Ok(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Ok(id);
        log.info(result);
        return result;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_timeOut(id);
        log.info(result);
        return result;
    }

    //====服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
