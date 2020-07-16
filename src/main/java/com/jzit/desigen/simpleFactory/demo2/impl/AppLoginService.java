package com.jzit.desigen.simpleFactory.demo2.impl;

import com.jzit.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class AppLoginService implements LoginService {

  @Override
  public HostEnum getType() {
    return HostEnum.APP_TYPE;
  }

  @Override
  public Result doLogin(Object obj) {
    return Result.success("app登陆成功");
  }
}
