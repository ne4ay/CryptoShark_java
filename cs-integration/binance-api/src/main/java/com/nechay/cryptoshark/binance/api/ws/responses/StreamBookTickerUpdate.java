package com.nechay.cryptoshark.binance.api.ws.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nechay.cryptoshark.connection.model.StreamResponse;

import java.util.Objects;

/**
 * @author anechaev
 * @since 10.09.2023
 */
public class StreamBookTickerUpdate implements StreamResponse {
    @JsonProperty("u")
    private long updateId;
    @JsonProperty("s")
    private String symbol;
    @JsonProperty("b")
    private double bestBidPrice;
    @JsonProperty("B")
    private double bestBidQuantity;
    @JsonProperty("a")
    private double bestAskPrice;
    @JsonProperty("A")
    private double bestAskQuantity;

    public StreamBookTickerUpdate(long updateId, String symbol, double bestBidPrice, double bestBidQuantity,
        double bestAskPrice, double bestAskQuantity)
    {
        this.updateId = updateId;
        this.symbol = symbol;
        this.bestBidPrice = bestBidPrice;
        this.bestBidQuantity = bestBidQuantity;
        this.bestAskPrice = bestAskPrice;
        this.bestAskQuantity = bestAskQuantity;
    }

    public StreamBookTickerUpdate() {
    }

    public long getUpdateId() {
        return updateId;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getBestBidPrice() {
        return bestBidPrice;
    }

    public double getBestBidQuantity() {
        return bestBidQuantity;
    }

    public double getBestAskPrice() {
        return bestAskPrice;
    }

    public double getBestAskQuantity() {
        return bestAskQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StreamBookTickerUpdate that))
            return false;
        return updateId == that.updateId && Double.compare(that.bestBidPrice, bestBidPrice) == 0
            && Double.compare(that.bestBidQuantity, bestBidQuantity) == 0
            && Double.compare(that.bestAskPrice, bestAskPrice) == 0
            && Double.compare(that.bestAskQuantity, bestAskQuantity) == 0 && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updateId, symbol, bestBidPrice, bestBidQuantity, bestAskPrice, bestAskQuantity);
    }
}
