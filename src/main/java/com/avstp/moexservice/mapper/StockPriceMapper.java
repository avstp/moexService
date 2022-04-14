package com.avstp.moexservice.mapper;

import com.avstp.moexservice.dto.BondDto;
import com.avstp.moexservice.model.StockPrice;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StockPriceMapper {

    public StockPrice toStockPrice(BondDto bondDto) {
        return new StockPrice(bondDto.getTicker(), bondDto.getPrice());
    }
}
