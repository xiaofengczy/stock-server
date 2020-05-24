package com.jzit.dto.res;

import com.jzit.entity.StockDTO;
import com.jzit.entity.TraderDTO;
import java.util.List;
import lombok.Data;

@Data
public class PageTraderRes {

  private Integer total;

  private List<TraderDTO> traderList;

  private Integer page;

  private Integer pageSize;

}
