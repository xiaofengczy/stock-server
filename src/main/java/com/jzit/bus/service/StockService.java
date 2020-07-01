package com.jzit.bus.service;

import com.jzit.dto.request.AddStockReq;
import com.jzit.dto.request.EditStockReq;
import com.jzit.dto.request.PageStockReq;
import com.jzit.dto.response.PageStockRes;
import com.jzit.entity.StockDTO;
import com.jzit.utils.Result;

public interface StockService {

  Result<StockDTO> add(AddStockReq addStockReq);

  Result<PageStockRes> listStock(PageStockReq pageStockReq);

  Result<StockDTO> getStock(String id);

  Result<Boolean> deleteStock(String id);

  Result<StockDTO> editStock(EditStockReq editStockReq);
}
