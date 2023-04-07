package com.example.demo.config.cache;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@Slf4j
public class SimpleCacheConfiguration {

    final CacheProperties properties;

    public SimpleCacheConfiguration(CacheProperties properties) {
        this.properties = properties;
    }


    @Bean("simpleCacheManager")
    public SimpleCacheManager simpleCacheCacheManager(CaffeineCacheManager caffeineCacheManager) {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();

        final List<Cache> caches = caffeineCacheManager.getCacheNames().stream()
                .map(caffeineCacheManager::getCache)
                .collect(Collectors.toList());

        cacheManager.setCaches(caches);

        return cacheManager;
    }

}
