package com.jesuscc.springcloud.controller;/**
 * @author wangcc
 * @create
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Author wangcc
 * @Date 14:42 2020/11/19
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentzk(){
        return "springboot with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
