package com.jzit.bus.controller;

import com.alibaba.fastjson.JSON;
import com.jzit.bus.service.StockService;
import com.jzit.dto.AddTraderReq;
import com.jzit.utils.Result;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * FileName: StockController Description:
 *
 * @author milk
 * @create 2020/5/19
 */
@RestController
@RequestMapping("/stock-service")
public class StockController {

  @Resource
  private StockService stockService;

  @PostMapping("/addTrader")
  public Mono<Result> addTrader(@RequestBody AddTraderReq addTraderReq){
    System.out.println(addTraderReq);
    return stockService.addTrader(addTraderReq);
  }

}