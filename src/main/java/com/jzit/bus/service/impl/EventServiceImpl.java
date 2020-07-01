package com.jzit.bus.service.impl;

import com.jzit.bus.service.EventService;
import com.jzit.dto.request.EditEventReq;
import com.jzit.dto.request.EventReq;
import com.jzit.dto.request.PageEventReq;
import com.jzit.dto.response.PageEventRes;
import com.jzit.entity.EventDTO;
import com.jzit.utils.DateUtil;
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

@Service
public class EventServiceImpl implements EventService {

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public Result<EventDTO> addEvent(EventReq eventReq) {
    EventDTO eventDTO = new EventDTO();
    BeanUtils.copyProperties(eventReq,eventDTO);
    eventDTO.setCreateTime(DateUtil.strToLong(eventReq.getEventTime(),DateUtil.DATE_FORMAT));
    EventDTO result = mongoTemplate.save(eventDTO);
    return Result.success(result);
  }

  @Override
  public Result<PageEventRes> listEvent(PageEventReq pageEventReq) {
    Integer page = pageEventReq.getPage();
    Integer pageSize = pageEventReq.getPageSize();
    Query query = new Query();
    String eventId = pageEventReq.getEventId();
    String createTime = pageEventReq.getCreateTime();
    if (!StringUtils.isEmpty(eventId)) {
      query.addCriteria(Criteria.where("_id").is(eventId));
    }
    if (!StringUtils.isEmpty(createTime)) {
      query.addCriteria(Criteria.where("createTime").is(DateUtil.strToLong(createTime,DateUtil.DATE_FORMAT)));
    }
    List<EventDTO> eventDTOS = mongoTemplate.find(query, EventDTO.class);
    PageEventRes pageEventRes = new PageEventRes();
    pageEventRes.setPage(page);
    pageEventRes.setPageSize(pageSize);
    pageEventRes.setTotal(eventDTOS.size());
    if(CollectionUtils.isEmpty(eventDTOS)){
      return Result.success(pageEventRes);
    }
    List<EventDTO> pageStockList = eventDTOS.stream().skip((page - 1) * pageSize).limit(pageSize)
        .collect(Collectors.toList());
    pageEventRes.setEventList(pageStockList);
    return Result.success(pageEventRes);
  }

  @Override
  public Result<EventDTO> getEvent(String id) {
    EventDTO eventDTO = mongoTemplate.findById(id, EventDTO.class);
    return Result.success(eventDTO);
  }

  @Override
  public Result<Boolean> deleteEvent(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(id));
    mongoTemplate.remove(query, EventDTO.class);
    return Result.success(true);
  }

  @Override
  public Result<EventDTO> editEvent(EditEventReq editEventReq) {
    deleteEvent(editEventReq.getEventId());
    return addEvent(editEventReq);
  }
}
