package com.example.demo.interceptor;

import com.example.demo.util.MemoryHelper;
import com.example.demo.util.SerializerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheInterceptor;

import java.util.Objects;

@Slf4j
public class CacheLogInterceptor extends CacheInterceptor {

    private final ObjectMapper objectMapper = SerializerUtil.objectMapper();

    private int maxLength = 1024;

    @Override
    protected Cache.ValueWrapper doGet(Cache cache, Object key) {
        doLog("doGet", cache, key, null);
        return super.doGet(cache, key);
    }

    @Override
    protected void doPut(Cache cache, Object key, Object result) {
        doLog("doPut", cache, key, result);
        super.doPut(cache, key, result);
    }

    private String limit(String text) {
        return text != null && text.length() > maxLength ?
                text.substring(0, maxLength - 3) + "..." :
                text;
    }

    private void doLog(String method, Cache cache, Object key, Object result) {
        final Object value = cache.get(key);
        final String cacheKey = key(key);
        final String cacheValue = limit(value(value));
        log.debug("Cache.{} name {} key {} value {} result {}", method, cache.getName(), cacheKey, cacheValue, result);
        log.info(MemoryHelper.info());
    }

    @SneakyThrows
    private String key(Object key) {
        if (key == null) return null;
        return Objects.toString(key);
    }

    @SneakyThrows
    private String value(Object object) {
        if (object == null) return null;
        return objectMapper.writeValueAsString(object);
    }

}