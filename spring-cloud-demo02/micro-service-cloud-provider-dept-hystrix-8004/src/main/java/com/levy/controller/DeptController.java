package com.levy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.levy.service.DeptService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liwei515
 */
@RestController
@Slf4j
public class DeptController {

  @Autowired
  private DeptService deptService;

  @Value("server.port")
  private String serverPort;

  @RequestMapping(value = "/dept/hystrix/ok/{id}")
  public String deptInfoOk(@PathVariable("id") Integer id) {
    String result = deptService.deptInfoOk(id);
    log.info("端口号：" + serverPort + " result:" + result);
    return result + "， 端口号：" + serverPort;
  }

  /**
   * Hystrix 服务超时降级
   */
  @RequestMapping(value = "/dept/hystrix/timeout/{id}")
  public String deptInfoTimeout(@PathVariable("id") Integer id) {
    String result = deptService.deptInfoTimeout(id);
    log.info("端口号：" + serverPort + " result:" + result);
    return result + "，端口号：" + serverPort;
  }
}
