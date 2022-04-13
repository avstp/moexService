package com.avstp.moexservice.controller;

import com.avstp.moexservice.dto.StocksDto;
import com.avstp.moexservice.dto.TickersDto;
import com.avstp.moexservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bond")
public class MoexBondController {
    private final BondService bondService;

    @GetMapping
    public StocksDto getBondsFromMoex(TickersDto tickersDto) {
        return bondService.getBondsByTickers(tickersDto);
    }
}
