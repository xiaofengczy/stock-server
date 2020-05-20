package com.jzit.dto.req;

import lombok.Data;

@Data
public class PageTraderReq {

  private String traderId;

  private Integer page=1;

  private Integer pageSize=10;

  private String traderDate;

}
