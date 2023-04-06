package com.example.demo.config.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@Slf4j
public class JCacheConfiguration {

    final CacheProperties properties;

    public JCacheConfiguration(CacheProperties properties) {
        this.properties = properties;
    }

    @Bean("jCacheCacheManager")
    public JCacheCacheManager jCacheCacheManager() {
        final JCacheCacheManager cacheManager = new JCacheCacheManager();
        // TODO: TTL
        return cacheManager;
    }

}
