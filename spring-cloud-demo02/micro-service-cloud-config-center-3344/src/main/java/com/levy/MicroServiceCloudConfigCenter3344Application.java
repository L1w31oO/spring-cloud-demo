package com.levy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author liwei515
 */
@SpringBootApplication
@EnableConfigServer  // 开启 Spring Cloud Config 配置中心功能
public class MicroServiceCloudConfigCenter3344Application {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceCloudConfigCenter3344Application.class, args);
  }

}
