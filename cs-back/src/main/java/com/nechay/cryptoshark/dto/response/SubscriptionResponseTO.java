package com.nechay.cryptoshark.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nechay.cryptoshark.dto.nested.SubscriptionMarketInfo;

import java.util.List;
import java.util.Objects;

/**
 * @author anechaev
 * @since 15.09.2023
 */
public class SubscriptionResponseTO {
    @JsonProperty
    private List<SubscriptionMarketInfo> marketInfos;

    public SubscriptionResponseTO(List<SubscriptionMarketInfo> marketInfos) {
        this.marketInfos = marketInfos;
    }

    public SubscriptionResponseTO() {
    }

    public List<SubscriptionMarketInfo> getMarketInfos() {
        return marketInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SubscriptionResponseTO that))
            return false;
        return Objects.equals(marketInfos, that.marketInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketInfos);
    }
}
