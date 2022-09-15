package ru.k1mo.contest.restapi_yandex.handler;

public class ValidationItemException extends RuntimeException{
    public ValidationItemException(String message) {
        super(message);
    }
}
