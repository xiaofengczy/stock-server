package com.jzit.dto.request;

import lombok.Data;

@Data
public class PageEventReq {

  private String eventId;

  private String eventName;

  private String createTime;

  private Integer page=1;

  private Integer pageSize=10;
}
