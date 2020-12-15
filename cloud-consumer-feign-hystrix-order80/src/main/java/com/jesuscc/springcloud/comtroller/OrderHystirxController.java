package com.jesuscc.springcloud.comtroller;
/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.entities.CommonResult;
import com.jesuscc.springcloud.entities.Payment;
import com.jesuscc.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderHystirxController
 * @Author wangcc
 * @Date 14:59 2020/12/15
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentTimeOutGlobalFallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return  result;
    }



    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return  result;
    }
    //全局fallback方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }


    public String paymentTimeOutGlobalFallbackMethod()
    {
        return "Global 异常处理信息，请稍后再试";
    }


}
