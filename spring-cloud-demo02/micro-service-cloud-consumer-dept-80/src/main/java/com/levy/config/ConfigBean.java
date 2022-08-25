package com.levy.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @author liwei515
 */
@Configuration  // 配置类注解
public class ConfigBean {

  /**
   * 将 RestTemplate 注入到容器中
   * 在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
   *
   * @return RestTemplate
   */
  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }


  /**
   * 切换负载均衡策略
   *
   * @return 负载均衡策略
   */
  @Bean
  public IRule rule() {
    // RandomRule 为随机策略
    return new RandomRule();
  }

}
