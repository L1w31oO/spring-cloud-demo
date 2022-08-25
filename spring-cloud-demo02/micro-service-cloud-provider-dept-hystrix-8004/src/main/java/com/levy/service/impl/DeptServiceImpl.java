package com.levy.service.impl;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import com.levy.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * @author liwei515
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

  @Override
  public String deptInfoOk(Integer id) {
    return "线程池：" + Thread.currentThread().getName() + "deptInfoOk, id: " + id;
  }

  /**
   * HystrixCommand 注解，该注解说明如下：
   *    参数 fallbackMethod 属性用于指定降级方法。
   *    参数 execution.isolation.thread.timeoutInMilliseconds 用于设置自身调用超时时间的峰值，峰值内可以正常运行，否则执行降级方法
   */
  @HystrixCommand(
      fallbackMethod = "deptTimeoutHandler",
      commandProperties = {
          // 规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
      })
  @Override
  public String deptInfoTimeout(Integer id) {
    int outTime = 6;
    try {
      TimeUnit.SECONDS.sleep(outTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池：" + Thread.currentThread().getName() + "  deptInfoTimeout, id: " + id + ", 耗时: " + outTime;
  }

  /**
   * 当服务出现故障后，调用该方法给出友好提示
   */
  public String deptTimeoutHandler(Integer id) {
    return "系统繁忙请稍后再试！" + "线程池：" + Thread.currentThread().getName() + ", deptInfoTimeout, id: " + id;
  }
}
