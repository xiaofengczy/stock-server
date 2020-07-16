package com.jzit.desigen.simpleFactory.demo3.service;


import com.jzit.desigen.simpleFactory.demo3.bo.SystemEnum;
import com.jzit.utils.Result;

/**
 * 用户登陆处理器
 */
public interface LoginService {

  SystemEnum getType();

  Result doLogin();

}
