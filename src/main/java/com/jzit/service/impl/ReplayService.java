package com.jzit.service.impl;

import com.jzit.bo.ExcelDataBO;
import java.util.List;

/**
 * FileName: ReplayService Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
public interface ReplayService {

  void saveExcelData(List<ExcelDataBO> excelDataBOS);
}