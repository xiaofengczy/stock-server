package com.jzit.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EventDTO")
@Data
public class EventDTO {

  @Id
  private String id;

  private String eventName;

  private String eventAnalysis;

  private String goodStock;

  private Long createTime;

}
