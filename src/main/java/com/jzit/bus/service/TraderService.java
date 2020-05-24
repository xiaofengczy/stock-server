package com.jzit.bus.service;

import com.jzit.dto.req.AddTraderReq;
import com.jzit.dto.req.EditTraderReq;
import com.jzit.dto.req.PageTraderReq;
import com.jzit.dto.res.PageTraderRes;
import com.jzit.entity.TraderDTO;
import com.jzit.utils.Result;

/**
 * FileName: StockService Description:
 *
 * @author caozhongyu
 * @create 2020/5/19
 */
public interface TraderService {

  Result<TraderDTO> addTrader(AddTraderReq addTraderReq);

  Result<PageTraderRes> listTrader(PageTraderReq pageTraderReq);

  Result<TraderDTO> getTrader(String id);

  Result<Boolean> deleteTrader(String id);

  Result<TraderDTO> editTrader(EditTraderReq editTraderReq);
}