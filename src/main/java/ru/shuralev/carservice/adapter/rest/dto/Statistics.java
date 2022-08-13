package ru.shuralev.carservice.adapter.rest.dto;

import lombok.Data;

@Data
public class Statistics {
    private Long personCount;
    private Long carCount;
    private Long uniqueVendorCount;
}
