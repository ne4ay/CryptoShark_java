package com.nechay.cryptoshark.app;

import com.nechay.cryptoshark.controller.TestController;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

/**
 * @author anechaev
 * @since 11.09.2023
 */
@Component
public class BinanceProperties {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Value("${binance.connection.websocket.address}")
    private String websocketStreamAddress;

    @PostConstruct
    public void init() {
        log.info("Binance properties: {}", this);
    }

    public String getWebsocketStreamAddress() {
        return websocketStreamAddress;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BinanceProperties.class.getSimpleName() + "[", "]")
            .add("websocketStreamAddress='" + websocketStreamAddress + "'")
            .toString();
    }
}
