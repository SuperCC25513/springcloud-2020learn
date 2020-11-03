package com.jesuscc.springcloud.Controller;/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.entities.CommonResult;
import com.jesuscc.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author wangcc
 * @Date 15:37 2020/10/28
 **/
@RestController
public class OrderController {

//    public static final String Payment_Url = "http://localhost:8001";
    public static final String Payment_Url = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create( Payment payment) {
        return restTemplate.postForObject(Payment_Url + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaumentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(Payment_Url + "/payment/get/" + id, CommonResult.class);
    }
}
