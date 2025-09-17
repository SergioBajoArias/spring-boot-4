package com.sergio.springboot4.apiClient;

import com.sergio.springboot4.dto.ObjectDto;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.registry.HttpServiceClient;

import java.util.List;

@HttpServiceClient(group = "testApi")
public interface TestApiClient {
    @GetExchange("/objects")
    List<ObjectDto> getObjects();
}
