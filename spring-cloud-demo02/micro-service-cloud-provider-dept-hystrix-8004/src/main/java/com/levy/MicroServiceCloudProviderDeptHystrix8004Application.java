package com.levy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liwei515
 */
@SpringBootApplication
@EnableEurekaClient  // 开启 Eureka 客户端功能
@EnableCircuitBreaker  // 激活熔断器功能
public class MicroServiceCloudProviderDeptHystrix8004Application {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceCloudProviderDeptHystrix8004Application.class, args);
  }

}
