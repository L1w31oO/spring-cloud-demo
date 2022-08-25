package com.levy.service;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.levy.domain.Dept;

//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDERDEPT")
public interface DeptFeignService {

  /**
   * 对应服务提供者（8001、8002、8003）Controller 中定义的方法
   */
  @GetMapping(value = "/dept/get/{id}")
  Dept get(@PathVariable("id") int id);

  /**
   * 对应服务提供者（8001、8002、8003）Controller 中定义的方法
   */
  @GetMapping(value = "/dept/list")
  List<Dept> list();

  /**
   * 对应服务提供者（8001、8002、8003）Controller 中定义的方法
   */
  @RequestMapping("/dept/feign/timeout")
  String deptFeignTimeout();
}
