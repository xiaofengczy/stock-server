package com.jzit.utils;


import static com.jzit.constant.Constant.FILE_PATTERN_ERROR;
import static com.jzit.constant.Constant.IMPORT_RECORD_IS_NULL;
import static org.apache.poi.ss.usermodel.CellType.STRING;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jzit.exception.BusinessException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtil {

  private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
  //数据从excel文件第三行开始
  private static final int START_ROW = 1;
  private static final String XLS = "xls";
  private static final String XLSX = "xlsx";

  /**
   * @description:将文件转入excel <br>
   * @author:zycao
   * @date: 2019/12/24 上午10:35
   */
  public static List<List<String>> handleFileToExcel(InputStream inputStream,String fileType) {
    List<List<String>> data;
    try {
      Workbook hssfWorkbook = getWorkbook(inputStream,fileType);
      //行数限制
      int rowCount = ExcelUtil.getRowCount(hssfWorkbook, 0);
      //空文件限制
      if (rowCount <= 2) {
        throw new BusinessException(IMPORT_RECORD_IS_NULL);
      }
      //读取出数据
      data = ExcelUtil.read(hssfWorkbook, 0, START_ROW - 1, rowCount);
      if (CollectionUtils.isEmpty(data)) {
        throw new BusinessException(IMPORT_RECORD_IS_NULL);
      }
    } catch (BusinessException e) {
      throw e;
    } catch (OfficeXmlFileException e) {
      throw new BusinessException(FILE_PATTERN_ERROR);
    } catch (Exception e) {
      logger.warn(e.getMessage(), e);
      throw new BusinessException(FILE_PATTERN_ERROR);
    } finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException e) {
        logger.warn(e.getMessage(), e);
        throw new BusinessException(FILE_PATTERN_ERROR);
      }
    }
    return data;
  }

  private static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
    Workbook workbook = null;
    if (fileType.equalsIgnoreCase(XLS)) {
      workbook = new HSSFWorkbook(inputStream);
    } else if (fileType.equalsIgnoreCase(XLSX)) {
      workbook = new XSSFWorkbook(inputStream);
    }
    return workbook;
  }

  private static List<List<String>> read(Workbook workbook, int sheetIx, int start, int end) {
    Sheet sheet = workbook.getSheetAt(sheetIx);
    List<List<String>> list = new ArrayList<>();
    if (end > getRowCount(workbook, sheetIx)) {
      end = getRowCount(workbook, sheetIx);
    }
    for (int i = start; i <= end; i++) {
      List<String> rowList = new ArrayList<>();
      Row row = sheet.getRow(i);
      if (row == null) {
        continue;
      }
      // 第一行总列数
      int cols = sheet.getRow(i).getLastCellNum();
      for (int j = 0; j < cols; j++) {
        String cellValue = getCellValueToString(row.getCell(j));
        rowList.add(cellValue);
      }
      List<String> collect =
          rowList.stream().filter(StringUtils::isNotBlank).collect(
              Collectors.toList());
      if (CollectionUtils.isEmpty(collect)) {
        continue;
      }
      list.add(rowList);
    }
    return list;
  }

  private static String getCellValueToString(Cell cell) {
    String strCell = "";
    if (cell == null) {
      return null;
    }
    switch (cell.getCellType()) {
      case BOOLEAN:
        strCell = String.valueOf(cell.getBooleanCellValue());
        break;
      case NUMERIC:
        if (HSSFDateUtil.isCellDateFormatted(cell)) {
          Date date = cell.getDateCellValue();
          SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT);
          strCell = sdf.format(date);
          break;
        }
        // 不是日期格式，则防止当数字过长时以科学计数法显示
        cell.setCellType(STRING);
        strCell = cell.toString();
        break;
      case STRING:
        strCell = cell.getStringCellValue();
        break;
      case FORMULA:
        strCell = cell.getStringCellValue();
        break;
      default:
        break;
    }
    if (strCell != null) {
      strCell = strCell.trim();
    }
    return strCell;
  }


  private static int getRowCount(Workbook workbook, int sheetIx) {
    Sheet sheet = workbook.getSheetAt(sheetIx);
    if (sheet.getPhysicalNumberOfRows() == 0) {
      return 0;
    }
    return sheet.getLastRowNum() + 1;
  }
}
