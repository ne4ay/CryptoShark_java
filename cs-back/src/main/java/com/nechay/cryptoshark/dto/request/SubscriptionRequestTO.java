package com.nechay.cryptoshark.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nechay.cryptoshark.connection.model.Market;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anechaev
 * @since 11.09.2023
 */
public class SubscriptionRequestTO {
    @JsonProperty
    private List<String> symbols;
    @JsonProperty
    private List<Market> markets;

    public SubscriptionRequestTO(List<String> symbols, List<Market> markets) {
        this.symbols = symbols;
        this.markets = markets;
    }

    public SubscriptionRequestTO() {
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public static class Builder {
        private List<String> symbols;
        private List<Market> markets;

        public Builder() {
            this.symbols = new ArrayList<>();
            this.markets = new ArrayList<>();
        }

        public Builder setSymbols(@Nonnull List<String> symbols) {
            this.symbols = symbols;
            return this;
        }

        public Builder addSymbol(@Nonnull String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public Builder setMarkets(@Nonnull List<Market> markets) {
            this.markets = markets;
            return this;
        }

        public Builder addMarket(@Nonnull Market market) {
            this.markets.add(market);
            return this;
        }

        public SubscriptionRequestTO create() {
            return new SubscriptionRequestTO(symbols, markets);
        }
    }
}
