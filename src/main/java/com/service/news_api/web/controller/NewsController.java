package com.service.news_api.web.controller;

import com.service.news_api.web.service.NewsService;
import com.service.news_common.dto.NewsDto;
import com.service.news_common.dto.NewsReq;
import com.service.news_common.util.NewsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {
    private final NewsService newsService;

    @GetMapping("")
    public ResponseEntity<List<NewsDto>> searchNews(@ModelAttribute NewsReq newsReq) {
        try {
            if (NewsUtil.checkNewsReqHashCode(newsReq.getHashCode()) == false) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(newsService.selectNewsDto(newsReq));
        } catch (Exception exception) {
            log.error("[NewsController:searchNews] error: {}", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
