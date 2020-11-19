package com.jesuscc.springcloud.Controller;/**
 * @author wangcc
 * @create
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderZKController
 * @Author wangcc
 * @Date 18:47 2020/11/3
 **/
@RestController
@Slf4j
public class OrderZKController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public  String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
