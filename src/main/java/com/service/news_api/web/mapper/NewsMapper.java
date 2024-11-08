package com.service.news_api.web.mapper;

import com.service.news_common.dto.NewsDto;
import com.service.news_common.dto.NewsReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<NewsDto> selectNewsList(NewsReq newsReq);
}
