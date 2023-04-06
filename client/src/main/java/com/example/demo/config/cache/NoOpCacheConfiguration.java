package com.example.demo.config.cache;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class NoOpCacheConfiguration {

    final CacheProperties properties;

    public NoOpCacheConfiguration(CacheProperties properties) {
        this.properties = properties;
    }

    @Bean("noOpCacheManager")
    public NoOpCacheManager cacheManager() {
        return new NoOpCacheManager();
    }

}
