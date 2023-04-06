package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/demo")
public class DemoController {

    final PersonService personService;

    public DemoController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("person-sync")
    List<PersonDto> getPersonSync(@RequestParam(value = "amount", defaultValue = "10", required = false) int amount,
                                  @RequestParam(value = "delay", defaultValue = "0", required = false) int delay,
                                  @RequestParam(value = "cacheManager", defaultValue = "noCacheConfiguration", required = false) String cacheManager) {
        return personService.getPerson(amount, delay, cacheManager);
    }

    @GetMapping("server-url")
    public String getPersonClientUrl() {
        return personService.getPersonClientUrl();
    }

    @GetMapping("env")
    public Map<String, String> getEnv() {
        return System.getenv();
    }

    @GetMapping("person-async")
    Mono<List<PersonDto>> getPersonAsync(@RequestParam(value = "amount", defaultValue = "10", required = false) int amount,
                                         @RequestParam(value = "delay", defaultValue = "0", required = false) int delay,
                                         @RequestParam(value = "cacheManager", defaultValue = "noCacheConfiguration", required = false) String cacheManager) throws ExecutionException, InterruptedException {

        var future = CompletableFuture.completedFuture(personService.getPerson(amount, delay, cacheManager));
        return Flux
                .fromIterable(future.get())
                .collectList();
    }

}
