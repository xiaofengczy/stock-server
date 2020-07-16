package com.jzit.desigen.simpleFactory.demo3.impl;

import com.jzit.desigen.simpleFactory.demo3.bo.SystemEnum;
import com.jzit.desigen.simpleFactory.demo3.service.LoginService;
import com.jzit.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class AppLoginServiceImpl implements LoginService {

  @Override
  public SystemEnum getType() {
    return SystemEnum.APP;
  }

  @Override
  public Result doLogin() {
    System.out.println("app登陆成功");
    return Result.success(true);
  }
}
