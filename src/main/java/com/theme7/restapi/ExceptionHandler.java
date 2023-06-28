package com.theme7.restapi;


import jakarta.annotation.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    //共通処理
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse re = new ErrorResponse(String.valueOf(status.value()), ex.getMessage());
        return super.handleExceptionInternal(ex, re, headers, status, request);
    }

    //未処理があった場合
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneralException(Exception exception, WebRequest request) {
        return new ErrorResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), "Unexpected Error");
    }

}


