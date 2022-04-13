package com.avstp.moexservice.mapper;

import com.avstp.moexservice.dto.BondDto;
import com.avstp.moexservice.dto.moex.MoexDataDto;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BondMapper {

    public List<BondDto> toBondList(MoexDataDto.DataDto dataDto) {
        return dataDto.getData().stream()
                .map(BondMapper::toBondDto)
                .collect(Collectors.toList());
    }

    private BondDto toBondDto(List<String> data) {
        if (data == null || data.size() != 3) {
            return null;
        }
        return BondDto.builder()
                .name(data.get(2))
                .price(data.get(1) == null ? null : new BigDecimal(data.get(1)))
                .ticker(data.get(0))
                .build();
    }
}
