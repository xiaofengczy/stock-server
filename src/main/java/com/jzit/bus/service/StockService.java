package com.jzit.bus.service;

import com.jzit.dto.AddTraderReq;
import com.jzit.dto.req.PageTraderReq;
import com.jzit.entity.TraderDTO;
import com.jzit.utils.Result;
import java.util.List;

/**
 * FileName: StockService Description:
 *
 * @author caozhongyu
 * @create 2020/5/19
 */
public interface StockService {

  Result<TraderDTO> addTrader(AddTraderReq addTraderReq);

  Result<List<TraderDTO>> listTrader(PageTraderReq pageTraderReq);

  Result<TraderDTO> getStock(String id);
}