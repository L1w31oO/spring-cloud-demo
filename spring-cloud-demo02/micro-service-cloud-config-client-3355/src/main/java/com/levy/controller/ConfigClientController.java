package com.levy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取配置中心指定配置文件的内容，并展示到页面
 *
 * @author liwei515
 */
@RestController
public class ConfigClientController {

  @Value("${server.port}")
  private String serverPort;

  @Value("${config.info}")
  private String configInfo;

  @Value("${config.version}")
  private String configVersion;

  @GetMapping(value = "/getConfig")
  public String getConfig() {
    return "info：" + configInfo + "<br/>version：" + configVersion + "<br/>port：" + serverPort;
  }
}
