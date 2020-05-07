package com.choi.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

/**
 * Created by ChoiBin on 2020/3/26
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix8001.class,args);
    }


    /**
     * 此配置是为了服务监控的配置，与服务器本身无关，springcloud升级后的坑。
     *
     * ServletRegistrationBean是因为spring boot的默认路径不是/hystrix.stream
     * 只要再自己的项目下配置上下面的servlet就可以
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
         registrationBean.setLoadOnStartup(1);
         registrationBean.addUrlMappings("/hystrix.stream");
         registrationBean.setName("HystrixMetricsStremServlet");
         return registrationBean;
    }

    //http://localhost:9001/hystrix

    //http://localhost:8001/hystrix.stream

    //2000 ms
}
