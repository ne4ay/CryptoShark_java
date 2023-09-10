package com.nechay.cryptoshark.controller;

import com.nechay.cryptoshark.dto.SubscriptionRequestTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author anechaev
 * @since 11.09.2023
 */
@RestController
@RequestMapping(path = "/subscription")
public class SubscriptionController {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);
    @PostMapping
    public Mono<String> subscribe(@RequestBody SubscriptionRequestTO request) {
        return Mono.just("subscribed");
    }
}
