package com.lihe.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient

@ComponentScan("com.lihe.springcloud")
@EnableFeignClients(basePackages = {"com.lihe.springcloud"})
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = LiheRule.class) // 在微服务启动的时候就能够去加载我们自定义的Ribbon类，
// 这个类要放在另外的包中， 否则会自动扫描
// Ribbon和Eureka整合之后，不需要端口号，直接调用方法
public class DeptConsumer_feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class,args);
    }
}
