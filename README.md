# Feign cacheable

Testing feign-client with dynamic cache managers: redis, hazel, simple, caffeine and no cache

## Result

./result.sh

```
Waiting heath check...OK
Generating result of 999 with 0 delay and cacheManager redisCacheManager

real    0m0.029s
user    0m0.002s
sys     0m0.004s
Generating result of 999 with 0 delay and cacheManager hazelCastCacheManager

real    0m0.012s
user    0m0.002s
sys     0m0.003s
Generating result of 999 with 0 delay and cacheManager simpleCacheManager

real    0m0.012s
user    0m0.002s
sys     0m0.003s
Generating result of 999 with 0 delay and cacheManager caffeineCacheManager

real    0m0.016s
user    0m0.002s
sys     0m0.003s
Generating result of 999 with 0 delay and cacheManager noCacheManager

real    0m0.015s
user    0m0.002s
sys     0m0.003s
Generating result of 9999 with 0 delay and cacheManager redisCacheManager

real    0m0.018s
user    0m0.002s
sys     0m0.004s
Generating result of 9999 with 0 delay and cacheManager hazelCastCacheManager

real    0m0.023s
user    0m0.002s
sys     0m0.004s
Generating result of 9999 with 0 delay and cacheManager simpleCacheManager

real    0m0.023s
user    0m0.002s
sys     0m0.004s
Generating result of 9999 with 0 delay and cacheManager caffeineCacheManager

real    0m0.027s
user    0m0.002s
sys     0m0.005s
Generating result of 9999 with 0 delay and cacheManager noCacheManager

real    0m0.032s
user    0m0.002s
sys     0m0.004s
Generating result of 99999 with 0 delay and cacheManager redisCacheManager

real    0m0.061s
user    0m0.003s
sys     0m0.008s
Generating result of 99999 with 0 delay and cacheManager hazelCastCacheManager

real    0m0.074s
user    0m0.003s
sys     0m0.008s
Generating result of 99999 with 0 delay and cacheManager simpleCacheManager

real    0m0.067s
user    0m0.003s
sys     0m0.008s
Generating result of 99999 with 0 delay and cacheManager caffeineCacheManager

real    0m0.039s
user    0m0.003s
sys     0m0.007s
Generating result of 99999 with 0 delay and cacheManager noCacheManager

real    0m0.051s
user    0m0.003s
sys     0m0.009s
Generating result of 999999 with 0 delay and cacheManager redisCacheManager

real    0m0.548s
user    0m0.007s
sys     0m0.063s
Generating result of 999999 with 0 delay and cacheManager hazelCastCacheManager

real    0m0.501s
user    0m0.007s
sys     0m0.066s
Generating result of 999999 with 0 delay and cacheManager simpleCacheManager

real    0m0.301s
user    0m0.006s
sys     0m0.057s
Generating result of 999999 with 0 delay and cacheManager caffeineCacheManager

real    0m0.283s
user    0m0.006s
sys     0m0.059s
Generating result of 999999 with 0 delay and cacheManager noCacheManager

real    0m0.565s
user    0m0.007s
sys     0m0.068s
Generating result of 9999999 with 0 delay and cacheManager redisCacheManager

real    0m3.826s
user    0m0.037s
sys     0m0.321s
Generating result of 9999999 with 0 delay and cacheManager hazelCastCacheManager

real    0m3.150s
user    0m0.037s
sys     0m0.344s
Generating result of 9999999 with 0 delay and cacheManager simpleCacheManager

real    0m2.837s
user    0m0.033s
sys     0m0.257s
Generating result of 9999999 with 0 delay and cacheManager caffeineCacheManager

real    0m2.591s
user    0m0.042s
sys     0m0.392s
Generating result of 9999999 with 0 delay and cacheManager noCacheManager

real    0m2.884s
user    0m0.035s
sys     0m0.330s
-rw-r--r--  1 cex  staff    23K Apr  6 00:39 999-caffeineCacheManager.json
-rw-r--r--  1 cex  staff    23K Apr  6 00:39 999-hazelCastCacheManager.json
-rw-r--r--  1 cex  staff    23K Apr  6 00:39 999-noCacheManager.json
-rw-r--r--  1 cex  staff    23K Apr  6 00:39 999-redisCacheManager.json
-rw-r--r--  1 cex  staff    23K Apr  6 00:39 999-simpleCacheManager.json
-rw-r--r--  1 cex  staff   229K Apr  6 00:39 9999-caffeineCacheManager.json
-rw-r--r--  1 cex  staff   229K Apr  6 00:39 9999-hazelCastCacheManager.json
-rw-r--r--  1 cex  staff   229K Apr  6 00:39 9999-noCacheManager.json
-rw-r--r--  1 cex  staff   229K Apr  6 00:39 9999-redisCacheManager.json
-rw-r--r--  1 cex  staff   229K Apr  6 00:39 9999-simpleCacheManager.json
-rw-r--r--  1 cex  staff   2.2M Apr  6 00:39 99999-caffeineCacheManager.json
-rw-r--r--  1 cex  staff   2.2M Apr  6 00:39 99999-hazelCastCacheManager.json
-rw-r--r--  1 cex  staff   2.2M Apr  6 00:39 99999-noCacheManager.json
-rw-r--r--  1 cex  staff   2.2M Apr  6 00:39 99999-redisCacheManager.json
-rw-r--r--  1 cex  staff   2.2M Apr  6 00:39 99999-simpleCacheManager.json
-rw-r--r--  1 cex  staff    22M Apr  6 00:39 999999-caffeineCacheManager.json
-rw-r--r--  1 cex  staff    22M Apr  6 00:39 999999-hazelCastCacheManager.json
-rw-r--r--  1 cex  staff    22M Apr  6 00:39 999999-noCacheManager.json
-rw-r--r--  1 cex  staff    22M Apr  6 00:39 999999-redisCacheManager.json
-rw-r--r--  1 cex  staff    22M Apr  6 00:39 999999-simpleCacheManager.json
-rw-r--r--  1 cex  staff   223M Apr  6 00:39 9999999-caffeineCacheManager.json
-rw-r--r--  1 cex  staff   223M Apr  6 00:39 9999999-hazelCastCacheManager.json
-rw-r--r--  1 cex  staff   223M Apr  6 00:39 9999999-noCacheManager.json
-rw-r--r--  1 cex  staff   223M Apr  6 00:39 9999999-redisCacheManager.json
-rw-r--r--  1 cex  staff   223M Apr  6 00:39 9999999-simpleCacheManager.json

real    0m18.007s
user    0m0.254s
sys     0m2.049s
```

