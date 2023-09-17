package com.nechay.cryptoshark.app;

import com.nechay.cryptoshark.subscription.CompoundSubscriptionProcessor;
import com.nechay.cryptoshark.subscription.concrete.BinanceSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author anechaev
 * @since 16.09.2023
 */
@Configuration
public class CsBackBeansConfiguration {


    @Bean
    public CompoundSubscriptionProcessor subscriptionProcessor(@Nonnull BinanceSubscriber binanceSubscriber) {
        return new CompoundSubscriptionProcessor(List.of(
            binanceSubscriber
        ));
    }
}
