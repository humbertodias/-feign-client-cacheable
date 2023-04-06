package com.example.demo.config.cache;

import java.util.Arrays;

// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/cache/CacheManager.html
public enum CacheManagerType {
    REDIS("redisCacheManager"),
    CAFFEINE("caffeineCacheManager"),
    SIMPLE("simpleCacheManager"),
    HAZEL("hazelCastCacheManager"),
    COMPOSITE("compositeCacheManager"),
    MAP("concurrentMapCacheManager"),
    NOOP("noOpCacheManager");

    private final String name;

    CacheManagerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheManagerType findByName(String name){
        return Arrays.stream(values()).filter(e-> e.name.equals(name)).findFirst().orElse(NOOP);
    }
}
