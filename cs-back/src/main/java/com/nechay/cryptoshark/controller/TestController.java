package com.nechay.cryptoshark.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author anechaev
 * @since 11.09.2023
 */
@RestController
@RequestMapping(path = "/test")
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public Mono<String> getTest() {
        log.debug("Test get");
        return Mono.just("Just a simple test content");
    }

    @PostMapping
    public Mono<String> postTest() {
        return Mono.just("Just a simple test content for post");
    }
}
