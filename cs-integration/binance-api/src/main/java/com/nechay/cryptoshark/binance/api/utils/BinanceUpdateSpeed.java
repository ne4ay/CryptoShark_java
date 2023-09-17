package com.nechay.cryptoshark.binance.api.utils;

import javax.annotation.Nonnull;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public enum BinanceUpdateSpeed {
    _100_MS("100"),
    _1000_MS("1000"),
    _2000_MS("2000")
    ;
    private static final String POSTFIX = "ms";

    private final String value;

    BinanceUpdateSpeed(@Nonnull String value) {
        this.value = value;
    }

    public String getPresentation() {
        return value + POSTFIX;
    }
}
