package com.jzit.dao.entity;

import lombok.Data;

/**
 * FileName: User Description:
 *
 * @author milk
 * @create 2020/7/1
 */
@Data
public class User {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}