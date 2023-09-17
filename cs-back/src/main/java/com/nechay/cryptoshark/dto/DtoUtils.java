package com.nechay.cryptoshark.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author anechaev
 * @since 17.09.2023
 */
public final class DtoUtils {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private DtoUtils() { }
}
