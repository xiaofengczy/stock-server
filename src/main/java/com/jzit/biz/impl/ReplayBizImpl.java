package com.jzit.biz.impl;

import com.jzit.bo.FieldNameEnum;
import com.jzit.bo.ExcelDataBO;
import com.jzit.biz.ReplayBiz;
import com.jzit.exception.BusinessException;
import com.jzit.service.impl.ReplayService;
import com.jzit.utils.ExcelUtil;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: ExcelReaderServiceImpl Description:
 *
 * @author milk
 * @create 2020/7/1
 */
@Service
public class ReplayBizImpl implements ReplayBiz {

  private Logger logger = LoggerFactory.getLogger(ReplayBizImpl.class);

  @Resource
  private ReplayService replayService;

  @Value("${stock.replay.location}")
  private String uploadLocation;

  @Override
  public void uploadData(MultipartFile uploadFile) {
    if (Objects.isNull(uploadFile) || uploadFile.isEmpty()) {
      logger.warn("上传的Excel数据文件为空！上传时间：【{}】", new Date());
      throw new BusinessException("上传的Excel数据文件为空！");
    }
    //创建文件夹
    File fileDir = new File(uploadLocation);
    if (!fileDir.isDirectory()) {
      //递归生成文件夹
      fileDir.mkdirs();
    }
    //上传文件保存至服务器
    saveUploadFile(uploadFile, fileDir);
    //解析excel
    List<ExcelDataBO> parsedResult = readExcel(uploadFile);
    //保存数据
    replayService.saveExcelData(parsedResult);
    //删除上传文件
    fileDir.delete();
  }

  /**
   * 文件保存至服务器
   */
  private void saveUploadFile(MultipartFile uploadFile, File fileDir) {
    try {

      //创建文件
      File realFile = new File(
          fileDir.getAbsolutePath() + File.separator + uploadFile.getOriginalFilename());
      if (realFile.exists()) {
        realFile.delete();
        realFile.createNewFile();
      } else {
        realFile.createNewFile();
      }
      //将文件保存至本地
      uploadFile.transferTo(realFile);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      logger.warn("【读取文件失败】文件不存在");
    } catch (IOException e) {
      e.printStackTrace();
      logger.warn("【读取文件失败】转存文件失败");
    }
  }

  /**
   * 读取Excel文件内容
   *
   * @return 读取结果列表，读取失败时返回null
   */
  public List<ExcelDataBO> readExcel(MultipartFile uploadFile) {
    Workbook workbook = null;
    FileInputStream inputStream = null;
    String fileName = uploadFile.getOriginalFilename();
    try {
      // 获取Excel后缀名
      String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
      // 获取Excel文件
      File excelFile = new File(uploadLocation + File.separator + fileName);
      if (!excelFile.exists()) {
        logger.warn("指定的Excel文件不存在！");
        return null;
      }
      // 获取Excel工作簿
      List<List<String>> excelDataList = ExcelUtil
          .handleFileToExcel(new FileInputStream(excelFile), fileType);

      //获取excel数据
      List<ExcelDataBO> excelDataBOList = parseExcelData(excelDataList);
      return excelDataBOList;
    } catch (Exception e) {
      logger.warn("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
      return null;
    } finally {
      try {
        if (null != workbook) {
          workbook.close();
        }
        if (null != inputStream) {
          inputStream.close();
        }
      } catch (Exception e) {
        logger.warn("关闭数据流出错！错误信息：" + e.getMessage());
        return null;
      }
    }
  }

  private List<ExcelDataBO> parseExcelData(List<List<String>> excelDataList) {
    List<ExcelDataBO> excelDataBOList = new ArrayList<>();
    if (CollectionUtils.isEmpty(excelDataList)) {
      return excelDataBOList;
    }
    //标题行
    List<String> excelTitle = excelDataList.get(0);
    for (int i = 1; i < excelDataList.size(); i++) {
      ExcelDataBO excelDataBO = new ExcelDataBO();
      List<String> dataList = excelDataList.get(i);
      for (int j = 0; j < dataList.size(); j++) {
        String title = excelTitle.get(j);
        FieldNameEnum fieldNameEnum = FieldNameEnum.getByName(title);
        if (Objects.isNull(fieldNameEnum)) {
          continue;
        }
        String field = fieldNameEnum.getField();
        String value = dataList.get(j);
        //反射获取对象set方法
        setObjValue(field, value, excelDataBO);
      }
      excelDataBOList.add(excelDataBO);
    }
    return excelDataBOList;
  }

  /**
   * 构造参数设值
   */
  private void setObjValue(String field, String value, ExcelDataBO excelDataBO) {
    try {
      PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field, ExcelDataBO.class);
      Method writeMethod = propertyDescriptor.getWriteMethod();
      writeMethod.setAccessible(true);
      writeMethod.invoke(excelDataBO, value);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}