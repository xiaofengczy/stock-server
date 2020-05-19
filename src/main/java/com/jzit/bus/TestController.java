package com.jzit.bus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  @GetMapping("/test")
  public Mono<String> testStr(String test){
    return Mono.fromCallable(() -> {
      System.out.println(test);
      return "server:"+test;
    });
  }
}
