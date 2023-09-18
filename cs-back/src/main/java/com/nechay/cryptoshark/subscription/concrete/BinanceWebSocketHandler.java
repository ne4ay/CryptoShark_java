package com.nechay.cryptoshark.subscription.concrete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nechay.cryptoshark.binance.api.utils.BinanceStreamName;
import com.nechay.cryptoshark.binance.api.ws.requests.StreamSubscriptionRequest;
import com.nechay.cryptoshark.connection.model.Market;
import com.nechay.cryptoshark.dto.nested.SubscriptionMarketInfo;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;
import java.util.List;

import static com.nechay.cryptoshark.dto.DtoUtils.OBJECT_MAPPER;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public class BinanceWebSocketHandler implements WebSocketHandler {

    private volatile WebSocketSession session;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        this.session = session;
        return session.receive()
            .map(WebSocketMessage::getPayloadAsText)
            .log()
            .then();
    }

    @Nonnull
    public Mono<SubscriptionMarketInfo> subscribe(@Nonnull List<String> symbols) {
        if (session == null) {
            return Mono.empty();
        }
        String subscriptionMessage;
        try {
            subscriptionMessage = OBJECT_MAPPER.writeValueAsString(createSubRequest(symbols));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        var message = this.session.textMessage(subscriptionMessage);
        return this.session.send(Mono.just(message))
            .then(Mono.just(createMarketInfo(symbols)));
    }

    private SubscriptionMarketInfo createMarketInfo(@Nonnull List<String> symbols) {
        return new SubscriptionMarketInfo(Market.BINANCE, symbols);
    }

    private StreamSubscriptionRequest createSubRequest(@Nonnull List<String> symbols) {
        return StreamSubscriptionRequest.subscribtion(symbols, BinanceStreamName.BOOK_TICKER, 1);
    }
}
