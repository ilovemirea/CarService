package ru.shuralev.carservice.adapter.rest.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shuralev.carservice.adapter.rest.statistics.dto.Statistics;
import ru.shuralev.carservice.app.api.statistics.GetStatistics;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final GetStatistics getStatistics;

    @GetMapping()
    public Statistics getStatistics() {
        return getStatistics.execute();
    }
}
