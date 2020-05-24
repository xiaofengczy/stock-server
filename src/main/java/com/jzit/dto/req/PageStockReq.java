package com.jzit.dto.req;

import lombok.Data;

@Data
public class PageStockReq {

  private String stockId;

  private String name;

  private String code;

  private Integer page=1;

  private Integer pageSize=10;
}
