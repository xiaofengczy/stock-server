package com.jzit.bus.service;

import com.jzit.dto.req.AddStockReq;
import com.jzit.dto.req.EditStockReq;
import com.jzit.dto.req.PageStockReq;
import com.jzit.entity.StockDTO;
import com.jzit.utils.Result;
import java.util.List;

public interface StockService {

  Result<StockDTO> add(AddStockReq addStockReq);

  Result<List<StockDTO>> listStock(PageStockReq pageStockReq);

  Result<StockDTO> getStock(String id);

  Result<Boolean> deleteStock(String id);

  Result<StockDTO> editStock(EditStockReq editStockReq);
}
