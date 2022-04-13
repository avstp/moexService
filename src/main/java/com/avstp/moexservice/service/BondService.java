package com.avstp.moexservice.service;

import com.avstp.moexservice.dto.StocksDto;
import com.avstp.moexservice.dto.TickersDto;

public interface BondService {
    StocksDto getBondsByTickers(TickersDto tickersDto);
}
