package com.jzit.dto.request;

import lombok.Data;

@Data
public class PageTraderReq {

  private String title;

  private String traderId;

  private Integer page=1;

  private Integer pageSize=10;

  private String traderDate;

}
