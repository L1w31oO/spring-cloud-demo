package com.levy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author liwei515
 */
@SpringBootApplication
@EnableHystrixDashboard
public class MicroServiceCloudConsumerDeptHystrixDashboard9002Application {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceCloudConsumerDeptHystrixDashboard9002Application.class, args);
  }

}
