package com.sergio.springboot4.api;

import com.sergio.springboot4.service.AsyncTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/async")
public class AsyncTaskController {

    private final AsyncTaskService asyncTaskService;

    public AsyncTaskController(AsyncTaskService asyncTaskService) {
        this.asyncTaskService = asyncTaskService;
    }

    @PostMapping(value = "/launch", version = "1")
    public ResponseEntity<Void> launch() {
        asyncTaskService.launch(UUID.randomUUID().toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
