package com.sergio.springboot4.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSLConfig {
    @Value("${httpClient.truststore.file}") String file;
    @Value("${httpClient.truststore.password}") String password;

    @PostConstruct
    private void configureSSL() {
        System.setProperty("javax.net.ssl.trustStore", file);
        System.setProperty("javax.net.ssl.trustStorePassword", password);
    }
}
