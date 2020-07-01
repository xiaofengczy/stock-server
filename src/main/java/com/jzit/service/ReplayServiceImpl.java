package com.jzit.service;

import com.jzit.bo.ExcelDataBO;
import com.jzit.entity.ExcelDataEntity;
import com.jzit.service.impl.ReplayService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * FileName: ReplayServiceImpl Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
@Service
public class ReplayServiceImpl implements ReplayService {

  @Resource
  private MongoTemplate mongoTemplate;

  private Logger logger = LoggerFactory.getLogger(ReplayServiceImpl.class);

  @Override
  public void saveExcelData(List<ExcelDataBO> excelDataBOS) {
    ExcelDataEntity excelDataEntity = new ExcelDataEntity();
    excelDataEntity.setExcelDataList(excelDataBOS);
    excelDataEntity.setCreateAt(new Date());
    mongoTemplate.save(excelDataEntity);
    logger.info("【保存复盘数据】保存成功");
  }
}