package com.jzit.bus.service;

import com.jzit.dto.AddTraderReq;
import com.jzit.utils.Result;
import reactor.core.publisher.Mono;

/**
 * FileName: StockService Description:
 *
 * @author caozhongyu
 * @create 2020/5/19
 */
public interface StockService {

  Mono<Result> addTrader(AddTraderReq addTraderReq);
}