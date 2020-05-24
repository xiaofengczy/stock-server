package com.jzit.bus.controller;

import com.jzit.bus.service.StockService;
import com.jzit.dto.req.AddStockReq;
import com.jzit.dto.req.EditStockReq;
import com.jzit.dto.req.PageStockReq;
import com.jzit.entity.StockDTO;
import com.jzit.utils.Result;
import java.util.List;
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
public class StockController {

  @Resource
  private StockService stockService;

  @PostMapping("/addStock")
  public Result<StockDTO> addStock(@RequestBody AddStockReq addStockReq){
    return stockService.add(addStockReq);
  }

  @PostMapping("/listStock")
  public Result<List<StockDTO>> listStock(@RequestBody PageStockReq pageStockReq){
    return stockService.listStock(pageStockReq);
  }

  @GetMapping("/getStock/{id}")
  public Result<StockDTO> getStock(@PathVariable String id){
    return stockService.getStock(id);
  }

  @DeleteMapping("/deleteStock/{id}")
  public Result<Boolean> deleteStock(@PathVariable String id){
    return stockService.deleteStock(id);
  }

  @PostMapping("/editStock")
  public Result<StockDTO> editStock(@RequestBody EditStockReq editStockReq){
    return stockService.editStock(editStockReq);
  }
}