package com.jzit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtil {

  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String DATE_MINUTE_FORMAT = "HH:mm";
  public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_TIME_FORMAT_APP = "yyyy-MM-dd HH:mm";
  public static final String DATESTYLE_YYYYMMDD = "yyyyMMdd";
  public static final String SIMPLE_BOARD_FORMAT = "MM-dd HH:mm";
  public static final String SMS_FORMAT="yyyy年MM月dd日";
  public static final String DATE_FORM_FORMAT="yyyy/MM/dd HH:mm:ss";
  public static final String DATE_FORM_DATA_FORMAT="yyyy-MM-dd";

  /**
   * 获取当前时间戳（毫秒）
   */
  public static long getCurTimeMs() {
    return System.currentTimeMillis();
  }

  /**
   * 格式化时间戳
   */
  public static Date formatTimeStamp(long timestamp, String format) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    Long time = timestamp;
    String d = sdf.format(time);
    Date date = null;
    try {
      date = sdf.parse(d);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /*
   * 将时间戳转换为时间
   */
  public static String stampToDate(String s){
    String res;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long lt = new Long(s);
    Date date = new Date(lt);
    res = simpleDateFormat.format(date);
    return res;
  }

  /*
   * 将时间戳转换为时间
   */
  public static String stampToDateStr(String s,String format){
    String res;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    long lt = new Long(s);
    Date date = new Date(lt);
    res = simpleDateFormat.format(date);
    return res;
  }

  /*
   * 将时间戳转换为时间
   */
  public static long strToLong(String s,String format){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    Date parse = new Date();
    try {
      parse = simpleDateFormat.parse(s);
    } catch (ParseException e) {
    }
    return parse.getTime();
  }

  public static String strToDateStr(String s,String format){
    Date date = new Date();
    try {
      date = new SimpleDateFormat(format).parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    String now = new SimpleDateFormat(format).format(date);
    return now;
  }
  /*
   * 将时间戳转换为时间
   */
  public static Date longToDate(long lt){
    return new Date(lt);
  }
}
