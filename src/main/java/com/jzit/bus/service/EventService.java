package com.jzit.bus.service;

import com.jzit.dto.request.EditEventReq;
import com.jzit.dto.request.EventReq;
import com.jzit.dto.request.PageEventReq;
import com.jzit.dto.response.PageEventRes;
import com.jzit.entity.EventDTO;
import com.jzit.utils.Result;

public interface EventService {

  Result<EventDTO> addEvent(EventReq eventReq);

  Result<PageEventRes> listEvent(PageEventReq pageEventReq);

  Result<EventDTO> getEvent(String id);

  Result<Boolean> deleteEvent(String id);

  Result<EventDTO> editEvent(EditEventReq editEventReq);
}
