package com.jzit.biz;

import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: ExcelReaderService Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
public interface ReplayBiz {

  void uploadData(MultipartFile uploadFile);
}