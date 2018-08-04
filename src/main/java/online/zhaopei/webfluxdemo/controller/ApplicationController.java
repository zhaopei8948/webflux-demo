package online.zhaopei.webfluxdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ApplicationController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome receive hello world!");
    }
}
