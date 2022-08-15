package ru.shuralev.carservice.validation;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Component
public class DateValidator {
    private final String DATE_PATTERN = "dd.MM.yyyy";

    public boolean isValidFormat(LocalDate date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        String dateStr = dateFormat.format(date);
        try {
            dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
