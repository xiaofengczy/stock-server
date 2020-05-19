package com.jzit.utils;

/**
 * @author caozhongyu
 * @create 2020-05-19
 */
public enum ResultCode {
  SUCCESS("0000","success"),
  PARAM_IS_INVALID("1001","参数无效"),
  PARAM_IS_BLANK("1002","参数为空"),
  //用户相关
  USER_NO_LOGGED_IN("2001","用户未登录"),
  USER_LOGIN_ERROR("2002","账号不存在或密码错误"),
  USER_NOT_EXIST("2003","用户不存在"),
  USER_HAS_EXISTED("2004","用户已存在");

  private String code;
  private String message;

  ResultCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String code(){
    return this.code;
  }
  public String message(){
    return this.message;
  }
}
