package com.jzit.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * FileName: AddTraderReq Description:
 *
 * @author milk
 * @create 2020/5/19
 */
@Document(collection = "TraderDTO")
@Data
public class TraderDTO {

  @Id
  private String id;

  private String news;

  private String stockAnalysis;

  private String tradersSuggested;

  private String traderTime;

  private String inputTime;

}