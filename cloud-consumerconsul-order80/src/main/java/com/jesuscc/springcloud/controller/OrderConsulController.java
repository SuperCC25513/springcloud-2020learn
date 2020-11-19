package com.jesuscc.springcloud.controller;/**
 * @author wangcc
 * @create
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderConsulController
 * @Author wangcc
 * @Date 15:00 2020/11/19
 **/
@RestController
@Slf4j
public class OrderConsulController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL="http://consul-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public  String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }

}
