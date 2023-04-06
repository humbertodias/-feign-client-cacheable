#!/bin/bash

result(){
  delay=$1
  array=( 999 9999 99999 999999 9999999 )
  caches=( redisCacheManager hazelCastCacheManager simpleCacheManager caffeineCacheManager noCacheManager)
  for amount in "${array[@]}"
  do
      for cacheManager in "${caches[@]}"
      do
        echo "Generating result of $amount with $delay delay and cacheManager $cacheManager"
        time curl -s "http://localhost:9191/api/faker?amount=$amount&delay=$delay&cacheManager=$cacheManager" > "$amount-$cacheManager.json"
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

docker-compose down -v