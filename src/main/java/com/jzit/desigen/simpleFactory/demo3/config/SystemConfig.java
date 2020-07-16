package com.jzit.desigen.simpleFactory.demo3.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "study.system.host")
@Data
public class SystemConfig {

  private List<String> admin;

  private List<String> client;

  private List<String> app;

}
