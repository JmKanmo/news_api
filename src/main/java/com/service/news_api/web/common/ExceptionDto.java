package com.service.news_api.web.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDto {
    private final String message;
    private final int statusCode;
}

