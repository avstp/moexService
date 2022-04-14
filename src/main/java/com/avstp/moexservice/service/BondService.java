package com.avstp.moexservice.service;

import com.avstp.moexservice.dto.FigiesDto;
import com.avstp.moexservice.dto.StockPricesDto;
import com.avstp.moexservice.dto.StocksDto;
import com.avstp.moexservice.dto.TickersDto;

public interface BondService {
    StocksDto getBondsByTickers(TickersDto tickersDto);
    StockPricesDto getPricesByFigies(FigiesDto figiesDto);
}
