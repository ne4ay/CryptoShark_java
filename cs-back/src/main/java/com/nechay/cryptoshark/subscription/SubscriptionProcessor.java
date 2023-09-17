package com.nechay.cryptoshark.subscription;

import com.nechay.cryptoshark.connection.model.Market;

import javax.annotation.Nonnull;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public interface SubscriptionProcessor {

    @Nonnull
    Market getDedicatedMarket();
}
