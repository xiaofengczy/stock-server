package com.jzit.bus.controller;

import com.jzit.bus.service.EventService;
import com.jzit.dto.request.EditEventReq;
import com.jzit.dto.request.EventReq;
import com.jzit.dto.request.PageEventReq;
import com.jzit.dto.response.PageEventRes;
import com.jzit.entity.EventDTO;
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
public class EventController {

  @Resource
  private EventService eventService;

  @PostMapping("/addEvent")
  public Result<EventDTO> addEvent(@RequestBody EventReq eventReq){
    return eventService.addEvent(eventReq);
  }

  @PostMapping("/listEvent")
  public Result<PageEventRes> listEvent(@RequestBody PageEventReq pageEventReq){
    return eventService.listEvent(pageEventReq);
  }

  @GetMapping("/getEvent/{id}")
  public Result<EventDTO> getEvent(@PathVariable String id){
    return eventService.getEvent(id);
  }

  @DeleteMapping("/deleteEvent/{id}")
  public Result<Boolean> deleteEvent(@PathVariable String id){
    return eventService.deleteEvent(id);
  }

  @PostMapping("/editEvent")
  public Result<EventDTO> editEvent(@RequestBody EditEventReq editEventReq){
    return eventService.editEvent(editEventReq);
  }
}