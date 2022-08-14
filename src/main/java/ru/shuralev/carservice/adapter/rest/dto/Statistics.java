package ru.shuralev.carservice.adapter.rest.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Statistics {
    private Long personCount;
    private Long carCount;
    private Long uniqueVendorCount;
}