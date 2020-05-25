package com.jzit.utils;

import java.io.Serializable;
import lombok.Data;
/**
 * FileName: Result Description:
 *
 * @author milk
 * @create 2020/5/19
 */
@Data
public class Result<T> implements Serializable {
  private String code;
  private Object data;
  private String message;

  public static <E> Result<E> success(E data) {
    Result<E> result = new Result();
    result.setData(data);
    result.setCode("0000");
    return result;
  }

  public static <E> Result<E> fail(E data, String message, String code) {
    Result<E> result = new Result();
    result.setMessage(message);
    result.setCode(code);
    return result;
  }

  public static <E> Result<E> fail(String message, String code) {
    Result<E> result = new Result();
    result.setMessage(message);
    result.setCode(code);
    return result;
  }

  public static <E> Result<E> fail(ResultCode resultCode) {
    Result<E> result = new Result();
    result.setMessage(resultCode.message());
    result.setCode(resultCode.code());
    return result;
  }

  public static <E> Result<E> fail(ResultCode resultCode, String message) {
    Result<E> result = new Result();
    result.setMessage(message);
    result.setCode(resultCode.code());
    return result;
  }

  public static <E> Result<E> fail(E data, ResultCode resultCode, String message) {
    Result<E> result = new Result();
    result.setData(data);
    result.setMessage(message);
    result.setCode(resultCode.code());
    return result;
  }

  public static <E> Result<E> fail(E data, ResultCode resultCode) {
    Result<E> result = new Result();
    result.setData(data);
    result.setCode(resultCode.code());
    result.setMessage(resultCode.message());
    return result;
  }
}