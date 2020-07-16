package com.jzit.desigen.simpleFactory.demo3.controller;

import com.jzit.desigen.simpleFactory.demo3.LoginFactoryUtil;
import com.jzit.desigen.simpleFactory.demo3.service.LoginService;
import com.jzit.utils.Result;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Controller
public class LoginController1 {

  @Resource
  private LoginFactoryUtil loginFactoryUtil;

  @PostMapping("/login")
  public Result login(HttpServletRequest request) {
    String host = request.getHeader("Host");
    LoginService loginService = loginFactoryUtil.getLoginServiceByHost(host);
    return loginService.doLogin();
  }

}
