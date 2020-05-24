package com.jzit.bus.service.impl;

import com.jzit.bus.service.StockService;
import com.jzit.dto.req.AddStockReq;
import com.jzit.dto.req.EditStockReq;
import com.jzit.dto.req.PageStockReq;
import com.jzit.entity.StockDTO;
import com.jzit.utils.Result;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StockServiceImpl implements StockService {

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public Result<StockDTO> add(AddStockReq addStockReq) {
    StockDTO stockDTO = new StockDTO();
    BeanUtils.copyProperties(addStockReq,stockDTO);
    stockDTO.setCreateTime(new Date().getTime());
    StockDTO result = mongoTemplate.save(stockDTO);
    return Result.success(result);
  }

  @Override
  public Result<List<StockDTO>> listStock(PageStockReq pageStockReq) {
    Integer page = pageStockReq.getPage();
    Integer pageSize = pageStockReq.getPageSize();
    Query query = new Query().skip((page - 1) * pageSize).limit(pageSize);
    String stockId = pageStockReq.getStockId();
    String name = pageStockReq.getName();
    String code = pageStockReq.getCode();
    if (!StringUtils.isEmpty(stockId)) {
      query.addCriteria(Criteria.where("_id").is(stockId));
    }
    if (!StringUtils.isEmpty(name)) {
      query.addCriteria(Criteria.where("name").is(name));
    }
    if (!StringUtils.isEmpty(code)) {
      query.addCriteria(Criteria.where("code").is(code));
    }
    List<StockDTO> stockDTOS = mongoTemplate.find(query, StockDTO.class);
    return Result.success(stockDTOS);
  }

  @Override
  public Result<StockDTO> getStock(String id) {
    StockDTO stockDTO = mongoTemplate.findById(id, StockDTO.class);
    return Result.success(stockDTO);
  }

  @Override
  public Result<Boolean> deleteStock(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(id));
    mongoTemplate.remove(query, StockDTO.class);
    return Result.success(true);
  }

  @Override
  public Result<StockDTO> editStock(EditStockReq editStockReq) {
    deleteStock(editStockReq.getStockId());
    return add(editStockReq);
  }
}
