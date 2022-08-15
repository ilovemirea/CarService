package ru.shuralev.carservice.utility.validator;

import org.springframework.stereotype.Component;

@Component
public class CarModelValidator {

    public boolean isValid(String str) {
        if (str.contains("-")) {
            String vendor = str.substring(0, str.indexOf("-"));
            String model = str.substring(str.indexOf("-") + 1);

            return !model.isEmpty() && !vendor.isEmpty();
        }
        return false;
    }
}
