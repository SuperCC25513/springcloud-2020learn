package com.jesuscc.springcloud.Controller;/**
 * @author wangcc
 * @create
 */

import com.jesuscc.springcloud.entities.CommonResult;
import com.jesuscc.springcloud.entities.Payment;
import com.jesuscc.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URL;
import java.util.List;

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
    @Resource
    private LoadBalancer loadBalanced;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create( Payment payment) {
        return restTemplate.postForObject(Payment_Url + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaumentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(Payment_Url + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/lb")
    private String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(null == instances || instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalanced.instances(instances);
        URI url = serviceInstance.getUri();
        return restTemplate.getForObject(url + "/payment/lb", String.class);
    }
}
