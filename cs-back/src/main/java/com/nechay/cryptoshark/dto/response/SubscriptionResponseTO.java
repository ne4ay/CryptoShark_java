package com.nechay.cryptoshark.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * @author anechaev
 * @since 15.09.2023
 */
public class SubscriptionResponseTO {
    @JsonProperty
    private List<String> newSymbols;

    public SubscriptionResponseTO(List<String> newSymbols) {
        this.newSymbols = newSymbols;
    }

    public SubscriptionResponseTO() {
    }

    public List<String> getNewSymbols() {
        return newSymbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SubscriptionResponseTO that))
            return false;
        return Objects.equals(newSymbols, that.newSymbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newSymbols);
    }
}
