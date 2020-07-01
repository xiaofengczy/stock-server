package com.jzit.dto.response;

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
