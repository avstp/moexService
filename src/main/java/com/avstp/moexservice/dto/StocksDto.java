package com.avstp.moexservice.dto;

import com.avstp.moexservice.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StocksDto {
    private List<Stock> stocks;
}
