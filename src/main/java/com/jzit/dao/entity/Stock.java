package com.jzit.dao.entity;

import lombok.Data;

/**
 * FileName: Stock Description:
 *
 * @author caozhongyu
 * @create 2020/7/2
 */
@Data
public class Stock {

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

  /**地区*/
  private String area;

  /**振幅%*/
  private String amplitude;
  /**均价*/
  private String averagePrice;
  /**内盘*/
  private String innerPlate;
  /**外盘*/
  private String outerDisk;
  /**内外比*/
  private String internalExternalRatio;
  /**买量*/
  private String buy;
  /**卖量*/
  private String volume;
  /**开盘金额*/
  private String openingAmount;
  /**开盘换手Z*/
  private String openHand;
  /**流通股(亿)*/
  private String tradableShares;
  /**流通市值*/
  private String circulationMarketValue;
  /**强弱度%*/
  private String strength;
  /**活跃度*/
  private String activity;
  /**笔均量*/
  private String penAmount;
  /**笔换手*/
  private String penChange;
  /**连涨天*/
  private String consecutiveDays;
}