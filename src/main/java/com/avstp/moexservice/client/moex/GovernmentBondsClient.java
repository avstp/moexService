package com.avstp.moexservice.client.moex;

import com.avstp.moexservice.config.FeignLoggingConfiguration;
import com.avstp.moexservice.dto.moex.MoexDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "governmentbonds", url = "${moex.bonds.government.url}", configuration = FeignLoggingConfiguration.class)
public interface GovernmentBondsClient {

    @GetMapping
    MoexDataDto getBondsFromMoex();
}
