package com.nechay.cryptoshark.subscription.concrete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nechay.cryptoshark.binance.api.utils.BinanceStreamName;
import com.nechay.cryptoshark.binance.api.ws.requests.StreamSubscriptionRequest;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.nechay.cryptoshark.dto.DtoUtils.OBJECT_MAPPER;

/**
 * @author anechaev
 * @since 16.09.2023
 */
public class BinanceWebSocketHandler implements WebSocketHandler {


    @Override
    public Mono<Void> handle(WebSocketSession session) {
        String subscriptionMessage;
        try {
            subscriptionMessage = OBJECT_MAPPER.writeValueAsString(createSubRequest());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return session.send(Mono.just(session.textMessage(subscriptionMessage)))
            .thenMany(session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .log())
            .then();
    }

    private StreamSubscriptionRequest createSubRequest() {
        return StreamSubscriptionRequest.subscribtion(List.of("btcusdt"), BinanceStreamName.BOOK_TICKER, 1);
    }
}
