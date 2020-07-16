package com.jzit.desigen.simpleFactory.demo3.bo;

import java.util.Objects;

/**
 * 系统枚举，判定请求来源
 */
public enum SystemEnum {
  ADMIN("admin"),
  CLIENT("client"),
  APP("app");

  private String type;

  SystemEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static SystemEnum getByType(String type) {
    for (SystemEnum systemEnum : SystemEnum.values()) {
      if (Objects.equals(systemEnum.getType(), type)) {
        return systemEnum;
      }
    }
    return null;
  }
}
