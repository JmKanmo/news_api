package com.service.news_api.config.thread;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        int n = Runtime.getRuntime().availableProcessors();
        threadPoolExecutor.setCorePoolSize(n);
        threadPoolExecutor.setThreadNamePrefix("news-api-");
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }
}