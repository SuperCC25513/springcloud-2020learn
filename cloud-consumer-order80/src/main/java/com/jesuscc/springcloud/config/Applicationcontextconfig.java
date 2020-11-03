package com.jesuscc.springcloud.config;/**
 * @author wangcc
 * @create
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName Applicationcontextconfig
 * @Author wangcc
 * @Date 15:34 2020/10/28
 **/
@Configuration
public class Applicationcontextconfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
