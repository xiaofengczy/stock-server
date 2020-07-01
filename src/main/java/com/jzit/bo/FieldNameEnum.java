package com.jzit.bo;


import java.util.Objects;

/**
 * FileName: FieldNameEnum Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
public enum FieldNameEnum {

  CODE("code", "代码"),
  NAME("name", "名称"),
  INCREASE("increase", "涨幅%"),
  PRICE("price", "现价"),
  UPSANDDOWNS("upsAndDowns", "涨跌"),
  BUYINGPRICE("buyingPrice", "买价"),
  SELLINGPRICE("sellingPrice", "卖价"),
  TOTAL("total", "总量"),
  PRESENT("present", "现量"),
  RATEOFINCREASE("rateOfIncrease", "涨速%"),
  CHANGEHANDS("changeHands", "换手%"),
  OPENPRICE("openPrice", "今开"),
  HIGHEPRICE("highePrice", "最高"),
  LOWESTPRICE("lowestPrice", "最低"),
  YESTERDAYPRICE("yesterdayPrice", "昨收"),
  MARKETPROFIT("marketProfit", "市盈(动)"),
  TOTALAMOUNT("totalAmount", "总金额"),
  VOLUMERATIO("volumeRatio", "量比"),
  SEGMENTINDUSTRY("segmentIndustry", "细分行业");

  private String field;
  private String name;
  FieldNameEnum(String field, String name) {
    this.field = field;
    this.name = name;
  }

  public String getField() {
    return field;
  }

  public String getName() {
    return name;
  }


  public static FieldNameEnum getByField(String field) {
    for (FieldNameEnum fieldNameEnum : FieldNameEnum.values()) {
      if(Objects.equals(field,fieldNameEnum.getField())){
        return fieldNameEnum;
      }
    }
    return null;
  }

  public static FieldNameEnum getByName(String name) {
    for (FieldNameEnum fieldNameEnum : FieldNameEnum.values()) {
      if (fieldNameEnum.getName().equals(name)) {
        return fieldNameEnum;
      }
    }
    return null;
  }

}