package com.jzit.bus.service.impl;

import com.jzit.bus.service.TraderService;
import com.jzit.dto.request.AddTraderReq;
import com.jzit.dto.request.EditTraderReq;
import com.jzit.dto.request.PageTraderReq;
import com.jzit.dto.response.PageTraderRes;
import com.jzit.entity.TraderDTO;
import com.jzit.utils.DateUtil;
import com.jzit.utils.Result;
import java.util.Date;
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
public class TraderServiceImpl implements TraderService {

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public Result<TraderDTO> addTrader(AddTraderReq addTraderReq) {
    TraderDTO traderDTO = new TraderDTO();
    BeanUtils.copyProperties(addTraderReq, traderDTO);
    String traderTime = addTraderReq.getTraderTime();
    long traderTimeLong = DateUtil.strToLong(traderTime, DateUtil.DATE_FORMAT);
    traderDTO.setTraderTime(traderTimeLong);
    traderDTO.setInputTime(new Date().getTime());
    TraderDTO result = mongoTemplate.save(traderDTO);
    return Result.success(result);
  }

  @Override
  public Result<PageTraderRes> listTrader(PageTraderReq pageTraderReq) {
    Integer page = pageTraderReq.getPage();
    Integer pageSize = pageTraderReq.getPageSize();
    Query query = new Query();
    String traderDate = pageTraderReq.getTraderDate();
    String traderId = pageTraderReq.getTraderId();
    String title = pageTraderReq.getTitle();
    if (!StringUtils.isEmpty(traderDate)) {
      long traderTimeLong = DateUtil.strToLong(traderDate, DateUtil.DATE_FORMAT);
      query.addCriteria(Criteria.where("traderTime").is(traderTimeLong));
    }
    if (!StringUtils.isEmpty(traderId)) {
      query.addCriteria(Criteria.where("_id").is(traderId));
    }
    if (!StringUtils.isEmpty(title)) {
      query.addCriteria(Criteria.where("title").is(title));
    }
    List<TraderDTO> traderDTOS = mongoTemplate.find(query, TraderDTO.class);
    PageTraderRes pageTraderRes = new PageTraderRes();
    pageTraderRes.setPage(page);
    pageTraderRes.setPageSize(pageSize);
    pageTraderRes.setTotal(traderDTOS.size());
    if(CollectionUtils.isEmpty(traderDTOS)){
      return Result.success(pageTraderRes);
    }
    List<TraderDTO> pageTraderList = traderDTOS.stream().skip((page - 1) * pageSize).limit(pageSize)
        .collect(Collectors.toList());
    pageTraderRes.setTraderList(pageTraderList);
    return Result.success(pageTraderRes);
  }

  @Override
  public Result<TraderDTO> getTrader(String id) {
    TraderDTO traderDTO = mongoTemplate.findById(id, TraderDTO.class);
    return Result.success(traderDTO);
  }

  @Override
  public Result<Boolean> deleteTrader(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(id));
    mongoTemplate.remove(query, TraderDTO.class);
    return Result.success(true);
  }

  @Override
  public Result<TraderDTO> editTrader(EditTraderReq editTraderReq) {
    deleteTrader(editTraderReq.getTraderId());
    return addTrader(editTraderReq);
  }
}