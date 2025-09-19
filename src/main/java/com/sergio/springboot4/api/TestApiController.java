package com.sergio.springboot4.api;

import com.sergio.springboot4.apiClient.TestApiClient;
import com.sergio.springboot4.dto.TodoDto;
import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testApi")
public class TestApiController {

    private final TestApiClient testApiClient;

    public TestApiController(TestApiClient testApiClient) {
        this.testApiClient = testApiClient;
    }

    @GetMapping(path = "/todos", version = "1")
    @Retryable(maxAttempts = 3, delay = 100, multiplier = 2, maxDelay = 1000)
    @ConcurrencyLimit(3)
    public List<TodoDto> getTodos() {
        return testApiClient.getTodos();
    }
}
