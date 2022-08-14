package ru.shuralev.carservice.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shuralev.carservice.adapter.rest.dto.Statistics;
import ru.shuralev.carservice.service.StatisticService;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticService statisticService;

    @GetMapping()
    public Statistics getStatistics() {
        return statisticService.getStatistics();
    }
}
