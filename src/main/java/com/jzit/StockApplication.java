package com.jzit;

import com.jzit.config.LoginConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author milk
 */
@SpringBootApplication
@MapperScan("com.jzit.dao.mapper")
@EnableConfigurationProperties({LoginConfig.class})
public class StockApplication {
  public static void main(String[] args) {
    SpringApplication.run(StockApplication.class);
  }
}
