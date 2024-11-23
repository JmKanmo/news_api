package com.service.news_api.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/healthCheck")
@Slf4j
public class HealthCheckController {
    @GetMapping("")
    public ResponseEntity<String> healthCheck() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } catch (Exception exception) {
            log.error("[NewsController:healthCheck] error: {}", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
        }
    }
}
