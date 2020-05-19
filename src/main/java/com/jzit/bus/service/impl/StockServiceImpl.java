package com.jzit.bus.service.impl;

import com.jzit.bus.service.StockService;
import com.jzit.dto.AddTraderReq;
import com.jzit.utils.Result;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * FileName: StockServiceImpl Description:
 *
 * @author milk
 * @create 2020/5/19
 */
@Service
public class StockServiceImpl implements StockService {

  @Resource
  private ReactiveMongoTemplate reactiveMongoTemplate;

  @Override
  public Mono<Result> addTrader(AddTraderReq addTraderReq) {
    Mono<AddTraderReq> result = reactiveMongoTemplate.save(addTraderReq);
    return result.map(Result::success);
  }
}