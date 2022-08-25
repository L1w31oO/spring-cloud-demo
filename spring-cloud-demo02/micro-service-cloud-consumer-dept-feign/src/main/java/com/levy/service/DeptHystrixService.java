package com.levy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.levy.service.impl.DeptHystrixServiceImpl;

/**
 * @author liwei515
 */
@Component
@FeignClient(value = "MICROSERVICECLOUDPROVIDERDEPTHYSTRIX", fallback = DeptHystrixServiceImpl.class)
public interface DeptHystrixService {

  @RequestMapping(value = "/dept/hystrix/ok/{id}")
  String deptInfoOk(@PathVariable("id") Integer id);

  @RequestMapping(value = "/dept/hystrix/timeout/{id}")
  String deptInfoTimeout(@PathVariable("id") Integer id);
}
