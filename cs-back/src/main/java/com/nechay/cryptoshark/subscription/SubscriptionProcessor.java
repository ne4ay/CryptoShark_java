package com.nechay.cryptoshark.subscription;

import com.nechay.cryptoshark.connection.model.Market;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public interface SubscriptionProcessor {

    @Nonnull
    Market getDedicatedMarket();

    @Nonnull
    Mono<Void> subscribe(@Nonnull List<String> symbols);
}
