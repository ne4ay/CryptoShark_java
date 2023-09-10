package com.nechay.cryptoshark.binance.api.utils;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.stream.Collectors;

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

}
