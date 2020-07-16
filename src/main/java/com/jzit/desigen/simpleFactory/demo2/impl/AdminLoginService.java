package com.jzit.desigen.simpleFactory.demo2.impl;

import com.jzit.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService implements LoginService {

  @Override
  public HostEnum getType() {
    return HostEnum.ADMIN_TYPE;
  }

  @Override
  public Result doLogin(Object obj) {
    return Result.success("管理后台登陆成功");
  }
}
