package com.jesuscc.springcloud.service.Impl;
/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
