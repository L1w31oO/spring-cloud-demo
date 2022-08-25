package com.levy.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.levy.service.DeptHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liwei515
 */
@Slf4j
@RestController
public class HystrixConsumerController {
  @Resource
  private DeptHystrixService deptHystrixService;
  @RequestMapping(value = "/consumer/dept/hystrix/ok/{id}")
  public String deptInfoOk(@PathVariable("id") Integer id) {
    return deptHystrixService.deptInfoOk(id);
  }
  //在客户端进行降级
  @RequestMapping(value = "/consumer/dept/hystrix/timeout/{id}")
  @HystrixCommand(fallbackMethod = "deptTimeoutHandler") // 为该请求指定专属的回退方法
  public String deptInfoTimeout(@PathVariable("id") Integer id) {
    String s = deptHystrixService.deptInfoTimeout(id);
    log.info(s);
    return s;
  }
  // deptInfo_Timeout方法的 专用 fallback 方法
  public String deptTimeoutHandler(@PathVariable("id") Integer id) {
    log.info("deptInfoTimeout 出错，服务已被降级！");
    return "服务端系统繁忙，请稍后再试！（客户端 deptInfoTimeout 专属的回退方法触发）";
  }
}
