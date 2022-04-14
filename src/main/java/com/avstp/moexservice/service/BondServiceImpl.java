package com.avstp.moexservice.service;

import com.avstp.moexservice.dto.*;
import com.avstp.moexservice.exception.BondNotFoundException;
import com.avstp.moexservice.mapper.StockMapper;
import com.avstp.moexservice.mapper.StockPriceMapper;
import com.avstp.moexservice.model.Stock;
import com.avstp.moexservice.model.StockPrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BondServiceImpl implements BondService {
    private final MoexBondService moexBondService;

    @Override
    public StocksDto getBondsByTickers(TickersDto tickersDto) {
        List<Stock> stocks = getAllBonds().stream()
                .filter(bondDto -> tickersDto.getTickers().contains(bondDto.getTicker()))
                .map(StockMapper::toStock)
                .collect(Collectors.toList());

        return new StocksDto(stocks);
    }

    @Override
    public StockPricesDto getPricesByFigies(FigiesDto figiesDto) {
        log.info("Request prices by figies {}", figiesDto.getFigies());
        List<String> figies = new ArrayList<>(figiesDto.getFigies());
        List<BondDto> allBonds = getAllBonds();
        figies.removeAll(allBonds.stream().map(BondDto::getTicker).toList());
        if (!figies.isEmpty()) {
            throw new BondNotFoundException(String.format("Bonds %s not found", figies));
        }
        List<StockPrice> stockPrices = allBonds.stream()
                .filter(bondDto -> figiesDto.getFigies().contains(bondDto.getTicker()))
                .map(StockPriceMapper::toStockPrice)
                .collect(Collectors.toList());
        return new StockPricesDto(stockPrices);
    }

    private List<BondDto> getAllBonds() {
        List<BondDto> allBonds = new ArrayList<>();
        allBonds.addAll(moexBondService.getGovernmentBonds());
        allBonds.addAll(moexBondService.getCorporateBonds());
        return allBonds;
    }
}
