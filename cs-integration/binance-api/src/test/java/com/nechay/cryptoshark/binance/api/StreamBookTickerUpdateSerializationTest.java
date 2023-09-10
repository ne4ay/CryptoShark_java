package com.nechay.cryptoshark.binance.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nechay.cryptoshark.binance.api.ws.responses.StreamBookTickerUpdate;
import org.junit.jupiter.api.Test;

import javax.management.ObjectName;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author anechaev
 * @since 10.09.2023
 */
public class StreamBookTickerUpdateSerializationTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void testDeserialization() throws JsonProcessingException {
        var update = createUpdate();
        var message = """
                        {
                            "u": 38673004535,
                             "s": "BTCUSDT",
                             "b": "25616.91000000",
                             "B": "4.22437000",
                             "a": "25616.92000000",
                             "A": "19.19301000"
                        }""";
        var actualUpdate = OBJECT_MAPPER.readValue(message, StreamBookTickerUpdate.class);
        assertThat(actualUpdate, equalTo(update));
    }

    private StreamBookTickerUpdate createUpdate() {
        return new StreamBookTickerUpdate(
            38673004535L,
            "BTCUSDT",
            25616.91000000,
            4.22437000,
            25616.92000000,
            19.19301000);
    }
}
