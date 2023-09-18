package com.nechay.cryptoshark.dto.nested;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nechay.cryptoshark.connection.model.Market;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

/**
 * @author anechaev
 * @since 18.09.2023
 */
public class SubscriptionMarketInfo {
    @JsonProperty
    private Market market;
    @JsonProperty
    private List<String> symbols;

    public SubscriptionMarketInfo(@Nonnull Market market, @Nonnull List<String> symbols) {
        this.market = market;
        this.symbols = symbols;
    }

    public SubscriptionMarketInfo() {
    }

    public Market getMarket() {
        return market;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SubscriptionMarketInfo that))
            return false;
        return market == that.market && Objects.equals(symbols, that.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(market, symbols);
    }
}
