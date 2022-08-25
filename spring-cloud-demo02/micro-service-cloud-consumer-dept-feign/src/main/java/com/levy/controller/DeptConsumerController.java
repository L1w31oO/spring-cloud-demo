package com.levy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.levy.domain.Dept;
import com.levy.service.DeptFeignService;

/**
 * @author liwei515
 */
@RestController
public class DeptConsumerController {

  @Autowired
  private DeptFeignService deptFeignService;

  @GetMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Integer id){
    return deptFeignService.get(id);
  }

  @GetMapping("/consumer/dept/list")
  public List<Dept> list(){
    return deptFeignService.list();
  }

  @RequestMapping("/consumer/dept/feign/timeout")
  public String deptFeignTimeout(){
    // openFeign-ribbon 客户端一般默认等待一秒钟，超过该时间就会报错
    return deptFeignService.deptFeignTimeout();
  }

}
