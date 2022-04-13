package com.avstp.moexservice.dto.moex;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoexDataDto {
    @JsonProperty("securities")
    private DataDto dataDto;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataDto {
        private List<String> columns;
        private List<List<String>> data;
    }
}
