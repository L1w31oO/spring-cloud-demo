package com.levy.service;

/**
 * @author liwei515
 */
public interface DeptService {

  /**
   * hystrix 熔断器示例 ok
   */
  String deptInfoOk(Integer id);

  /**
   * hystrix 熔断器超时案例
   */
  String deptInfoTimeout(Integer id);

  /**
   * Hystrix 熔断机制案例
   */
  String deptCircuitBreaker(Integer id);
}
