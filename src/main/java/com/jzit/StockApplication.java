package com.jzit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author milk
 */
@SpringBootApplication
public class StockApplication {
  public static void main(String[] args) {
    SpringApplication.run(StockApplication.class);
  }

//  @Bean
//  public KeyResolver methodKeyResolver() {
//    return exchange -> Mono.just(exchange.getRequest().getMethod().name());
//  }
//
//  @Bean
//  @LoadBalanced
//  public WebClient.Builder webClientBuilder() {
//    return WebClient.builder();
//  }
//
//  @Bean
//  @LoadBalanced
//  public RestTemplate restTemplate() {
//    return new RestTemplate();
//  }
//
//  @Bean
//  ReactiveRedisTemplate reactiveRedisTemplate(
//      ReactiveRedisConnectionFactory factory) {
//    return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
//  }

}
