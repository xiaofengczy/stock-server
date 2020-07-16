package com.jzit.desigen.simpleFactory.demo2.impl;

import com.jzit.config.LoginConfig;
import com.jzit.desigen.simpleFactory.demo1.TestService;
import com.jzit.desigen.simpleFactory.demo1.TypeEnum;
import com.jzit.utils.Result;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

  @Resource
  private LoginFactory loginFactory;

  @PostMapping("/login")
  public Result login(HttpServletRequest request, @RequestBody User user) {
    String host = request.getHeader("Host");
    LoginService loginService = loginFactory.getLoginService(host);
    return loginService.doLogin(user);
  }

}
