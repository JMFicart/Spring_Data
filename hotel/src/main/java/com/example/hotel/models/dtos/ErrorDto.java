package com.example.hotel.models.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorDto {
    private final String message;
    private final int status;
    private final String uri;
    private final HttpMethod method;
    private final Map<String, Object> infos = new HashMap<>();

    public ErrorDto(String message, String uri, HttpMethod method) {
        this.message = message;
        this.method = method;
        this.status = 400;
        this.uri = uri;
    }

    public ErrorDto(String message, int status, String uri, HttpMethod method) {
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.method = method;
    }

    public ErrorDto(String message, int status, String uri, Map<String, Object> infos, HttpMethod method) {
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.method = method;
        this.infos.putAll(infos);
    }
}
