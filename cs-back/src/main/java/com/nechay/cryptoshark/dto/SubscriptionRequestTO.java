package com.nechay.cryptoshark.dto;

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
    private Market market;

    public SubscriptionRequestTO(List<String> symbols, Market market) {
        this.symbols = symbols;
        this.market = market;
    }

    public SubscriptionRequestTO() {
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public Market getMarket() {
        return market;
    }

    public static class Builder {
        private List<String> symbols;
        private Market market;

        public Builder() {
            this.symbols = new ArrayList<>();
        }

        public Builder setSymbols(@Nonnull List<String> symbols) {
            this.symbols = symbols;
            return this;
        }

        public Builder addSymbol(@Nonnull String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public Builder setMarket(Market market) {
            this.market = market;
            return this;
        }

        public SubscriptionRequestTO create() {
            return new SubscriptionRequestTO(symbols, market);
        }
    }
}
