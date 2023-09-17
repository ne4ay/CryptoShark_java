package com.nechay.cryptoshark.binance.api.utils;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author anechaev
 * @since 10.09.2023
 */
public class BinanceUtils {
    public static final String PARAM_DELIMITER = "@";

    @Nonnull
    public static String constructParameter(@Nonnull String ... parts) {
        return String.join(PARAM_DELIMITER, parts);
    }

    @Nonnull
    public static String constructStream(@Nonnull BinanceStreamName streamName, @Nonnull BinanceUpdateSpeed updateSpeed) {
        return constructParameter(
            streamName.getPresentation(),
            updateSpeed.getPresentation());
    }

    @Nonnull
    public static List<String> toSubscriptionSymbols(@Nonnull List<String> instrumentSymbols, @Nonnull BinanceStreamName streamName) {
        return instrumentSymbols.stream()
            .map(symbol -> symbol + PARAM_DELIMITER + streamName.getPresentation())
            .toList();
    }

}
