package com.jesuscc.springcloud;/**
 * @author wangcc
 * @create
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentMain8004
 * @Author wangcc
 * @Date 17:14 2020/11/3
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMainzk8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMainzk8004.class, args);
    }
}
