package com.jzit.dto.req;

import lombok.Data;

@Data
public class EditStockReq extends AddStockReq {
  private String stockId;
}
