package com.choi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by ChoiBin on 2020/3/21
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
