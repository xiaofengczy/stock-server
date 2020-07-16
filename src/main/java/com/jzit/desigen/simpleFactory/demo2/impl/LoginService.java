package com.jzit.desigen.simpleFactory.demo2.impl;

import com.jzit.utils.Result;

public interface LoginService {

  HostEnum getType();

  Result doLogin(Object obj);

}
