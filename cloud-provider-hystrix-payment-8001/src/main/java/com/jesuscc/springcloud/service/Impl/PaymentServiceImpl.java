package com.jesuscc.springcloud.service.Impl;
/**
 * @author wangcc
 * @create
 */

import cn.hutool.core.util.IdUtil;
import com.jesuscc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentServiceImpl
 * @Author wangcc
 * @Date 14:48 2020/12/9
 **/
@Service
public class PaymentServiceImpl implements PaymentService {



    @Override
    public String paymentInfo_Ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id: " +id +"\tO(∩_∩)O哈哈~";
    }
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeOut(Integer id) {
//        int age = 10 / 0;
        try {
            int timeNumber = 3;
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙货运行报错,id: " +id +"\tO(∩_∩)O哈哈~ +  耗时3秒钟";
    }


    public String paymentInfo_timeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeOutHandler,id: " +id +"\to(╥﹏╥)o";
    }

    // 服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw  new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return  Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数,请稍后再试， o(╥﹏╥)o id: " + id;
    }
}
