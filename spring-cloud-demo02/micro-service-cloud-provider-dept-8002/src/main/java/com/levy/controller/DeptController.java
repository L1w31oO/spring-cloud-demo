package com.levy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.levy.domain.Dept;
import com.levy.service.DeptService;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务提供者的控制器
 *
 * @author liwei515
 */
@RestController
@Slf4j
public class DeptController {

  @Autowired
  private DeptService deptService;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/dept/get/{id}")
  public Dept get(@PathVariable("id") Integer id){
    return deptService.get(id);
  }

  @GetMapping("/dept/list")
  public List<Dept> list(){
    return deptService.selectAll();
  }

}
