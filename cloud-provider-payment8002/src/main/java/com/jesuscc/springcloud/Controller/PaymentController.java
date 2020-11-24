package com.jesuscc.springcloud.Controller;/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.Service.PaymentService;
import com.jesuscc.springcloud.entities.CommonResult;
import com.jesuscc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName PaymentController
 * @Author wangcc
 * @Date 14:05 2020/10/28
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private  String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("****插入结果：" + i);

        if(i>0){
            return new CommonResult(200, "插入数据库成功,serverPort "+serverPort, i);
        }else{
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果：" + payment);

        if(payment !=null ){
            return new CommonResult(200, "查询就数据库成功,serverPort "+serverPort, payment);
        }else{
            return new CommonResult(444, "没有对应的记录，查询ID："+id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
