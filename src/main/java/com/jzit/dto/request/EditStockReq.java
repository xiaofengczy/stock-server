package com.jzit.dto.request;

import lombok.Data;

@Data
public class EditStockReq extends AddStockReq {
  private String stockId;
}
