package com.sergio.springboot4.api;

import com.sergio.springboot4.apiClient.TestApiClient;
import com.sergio.springboot4.dto.TodoDto;
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
    public List<TodoDto> getTodos() {
        return testApiClient.getTodos();
    }
}
