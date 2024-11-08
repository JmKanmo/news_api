package com.service.news_api.web.common;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<ExceptionDto> httpRequestMethodNotSupportedHandler(Exception exception, Model model, HttpServletResponse httpServletResponse) {
        log.error("[newsApi-httpRequestMethodNotSupportedHandler] HttpRequestMethodNotSupportedException occurred ", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionDto.builder().statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                        .message(String.format("%s, 페이지를 새로고침 후 다시 시도해주세요.", exception))
                        .build());
    }
}
