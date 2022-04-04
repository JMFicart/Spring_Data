package com.example.hotel.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDto {
    private final String message;
    private final int status;
    private final String uri;
    private final Map<String, Object> infos = new HashMap<>();

    public ErrorDto(String message, String uri) {
        this.message = message;
        this.status = 400;
        this.uri = uri;
    }

    public ErrorDto(String message, int status, String uri) {
        this.message = message;
        this.status = status;
        this.uri = uri;
    }

    public ErrorDto(String message, int status, String uri, Map<String, Object> infos) {
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.infos.putAll(infos);
    }
}
