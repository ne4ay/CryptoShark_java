package com.nechay.cryptoshark.subscription;

import com.nechay.cryptoshark.connection.model.Market;
import com.nechay.cryptoshark.dto.nested.SubscriptionMarketInfo;
import com.nechay.cryptoshark.dto.request.SubscriptionRequestTO;
import com.nechay.cryptoshark.dto.response.SubscriptionResponseTO;
import com.nechay.cryptoshark.exception.UnsupportedMarketException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author anechaev
 * @since 15.09.2023
 */
public class CompoundSubscriptionProcessor {

    private final Map<Market, List<SubscriptionProcessor>> concreteProcessors;

    public CompoundSubscriptionProcessor(@Nonnull List<SubscriptionProcessor> concreteProcessors) {
        this.concreteProcessors = concreteProcessors.stream()
            .collect(Collectors.groupingBy(SubscriptionProcessor::getDedicatedMarket));
    }

    public Mono<SubscriptionResponseTO> subscribe(@Nonnull SubscriptionRequestTO request) {
        Set<Market> markets = new HashSet<>(request.getMarkets());
        if (markets.isEmpty()) {
            return new UnsupportedMarketException("Markets are empty!").toMono();
        }
        if (!markets.contains(Market.BINANCE)) {
            return new UnsupportedMarketException("Unsupported market!").toMono();
        }
        List<String> symbols = request.getSymbols();
        if (symbols.isEmpty()) {
            return new UnsupportedMarketException("Symbols are empty!").toMono();
        }
        List<Mono<SubscriptionMarketInfo>> infos = concreteProcessors.entrySet()
            .stream()
            .filter(entry -> markets.contains(entry.getKey()))
            .map(Map.Entry::getValue)
            .flatMap(List::stream)
            .map(subscriptionProcessor -> subscriptionProcessor.subscribe(symbols))
            .toList();
        return Flux.concat(infos)
            .collectList()
            .map(SubscriptionResponseTO::new);
    }
}
