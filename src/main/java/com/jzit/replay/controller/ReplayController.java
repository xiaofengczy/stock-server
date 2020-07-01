package com.jzit.replay.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: ReplayController Description: 股票复盘
 *
 * @author caozhongyu
 * @create 2020/7/1
 */

@RestController("/replay")
public class ReplayController {

  private Logger logger  = LoggerFactory.getLogger(ReplayController.class);

  /**
   * 上传每日复盘数据
   *
   * @param:file 上传文件
   */
  @PostMapping("/uploadFile")
  public HttpEntity<Object> uploadFile(MultipartFile file) {
// 检查前台数据合法性
    if (null == file || file.isEmpty()) {
      logger.warn("上传的Excel数据文件为空！上传时间：【{}】",new Date());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      // 解析Excel
      List<ExcelDataVO> parsedResult = ExcelReader.readExcel(file);
      // todo 进行业务操作

      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      logger.warning("上传的Excel商品数据文件为空！上传时间：" + new Date());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

}