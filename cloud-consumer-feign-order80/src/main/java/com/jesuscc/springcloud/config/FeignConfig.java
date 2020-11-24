package com.jesuscc.springcloud.config;/**
 * @author wangcc
 * @create
 */

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @ClassName FeignConfig
 * @Author wangcc
 * @Date 11:08 2020/11/24
 **/
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
