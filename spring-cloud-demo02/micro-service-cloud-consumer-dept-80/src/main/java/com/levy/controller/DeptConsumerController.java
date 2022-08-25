package com.levy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.levy.domain.Dept;

/**
 * @author liwei515
 */
@RestController
public class DeptConsumerController {

  /**
   * 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
   */
  private static final String REST_URL_PROVIDER_PREFIX = "http://MICROSERVICECLOUDPROVIDERDEPT";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Integer id){
    return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/get/" + id, Dept.class);
  }
  @GetMapping("/consumer/dept/list")
  public List<Dept> list(){
    return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/list", List.class);
  }
}
