package io.dropwizard.logging.json.layout;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.contrib.jackson.JacksonJsonFormatter;
import ch.qos.logback.contrib.json.classic.JsonLayout;
import io.dropwizard.jackson.Jackson;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonStacktraceLayout extends JsonLayout {

    private static final String STACKTRACE_ATTR_NAME = "stacktrace";

    private final boolean includeStacktrace;

    public JsonStacktraceLayout(boolean includeStacktrace) {
        this.includeStacktrace = includeStacktrace;
    }

    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        if (!includeStacktrace || event.getThrowableProxy() == null) {
            return;
        }

        final StackTraceElementProxy[] stackTraces = event.getThrowableProxy().getStackTraceElementProxyArray();
        if (stackTraces == null || stackTraces.length == 0) {
            return;
        }

        map.put(STACKTRACE_ATTR_NAME, Arrays.stream(stackTraces)
            .map(StackTraceElementProxy::getSTEAsString)
            .collect(Collectors.joining(System.lineSeparator())));
    }
}
