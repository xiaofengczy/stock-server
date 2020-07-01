package com.jzit.bo;

import lombok.Data;

/**
 * FileName: ExcelDataReq Description:
 *
 * @author milk
 * @create 2020/7/1
 */
@Data
public class ExcelDataBO {

  /**代码*/
  private String code;

  /**名字*/
  private String name;

  /**涨幅*/
  private String increase;

  /**价格*/
  private String price;

  /**涨跌*/
  private String upsAndDowns;

  /**买价*/
  private String buyingPrice;

  /**卖价*/
  private String sellingPrice;

  /**总量*/
  private String total;

  /**现量*/
  private String present;

  /**涨速%*/
  private String rateOfIncrease;

  /**换手%*/
  private String changeHands;

  /**今开*/
  private String openPrice;

  /**最高*/
  private String highePrice;

  /**最低*/
  private String lowestPrice;

  /**昨收*/
  private String yesterdayPrice;

  /**市盈(动)*/
  private String marketProfit;

  /**总金额*/
  private String totalAmount;

  /**量比*/
  private String volumeRatio;

  /**细分行业*/
  private String segmentIndustry;
}