package com.choi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ChoiBin on 2020/3/13
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced  //赋予负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
