package com.jzit.desigen.simpleFactory.demo2.impl;

import com.jzit.config.LoginConfig;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LoginFactory implements ApplicationContextAware {

  private static Map<HostEnum, LoginService> loginServiceMap;

  @Resource
  private LoginConfig loginConfig;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, LoginService> map = applicationContext.getBeansOfType(LoginService.class);
    loginServiceMap = new ConcurrentHashMap<>();
    map.forEach((key, value) -> loginServiceMap.put(value.getType(), value));
  }

  public LoginService getLoginService(String host) {
    if (Objects.equals(loginConfig.getAdmin(), host)) {
      return loginServiceMap.get(HostEnum.ADMIN_TYPE);
    } else if (Objects.equals(loginConfig.getClient(), host)) {
      return loginServiceMap.get(HostEnum.CLIENT_TYPE);
    } else if (Objects.equals(loginConfig.getApp(), host)) {
      return loginServiceMap.get(HostEnum.APP_TYPE);
    }
    return null;
  }
}
