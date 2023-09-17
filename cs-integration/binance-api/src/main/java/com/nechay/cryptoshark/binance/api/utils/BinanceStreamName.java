package com.nechay.cryptoshark.binance.api.utils;

import javax.annotation.Nonnull;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public enum BinanceStreamName {
    BOOK_TICKER("bookTicker")
    ;
    private final String presentation;

    BinanceStreamName(@Nonnull String presentation) {
        this.presentation = presentation;
    }

    public String getPresentation() {
        return presentation;
    }
}
