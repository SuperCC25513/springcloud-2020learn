package com.jesuscc.springcloud.config;
/**
 * @author wangcc
 * @create
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author wangcc
 * @Date 18:45 2020/11/3
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getrestTemplate(){
        return new RestTemplate();
    }

}
