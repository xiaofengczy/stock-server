package com.jzit.bus.service.impl;

import com.google.common.collect.Lists;
import com.jzit.bus.service.StockService;
import com.jzit.dto.AddTraderReq;
import com.jzit.dto.req.PageTraderReq;
import com.jzit.entity.TraderDTO;
import com.jzit.utils.Result;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * FileName: StockServiceImpl Description:
 *
 * @author milk
 * @create 2020/5/19
 */
@Service
public class StockServiceImpl implements StockService {

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public Result<TraderDTO> addTrader(AddTraderReq addTraderReq) {
    TraderDTO traderDTO = new TraderDTO();
    BeanUtils.copyProperties(addTraderReq, traderDTO);
    TraderDTO result = mongoTemplate.save(traderDTO);
    return Result.success(result);
  }

  @Override
  public Result<List<TraderDTO>> listTrader(PageTraderReq pageTraderReq) {
    Query query = new Query();
    String traderDate = pageTraderReq.getTraderDate();
    String traderId = pageTraderReq.getTraderId();
    if(!StringUtils.isEmpty(traderDate)){
      query.addCriteria(Criteria.where("traderTime").is(pageTraderReq.getTraderDate()));
    }
    if(!StringUtils.isEmpty(traderId)){
      query.addCriteria(Criteria.where("_id").is(pageTraderReq.getTraderId()));
    }
    Integer page = pageTraderReq.getPage();
    Integer pageSize = pageTraderReq.getPageSize();
    List<TraderDTO> traderDTOS = mongoTemplate.find(query, TraderDTO.class);
    if(CollectionUtils.isEmpty(traderDTOS)){
      return Result.success(Lists.newArrayList());
    }
    List<TraderDTO> collect = traderDTOS.stream().skip((page - 1) * pageSize).limit(pageSize)
        .collect(Collectors.toList());
    return Result.success(collect);
  }
}