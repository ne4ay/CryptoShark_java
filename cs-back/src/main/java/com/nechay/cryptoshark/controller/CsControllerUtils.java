package com.nechay.cryptoshark.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public final class CsControllerUtils {
    private CsControllerUtils() { }

    public static <T> Mono<ResponseEntity<T>> createMonoResponse(@Nonnull T body, HttpStatus status) {
        return Mono.just(new ResponseEntity<>(body, status));
    }
}
