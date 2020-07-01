package com.jzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author milk
 */
@SpringBootApplication
@MapperScan("com.jzit.dao.mapper")
public class StockApplication {
  public static void main(String[] args) {
    SpringApplication.run(StockApplication.class);
  }
}
