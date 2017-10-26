package io.dropwizard.logging.json;

import ch.qos.logback.contrib.json.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Map;

/**
 * A custom Json formatter which is simpler and faster than the default one from `logback-contrib`.
 */
class DropwizardJsonFormatter implements JsonFormatter {

    private final ObjectMapper objectMapper;

    DropwizardJsonFormatter(ObjectMapper objectMapper, boolean prettyPrint) {
        this.objectMapper = prettyPrint ? objectMapper.enable(SerializationFeature.INDENT_OUTPUT) : objectMapper;
    }

    @Override
    public String toJsonString(Map m) throws IOException {
        return objectMapper.writeValueAsString(m);
    }
}
