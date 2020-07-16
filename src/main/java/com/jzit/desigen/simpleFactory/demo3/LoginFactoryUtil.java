package com.jzit.desigen.simpleFactory.demo3;

import com.jzit.desigen.simpleFactory.demo3.bo.SystemEnum;
import com.jzit.desigen.simpleFactory.demo3.config.SystemConfig;
import com.jzit.desigen.simpleFactory.demo3.service.LoginService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LoginFactoryUtil implements ApplicationContextAware {

  //用户保存对象实例
  private static Map<SystemEnum, LoginService> loginServiceMap;

  @Resource
  private SystemConfig systemConfig;

  /**
   * 从spring中获取所有loginService
   *
   * @param applicationContext
   * @throws BeansException
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, LoginService> map = applicationContext.getBeansOfType(LoginService.class);
    loginServiceMap = new ConcurrentHashMap<>();
    map.forEach((name, loginService) -> loginServiceMap.put(loginService.getType(), loginService));
  }

  /**
   * 简单工厂模式应用: 根据不同host，获取对应的loginService
   */
  public LoginService getLoginServiceByHost(String host) {
    SystemEnum systemEnum = processHost(host);
    return loginServiceMap.get(systemEnum);
  }

  private SystemEnum processHost(String host) {
    //管理后台
    if (systemConfig.getAdmin().contains(host)) {
      return SystemEnum.ADMIN;
    }
    //用户后台
    else if (systemConfig.getClient().contains(host)) {
      return SystemEnum.CLIENT;
    }
    //app
    else if (systemConfig.getApp().contains(host)) {
      return SystemEnum.APP;
    }
    throw new RuntimeException("【loginError】 system host error");
  }

}
