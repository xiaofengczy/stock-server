package com.jzit.dto;

import lombok.Data;

/**
 * FileName: AddTraderReq Description:
 *
 * @author milk
 * @create 2020/5/19
 */
@Data
public class AddTraderReq {

  private String title;

  private String news;

  private String stockAnalysis;

  private String tradersSuggested;

  private String traderTime;

  private String inputTime;

  private String marketAnalysis;

}