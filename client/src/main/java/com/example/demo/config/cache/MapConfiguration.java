package com.example.demo.config.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@Slf4j
public class MapConfiguration {

    final CacheProperties properties;

    public MapConfiguration(CacheProperties properties) {
        this.properties = properties;
    }

    @Bean("concurrentMapCacheManager")
    public ConcurrentMapCacheManager concurrentMapCacheManager(CaffeineCacheManager caffeineCacheManager) {
        final ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(caffeineCacheManager.getCacheNames());
        return cacheManager;
    }

}
