package com.sergio.springboot4.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService{
    @Async
    public void launch(String id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Executed task with id {}", id);
    }
}
