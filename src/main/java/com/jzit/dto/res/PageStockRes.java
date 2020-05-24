package com.jzit.dto.res;

import com.jzit.entity.StockDTO;
import java.util.List;
import lombok.Data;

@Data
public class PageStockRes {

  private Integer total;

  private List<StockDTO> stockList;

  private Integer page;

  private Integer pageSize;

}
