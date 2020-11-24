package com.jesuscc.springcloud.Controller;/**
 * @author wangcc
 * @create
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Author wangcc
 * @Date 17:16 2020/11/3
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentzk(){
        return "springboot with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
