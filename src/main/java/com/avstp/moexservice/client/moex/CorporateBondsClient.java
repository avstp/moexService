package com.avstp.moexservice.client.moex;

import com.avstp.moexservice.config.FeignLoggingConfiguration;
import com.avstp.moexservice.dto.moex.MoexDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "corporatebonds", url = "${moex.bonds.corporate.url}", configuration = FeignLoggingConfiguration.class)
public interface CorporateBondsClient {
    @GetMapping
    MoexDataDto getBondsFromMoex();
}
