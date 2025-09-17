package com.sergio.springboot4.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.AbstractClientHttpServiceRegistrar;

import java.util.List;

@Configuration
@Import(HttpClientConfig.TestApiClientHttpServiceRegistrar.class)
public class HttpClientConfig {
    static class TestApiClientHttpServiceRegistrar extends AbstractClientHttpServiceRegistrar {

        @Override
        protected void registerHttpServices(GroupRegistry registry, AnnotationMetadata metadata) {
            findAndRegisterHttpServiceClients(registry, List.of("com.sergio.springboot4.apiClient"));
        }
    }

    @Bean
    RestClientHttpServiceGroupConfigurer testApiServiceGroupConfigurer(
            @Value("${httpClient.testApi.name}") String apiName,
            @Value("${httpClient.testApi.baseUrl}") String baseUrl
    ) {
        return groups -> {
            groups.filterByName(apiName)
                    .forEachClient((group, clientBuilder) -> {
                        clientBuilder.baseUrl(baseUrl);
                    });
        };
    }
}
