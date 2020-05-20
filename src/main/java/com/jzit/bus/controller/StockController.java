package com.jzit.bus.controller;

import com.jzit.bus.service.StockService;
import com.jzit.dto.AddTraderReq;
import com.jzit.dto.req.PageTraderReq;
import com.jzit.entity.TraderDTO;
import com.jzit.utils.Result;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public Result<TraderDTO> addTrader(@RequestBody AddTraderReq addTraderReq){
    return stockService.addTrader(addTraderReq);
  }

  @PostMapping("/listTrader")
  public Result<List<TraderDTO>> listTrader(@RequestBody PageTraderReq pageTraderReq){
    return stockService.listTrader(pageTraderReq);
  }

}