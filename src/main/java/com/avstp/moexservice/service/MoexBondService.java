package com.avstp.moexservice.service;

import com.avstp.moexservice.dto.BondDto;

import java.util.List;

public interface MoexBondService {
    List<BondDto> getCorporateBonds();
    List<BondDto> getGovernmentBonds();
}
