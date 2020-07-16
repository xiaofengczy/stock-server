package com.jzit.constant;

import com.jzit.utils.ResultCode;
import java.util.Map;

/**
 * FileName: Constant Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
public class Constant {

  /**
   * 上传失败错误信息
   */
  public static final ResultCode UPLOAD_REPORT_EXCEL_ERROR_CODE =
      ResultCode.of("FORM0159", "上传文件发生错误");

  public static final ResultCode DOWNLOAD_FILE_ERROR =
      ResultCode.of("FORM0181", "下载文件发生错误.");

  public static final ResultCode IMPORT_RECORD_TOO_LARGE =
      ResultCode.of("FORM0183", "导入数据量不能超过2000条.");

  public static final ResultCode IMPORT_RECORD_IS_NULL =
      ResultCode.of("FORM00184", "导入记录为空.");

  public static final ResultCode FILE_PATTERN_ERROR =
      ResultCode.of("FORM0182", "文件格式错误.");

  public static final ResultCode EXCEL_TITLE_ERROR =
      ResultCode.of("FORM0185", "导入文件表头已被修改,请调整后重试.");

  public static final String ADMIN_TYPE = "admin";
  public static final String CLIENT_TYPE = "client";
  public static final String APP_TYPE = "app";
}