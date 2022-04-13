package com.avstp.moexservice.service;

import com.avstp.moexservice.client.moex.CorporateBondsClient;
import com.avstp.moexservice.client.moex.GovernmentBondsClient;
import com.avstp.moexservice.dto.BondDto;
import com.avstp.moexservice.dto.StocksDto;
import com.avstp.moexservice.dto.TickersDto;
import com.avstp.moexservice.dto.moex.MoexDataDto;
import com.avstp.moexservice.mapper.BondMapper;
import com.avstp.moexservice.mapper.StockMapper;
import com.avstp.moexservice.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MoexBondService implements BondService {
    private final CorporateBondsClient corporateBondsClient;
    private final GovernmentBondsClient governmentBondsClient;

    @Override
    public StocksDto getBondsByTickers(TickersDto tickersDto) {
        List<BondDto> allBonds = new ArrayList<>();
        allBonds.addAll(getGovernmentBonds());
        allBonds.addAll(getCorporateBonds());

        List<Stock> stocks = allBonds.stream()
                .filter(bondDto -> tickersDto.getTickers().contains(bondDto.getTicker()))
                .map(StockMapper::toStock)
                .collect(Collectors.toList());

        return new StocksDto(stocks);
    }

    public List<BondDto> getCorporateBonds() {
        log.info("Corporate bonds request");
        MoexDataDto bonds = corporateBondsClient.getBondsFromMoex();
        return BondMapper.toBondList(bonds.getDataDto());
    }

    public List<BondDto> getGovernmentBonds() {
        log.info("Government bonds request");
        MoexDataDto bonds = governmentBondsClient.getBondsFromMoex();
        return BondMapper.toBondList(bonds.getDataDto());
    }
}
