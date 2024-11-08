package com.service.news_api.web.service;

import com.service.news_api.web.mapper.NewsMapper;
import com.service.news_common.dto.NewsDto;
import com.service.news_common.dto.NewsReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class NewsService {
    private final NewsMapper newsMapper;

    public List<NewsDto> selectNewsDto(NewsReq newsReq) {
        return newsMapper.selectNewsList(newsReq);
    }
}
