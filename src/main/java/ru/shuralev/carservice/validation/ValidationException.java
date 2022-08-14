package ru.shuralev.carservice.validation;

import java.io.Serial;

public class ValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1633754699258321987L;

    public ValidationException(String message) {
        super(message);
    }
}
