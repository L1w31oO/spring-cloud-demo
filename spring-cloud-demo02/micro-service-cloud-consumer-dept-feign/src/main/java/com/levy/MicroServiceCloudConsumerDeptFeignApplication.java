package com.levy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwei515
 */
@SpringBootApplication
@EnableFeignClients  // 开启 OpenFeign 功能
public class MicroServiceCloudConsumerDeptFeignApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceCloudConsumerDeptFeignApplication.class, args);
  }

}
