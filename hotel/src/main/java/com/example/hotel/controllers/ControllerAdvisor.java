package com.example.hotel.controllers;

import com.example.hotel.exceptions.ElementNotFoundException;
import com.example.hotel.models.dtos.ErrorDto;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDto> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDto.builder()
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }

//    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(){
//        ErrorDto error = ErrorDto.builder()
//                                .message(ex.getMessage())
//                                .method(HttpMethod.resolve(request.getMethod()))
//                                .uri(request.getRequestURI())
//                                .build();
//        error.getInfos().put("supported-method", ex.get);
//                );
//    }
}
