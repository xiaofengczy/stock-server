package com.jzit.bus.controller;

import com.jzit.bus.service.TraderService;
import com.jzit.dto.request.AddTraderReq;
import com.jzit.dto.request.EditTraderReq;
import com.jzit.dto.request.PageTraderReq;
import com.jzit.dto.response.PageTraderRes;
import com.jzit.entity.TraderDTO;
import com.jzit.utils.Result;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class TraderController {

  @Resource
  private TraderService traderService;

  @PostMapping("/addTrader")
  public Result<TraderDTO> addTrader(@RequestBody AddTraderReq addTraderReq){
    return traderService.addTrader(addTraderReq);
  }

  @PostMapping("/listTrader")
  public Result<PageTraderRes> listTrader(@RequestBody PageTraderReq pageTraderReq){
    return traderService.listTrader(pageTraderReq);
  }

  @GetMapping("/getTrader/{id}")
  public Result<TraderDTO> getTrader(@PathVariable String id){
    return traderService.getTrader(id);
  }

  @DeleteMapping("/delTrader/{id}")
  public Result<Boolean> delTrader(@PathVariable String id){
    return traderService.deleteTrader(id);
  }

  @PostMapping("/editTrader")
  public Result<TraderDTO> editTrader(@RequestBody EditTraderReq editTraderReq){
    return traderService.editTrader(editTraderReq);
  }
}