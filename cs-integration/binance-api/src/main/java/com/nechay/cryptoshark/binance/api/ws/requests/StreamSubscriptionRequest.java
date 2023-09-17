package com.nechay.cryptoshark.binance.api.ws.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nechay.cryptoshark.binance.api.enums.StreamMethod;
import com.nechay.cryptoshark.binance.api.utils.BinanceStreamName;
import com.nechay.cryptoshark.binance.api.utils.BinanceUtils;
import com.nechay.cryptoshark.connection.model.StreamRequest;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author anechaev
 * @since 10.09.2023
 */
public class StreamSubscriptionRequest implements StreamRequest {
    @JsonProperty
    private StreamMethod method;
    @JsonProperty
    private List<String> params;
    @JsonProperty
    private long id;

    public StreamSubscriptionRequest(StreamMethod method, List<String> params, long id) {
        this.method = method;
        this.params = params;
        this.id = id;
    }

    public StreamSubscriptionRequest() {
    }

    public static StreamSubscriptionRequest subscribtion(List<String> symbols, BinanceStreamName streamName, long id) {
        return new StreamSubscriptionRequest(StreamMethod.SUBSCRIBE,
            BinanceUtils.toSubscriptionSymbols(symbols, streamName),
            id);
    }

    public StreamMethod getMethod() {
        return method;
    }

    public List<String> getParams() {
        return params;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StreamSubscriptionRequest that))
            return false;
        return id == that.id && method == that.method && Objects.equals(params, that.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, params, id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StreamSubscriptionRequest.class.getSimpleName() + "[", "]")
            .add("method=" + method)
            .add("params=" + params)
            .add("id=" + id)
            .toString();
    }

    public static class Builder {
        private StreamMethod method;
        private List<String> params;
        private long id;

        public Builder() {
            this.params = new ArrayList<>();
        }

        public Builder setMethod(StreamMethod method) {
            this.method = method;
            return this;
        }

        public Builder setParams(List<String> params) {
            this.params = params;
            return this;
        }

        public Builder addParam(String param) {
            this.params.add(param);
            return this;
        }

        public Builder addParams(@Nonnull List<String> params) {
            this.params.addAll(params);
            return this;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public StreamSubscriptionRequest build() {
            return new StreamSubscriptionRequest(method, params, id);
        }
    }
}
