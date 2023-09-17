package com.nechay.cryptoshark.subscription.concrete;

import com.nechay.cryptoshark.app.BinanceProperties;
import com.nechay.cryptoshark.binance.api.utils.BinanceStreamName;
import com.nechay.cryptoshark.binance.api.utils.BinanceUpdateSpeed;
import com.nechay.cryptoshark.binance.api.utils.BinanceUtils;
import com.nechay.cryptoshark.connection.model.Market;
import com.nechay.cryptoshark.controller.TestController;
import com.nechay.cryptoshark.subscription.SubscriptionProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import javax.annotation.Nonnull;

import java.net.URI;

import static java.util.Objects.requireNonNull;

/**
 * @author anechaev
 * @since 16.09.2023
 */
@Component
public class BinanceSubscriber implements SubscriptionProcessor {
    private static final Logger log = LoggerFactory.getLogger(BinanceSubscriber.class);

    private final BinanceProperties properties;
    private final WebSocketClient client;

    public BinanceSubscriber(@Autowired @Nonnull BinanceProperties properties) {
        this.properties = requireNonNull(properties, "properties");
        this.client = new ReactorNettyWebSocketClient();
        this.client.execute(constructAddress(), new BinanceWebSocketHandler())
            .block();
    }

    private URI constructAddress() {
        String stream = BinanceUtils.constructStream(BinanceStreamName.BOOK_TICKER, BinanceUpdateSpeed._100_MS);
        return URI.create(properties.getWebsocketStreamAddress() + "/" + stream);
    }

    @Nonnull
    @Override
    public Market getDedicatedMarket() {
        return Market.BINANCE;
    }
}
