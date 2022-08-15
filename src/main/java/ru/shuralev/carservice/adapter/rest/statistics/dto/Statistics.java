package ru.shuralev.carservice.adapter.rest.statistics.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
    private Long personCount;
    private Long carCount;
    private Long uniqueVendorCount;
}