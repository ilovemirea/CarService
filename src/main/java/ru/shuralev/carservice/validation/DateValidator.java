package ru.shuralev.carservice.validation;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Component
public class DateValidator {
    private final String DATE_PATTERN = "yyyy.MM.dd";

    public boolean isValidFormat(Date date) {
        String dateStr = date.toString();
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_PATTERN));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public boolean isValidFormat(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_PATTERN));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public boolean isDateBeforeCurrent(Date date) {
        Date currentDate = new Date();
        return date.before(currentDate);
    }
}
