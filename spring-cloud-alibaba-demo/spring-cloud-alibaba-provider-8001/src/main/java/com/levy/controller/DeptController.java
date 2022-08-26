package com.levy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liwei515
 */
@RestController
@Slf4j
public class DeptController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/dept/nacos/{id}")
  public String getPayment(@PathVariable("id") Integer id){
    return "<h2>服务访问成功！</h2>服务名：spring-cloud-alibaba-provider<br /> 端口号： " + serverPort + "<br /> 传入的参数：" + id;
  }
}
