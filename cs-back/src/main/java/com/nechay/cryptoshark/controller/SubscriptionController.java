package com.nechay.cryptoshark.controller;

import com.nechay.cryptoshark.dto.request.SubscriptionRequestTO;
import com.nechay.cryptoshark.exception.UnsupportedMarketException;
import com.nechay.cryptoshark.subscription.CompoundSubscriptionProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;

import static com.nechay.cryptoshark.controller.CsControllerUtils.createMonoResponse;
import static java.util.Objects.requireNonNull;

/**
 * @author anechaev
 * @since 11.09.2023
 */
@RestController
@RequestMapping(path = "/subscription")
public class SubscriptionController {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);

    private final CompoundSubscriptionProcessor processor;

    public SubscriptionController(@Autowired @Nonnull CompoundSubscriptionProcessor processor) {
        this.processor = requireNonNull(processor, "processor");
    }

    @PostMapping
    public Mono<ResponseEntity<String>> subscribe(@RequestBody SubscriptionRequestTO request) {
        return processor.subscribe(request)
            .map(response -> ResponseEntity.ok("Subscribed: " + response.getNewSymbols()))
            .onErrorResume(UnsupportedMarketException.class,
                exception -> createMonoResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
