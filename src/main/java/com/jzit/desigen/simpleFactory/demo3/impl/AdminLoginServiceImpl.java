package com.jzit.desigen.simpleFactory.demo3.impl;

import com.jzit.desigen.simpleFactory.demo3.bo.SystemEnum;
import com.jzit.desigen.simpleFactory.demo3.service.LoginService;
import com.jzit.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements LoginService {

  @Override
  public SystemEnum getType() {
    return SystemEnum.ADMIN;
  }

  @Override
  public Result doLogin() {
    System.out.println("管理后台登陆");
    return Result.success(true);
  }
}
