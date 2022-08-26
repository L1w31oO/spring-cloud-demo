package com.levy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liwei515
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCloudConfigClient3366Application {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceCloudConfigClient3366Application.class, args);
  }

}
