package com.jzit.bus;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@MapperScan("com.jzit.bus.dao.mapper")
public class TestController {

  @GetMapping("/stock-service/doTest")
  public Mono<String> testStr(String test){
    return Mono.fromCallable(() -> {
      return JSON.toJSONString("hello:"+test);
    });
  }
}
