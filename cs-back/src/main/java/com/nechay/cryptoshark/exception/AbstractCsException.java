package com.nechay.cryptoshark.exception;

import reactor.core.publisher.Mono;

/**
 * @author anechaev
 * @since 15.09.2023
 */
public abstract class AbstractCsException extends RuntimeException {

    public AbstractCsException(String message) {
        super(message);
    }

    public <T> Mono<T> toMono() {
        return Mono.error(this);
    }
}
