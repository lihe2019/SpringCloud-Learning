package com.lihe.springcloud.config;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  // 相当于spring  applicationContext.xml 中的bean
public class ConfigBean {

    // 配置负载均衡实现RestTemplate
    // IRule 的实现类就是所有的策略，当然也可以实现IRule自己写 （实际上是继承AbstractLoadBalancerRule）
    //AvailabilityFilteringRule ： 会先过滤掉跳闸（访问故障）的服务，对剩下的进行轮询
    // RoundRobinRule 轮询
    // 随机 RandomRule 随机
    //RetryRule 先轮询，失败，则在指定的时间内重试

    @LoadBalanced //ribbon
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myIRule(){
        return new RandomRule();
    }



}
