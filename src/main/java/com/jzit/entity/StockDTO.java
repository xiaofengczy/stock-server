package com.jzit.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StockDTO")
@Data
public class StockDTO {

  @Id
  private String id;

  private String name;

  private String code;

  private String plate;

  private String stockFemoral;

  private Long createTime;

  private Long updateTime;
}
