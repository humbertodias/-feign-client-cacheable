package com.example.demo.config.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@Slf4j
public class CompositeConfiguration {

    final CacheProperties properties;

    public CompositeConfiguration(CacheProperties properties) {
        this.properties = properties;
    }

    @Bean("compositeCacheManager")
    public CompositeCacheManager compositeCacheManager(CaffeineCacheManager caffeineCacheManager) {
        return new CompositeCacheManager(caffeineCacheManager);
    }

}
