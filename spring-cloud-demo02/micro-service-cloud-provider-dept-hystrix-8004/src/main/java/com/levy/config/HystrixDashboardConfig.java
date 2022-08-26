package com.levy.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * @author liwei515
 */
@Configuration
public class HystrixDashboardConfig {
  /**
   *  Hystrix dashboard 监控界面必须配置
   *
   * @return ServletRegistrationBean
   */
  @Bean
  public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);
    // 访问路径
    registrationBean.addUrlMappings("/actuator/hystrix.stream");
    registrationBean.setName("hystrix.stream");
    return registrationBean;
  }
}