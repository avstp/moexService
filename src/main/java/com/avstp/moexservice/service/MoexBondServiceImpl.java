package com.avstp.moexservice.service;

import com.avstp.moexservice.client.moex.CorporateBondsClient;
import com.avstp.moexservice.client.moex.GovernmentBondsClient;
import com.avstp.moexservice.dto.BondDto;
import com.avstp.moexservice.dto.moex.MoexDataDto;
import com.avstp.moexservice.mapper.BondMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoexBondServiceImpl implements MoexBondService {
    private final CorporateBondsClient corporateBondsClient;
    private final GovernmentBondsClient governmentBondsClient;

    @Override
    @Cacheable("corp")
    public List<BondDto> getCorporateBonds() {
        log.info("Corporate bonds request");
        MoexDataDto bonds = corporateBondsClient.getBondsFromMoex();
        return BondMapper.toBondList(bonds.getDataDto());
    }

    @Override
    @Cacheable("gov")
    public List<BondDto> getGovernmentBonds() {
        log.info("Government bonds request");
        MoexDataDto bonds = governmentBondsClient.getBondsFromMoex();
        return BondMapper.toBondList(bonds.getDataDto());
    }
}
