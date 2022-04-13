package com.avstp.moexservice.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class BondDto {
    String ticker;
    String name;
    BigDecimal price;
}
