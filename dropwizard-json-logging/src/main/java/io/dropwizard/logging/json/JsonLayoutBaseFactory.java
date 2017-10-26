package io.dropwizard.logging.json;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.logging.json.layout.JsonStacktraceLayout;

import java.util.TimeZone;

@JsonTypeName("json")
public class JsonLayoutBaseFactory extends AbstractJsonLayoutBaseFactory<ILoggingEvent> {

    private boolean includeStackTrace = true;
    private boolean includeLevel = true;
    private boolean includeThreadName = true;
    private boolean includeMDC = true;
    private boolean includeLoggerName = true;
    private boolean includeFormattedMessage = true;
    private boolean includeMessage = false;
    private boolean includeException = true;
    private boolean includeContextName = true;

    @JsonProperty
    public boolean isIncludeLevel() {
        return includeLevel;
    }

    @JsonProperty
    public void setIncludeLevel(boolean includeLevel) {
        this.includeLevel = includeLevel;
    }

    @JsonProperty
    public boolean isIncludeThreadName() {
        return includeThreadName;
    }

    @JsonProperty
    public void setIncludeThreadName(boolean includeThreadName) {
        this.includeThreadName = includeThreadName;
    }

    @JsonProperty
    public boolean isIncludeMDC() {
        return includeMDC;
    }

    @JsonProperty
    public void setIncludeMDC(boolean includeMDC) {
        this.includeMDC = includeMDC;
    }

    @JsonProperty
    public boolean isIncludeLoggerName() {
        return includeLoggerName;
    }

    @JsonProperty
    public void setIncludeLoggerName(boolean includeLoggerName) {
        this.includeLoggerName = includeLoggerName;
    }

    @JsonProperty
    public boolean isIncludeFormattedMessage() {
        return includeFormattedMessage;
    }

    @JsonProperty
    public void setIncludeFormattedMessage(boolean includeFormattedMessage) {
        this.includeFormattedMessage = includeFormattedMessage;
    }

    @JsonProperty
    public boolean isIncludeMessage() {
        return includeMessage;
    }

    @JsonProperty
    public void setIncludeMessage(boolean includeMessage) {
        this.includeMessage = includeMessage;
    }

    @JsonProperty
    public boolean isIncludeException() {
        return includeException;
    }

    @JsonProperty
    public void setIncludeException(boolean includeException) {
        this.includeException = includeException;
    }

    @JsonProperty
    public boolean isIncludeContextName() {
        return includeContextName;
    }

    @JsonProperty
    public void setIncludeContextName(boolean includeContextName) {
        this.includeContextName = includeContextName;
    }

    @JsonProperty
    public boolean isIncludeStackTrace() {
        return includeStackTrace;
    }

    @JsonProperty
    public void setIncludeStackTrace(boolean includeStackTrace) {
        this.includeStackTrace = includeStackTrace;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LayoutBase<ILoggingEvent> build(LoggerContext context, TimeZone timeZone) {
        final JsonStacktraceLayout jsonLayout = new JsonStacktraceLayout(includeStackTrace);
        jsonLayout.setJsonFormatter(new DropwizardJsonFormatter(Jackson.newObjectMapper(), isPrettyPrint()));
        jsonLayout.setContext(context);
        jsonLayout.setTimestampFormat(getTimestampFormat());
        jsonLayout.setTimestampFormatTimezoneId(timeZone.getID());
        jsonLayout.setAppendLineSeparator(isAppendLineSeparator());

        jsonLayout.setIncludeLevel(includeLevel);
        jsonLayout.setIncludeThreadName(includeThreadName);
        jsonLayout.setIncludeMDC(includeMDC);
        jsonLayout.setIncludeLoggerName(includeLoggerName);
        jsonLayout.setIncludeFormattedMessage(includeFormattedMessage);
        jsonLayout.setIncludeMessage(includeMessage);
        jsonLayout.setIncludeException(includeException);
        jsonLayout.setIncludeContextName(includeContextName);
        return jsonLayout;
    }

}
