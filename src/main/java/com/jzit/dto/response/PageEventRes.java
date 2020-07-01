package com.jzit.dto.response;

import com.jzit.entity.EventDTO;
import java.util.List;
import lombok.Data;

@Data
public class PageEventRes {

  private Integer total;

  private List<EventDTO> eventList;

  private Integer page;

  private Integer pageSize;

}
