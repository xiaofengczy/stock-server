package com.jzit.biz;

import com.jzit.bo.ExcelDataBO;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: ExcelReaderService Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
public interface ReplayBiz {

  List<ExcelDataBO> readExcel(MultipartFile fileName);

  void uploadData(MultipartFile uploadFile);
}