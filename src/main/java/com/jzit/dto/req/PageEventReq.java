package com.jzit.dto.req;

import lombok.Data;

@Data
public class PageEventReq {

  private String eventId;

  private String eventName;

  private Long eventTime;

  private Integer page=1;

  private Integer pageSize=10;
}
