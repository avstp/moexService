package com.avstp.moexservice.mapper;

import com.avstp.moexservice.dto.BondDto;
import com.avstp.moexservice.model.Currency;
import com.avstp.moexservice.model.Stock;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StockMapper {

    public Stock toStock(BondDto bondDto) {
        return Stock.builder()
                .ticker(bondDto.getTicker())
                .name(bondDto.getName())
                .figi(bondDto.getTicker())
                .type("Bond")
                .currency(Currency.RUB)
                .source("MOEX")
                .build();
    }
}
