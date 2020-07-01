package com.jzit.entity;

import com.jzit.bo.ExcelDataBO;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * FileName: ExcelDataEntity Description:
 *
 * @author caozhongyu
 * @create 2020/7/1
 */
@Document(collection = "ExcelDataEntity")
@Data
public class ExcelDataEntity {

  @Id
  private String id;

  private List<ExcelDataBO> excelDataList;

  private Date createAt;

  private Date updateAt;
}