#!/bin/bash

result(){
  delay=$1
  array=( 999 9999 99999 999999 9999999 )
  caches=( redisCacheManager hazelCastCacheManager simpleCacheManager caffeineCacheManager compositeCacheManager concurrentMapCacheManager noOpCacheManager)
  for amount in "${array[@]}"
  do
      for cacheManager in "${caches[@]}"
      do
        echo "Sync $cacheManager with $amount and $delay delay"
        time curl -s "http://localhost:9090/demo/person-sync?amount=$amount&delay=$delay&cacheManager=$cacheManager" > "sync-$amount-$cacheManager.json"
        echo "ASync $cacheManager with $amount and $delay delay"
        time curl -s "http://localhost:9090/demo/person-async?amount=$amount&delay=$delay&cacheManager=$cacheManager" > "async-$amount-$cacheManager.json"
      done
  done

  ls -lha *.json
  rm *.json

}

wait_health(){
  printf "\nWaiting heath check"
  until $(curl -s localhost:9191/actuator/health | grep -q UP); do
      printf '.'
      sleep 2
  done
  printf "OK\n"
}

docker-compose up -d
wait_health

time result 0

#docker-compose down -v