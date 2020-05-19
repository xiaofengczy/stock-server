package com.jzit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author milk
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StockApplication {
  public static void main(String[] args) {
    SpringApplication.run(StockApplication.class);
  }

  @Bean
  public KeyResolver methodKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getMethod().name());
  }

  @Bean
  @LoadBalanced
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ReactiveRedisTemplate reactiveRedisTemplate(
      ReactiveRedisConnectionFactory factory) {
    return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
  }

}
