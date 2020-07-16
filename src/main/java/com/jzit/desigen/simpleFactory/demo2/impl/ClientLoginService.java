package com.jzit.desigen.simpleFactory.demo2.impl;

import com.jzit.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class ClientLoginService implements LoginService {

  @Override
  public HostEnum getType() {
    return HostEnum.CLIENT_TYPE;
  }

  @Override
  public Result doLogin(Object obj) {
    return Result.success("用户后台登陆成功");
  }
}
