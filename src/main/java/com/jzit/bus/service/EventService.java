package com.jzit.bus.service;

import com.jzit.dto.req.EditEventReq;
import com.jzit.dto.req.EventReq;
import com.jzit.dto.req.PageEventReq;
import com.jzit.dto.res.PageEventRes;
import com.jzit.entity.EventDTO;
import com.jzit.utils.Result;

public interface EventService {

  Result<EventDTO> addEvent(EventReq eventReq);

  Result<PageEventRes> listEvent(PageEventReq pageEventReq);

  Result<EventDTO> getEvent(String id);

  Result<Boolean> deleteEvent(String id);

  Result<EventDTO> editEvent(EditEventReq editEventReq);
}
