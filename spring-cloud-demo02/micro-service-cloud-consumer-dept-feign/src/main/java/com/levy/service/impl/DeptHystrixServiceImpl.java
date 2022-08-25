package com.levy.service.impl;

import org.springframework.stereotype.Component;
import com.levy.service.DeptHystrixService;

/**
 * Hystrix 服务降级
 * 解耦回退逻辑
 *
 * @author liwei515
 */
@Component
public class DeptHystrixServiceImpl implements DeptHystrixService {

  @Override
  public String deptInfoOk(Integer id) {
    return "系统繁忙，请稍后重试！（解耦回退方法触发）";
  }

  @Override
  public String deptInfoTimeout(Integer id) {
    return "系统繁忙，请稍后重试！（解耦回退方法触发）";
  }
}
