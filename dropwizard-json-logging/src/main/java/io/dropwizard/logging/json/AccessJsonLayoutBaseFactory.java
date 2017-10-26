package io.dropwizard.logging.json;

import ch.qos.logback.access.spi.IAccessEvent;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.contrib.json.access.JsonLayout;
import ch.qos.logback.core.LayoutBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.dropwizard.jackson.Jackson;

import java.util.TimeZone;

@JsonTypeName("access-json")
public class AccessJsonLayoutBaseFactory extends AbstractJsonLayoutBaseFactory<IAccessEvent> {

    private boolean includeRemoteAddr = true;
    private boolean includeRemoteUser = true;
    private boolean includeRequestTime = true;
    private boolean includeRequestURI = true;
    private boolean includeStatusCode = true;
    private boolean includeMethod = true;
    private boolean includeProtocol = true;
    private boolean includeContentLength = false;
    private boolean includeRequestURL = false;
    private boolean includeRemoteHost = true;
    private boolean includeServerName = true;
    private boolean includeRequestHeader = true;
    private boolean includeRequestParameter = true;
    private boolean includeLocalPort = false;
    private boolean includeRequestContent = false;
    private boolean includeResponseContent = false;

    @JsonProperty
    public boolean isIncludeRemoteAddr() {
        return includeRemoteAddr;
    }

    @JsonProperty
    public void setIncludeRemoteAddr(boolean includeRemoteAddr) {
        this.includeRemoteAddr = includeRemoteAddr;
    }

    @JsonProperty
    public boolean isIncludeRemoteUser() {
        return includeRemoteUser;
    }

    @JsonProperty
    public void setIncludeRemoteUser(boolean includeRemoteUser) {
        this.includeRemoteUser = includeRemoteUser;
    }

    @JsonProperty
    public boolean isIncludeRequestTime() {
        return includeRequestTime;
    }

    @JsonProperty
    public void setIncludeRequestTime(boolean includeRequestTime) {
        this.includeRequestTime = includeRequestTime;
    }

    @JsonProperty
    public boolean isIncludeRequestURI() {
        return includeRequestURI;
    }

    @JsonProperty
    public void setIncludeRequestURI(boolean includeRequestURI) {
        this.includeRequestURI = includeRequestURI;
    }

    @JsonProperty
    public boolean isIncludeStatusCode() {
        return includeStatusCode;
    }

    @JsonProperty
    public void setIncludeStatusCode(boolean includeStatusCode) {
        this.includeStatusCode = includeStatusCode;
    }

    @JsonProperty
    public boolean isIncludeMethod() {
        return includeMethod;
    }

    @JsonProperty
    public void setIncludeMethod(boolean includeMethod) {
        this.includeMethod = includeMethod;
    }

    @JsonProperty
    public boolean isIncludeProtocol() {
        return includeProtocol;
    }

    @JsonProperty
    public void setIncludeProtocol(boolean includeProtocol) {
        this.includeProtocol = includeProtocol;
    }

    @JsonProperty
    public boolean isIncludeContentLength() {
        return includeContentLength;
    }

    @JsonProperty
    public void setIncludeContentLength(boolean includeContentLength) {
        this.includeContentLength = includeContentLength;
    }

    @JsonProperty
    public boolean isIncludeRequestURL() {
        return includeRequestURL;
    }

    @JsonProperty
    public void setIncludeRequestURL(boolean includeRequestURL) {
        this.includeRequestURL = includeRequestURL;
    }

    @JsonProperty
    public boolean isIncludeRemoteHost() {
        return includeRemoteHost;
    }

    @JsonProperty
    public void setIncludeRemoteHost(boolean includeRemoteHost) {
        this.includeRemoteHost = includeRemoteHost;
    }

    @JsonProperty
    public boolean isIncludeServerName() {
        return includeServerName;
    }

    @JsonProperty
    public void setIncludeServerName(boolean includeServerName) {
        this.includeServerName = includeServerName;
    }

    @JsonProperty
    public boolean isIncludeRequestHeader() {
        return includeRequestHeader;
    }

    @JsonProperty
    public void setIncludeRequestHeader(boolean includeRequestHeader) {
        this.includeRequestHeader = includeRequestHeader;
    }

    @JsonProperty
    public boolean isIncludeRequestParameter() {
        return includeRequestParameter;
    }

    @JsonProperty
    public void setIncludeRequestParameter(boolean includeRequestParameter) {
        this.includeRequestParameter = includeRequestParameter;
    }

    @JsonProperty
    public boolean isIncludeLocalPort() {
        return includeLocalPort;
    }

    @JsonProperty
    public void setIncludeLocalPort(boolean includeLocalPort) {
        this.includeLocalPort = includeLocalPort;
    }

    @JsonProperty
    public boolean isIncludeRequestContent() {
        return includeRequestContent;
    }

    @JsonProperty
    public void setIncludeRequestContent(boolean includeRequestContent) {
        this.includeRequestContent = includeRequestContent;
    }

    @JsonProperty
    public boolean isIncludeResponseContent() {
        return includeResponseContent;
    }

    @JsonProperty
    public void setIncludeResponseContent(boolean includeResponseContent) {
        this.includeResponseContent = includeResponseContent;
    }

    @Override
    public LayoutBase<IAccessEvent> build(LoggerContext context, TimeZone timeZone) {
        final JsonLayout jsonLayout = new JsonLayout();
        jsonLayout.setContext(context);
        jsonLayout.setJsonFormatter(new DropwizardJsonFormatter(Jackson.newObjectMapper(), isPrettyPrint()));
        jsonLayout.setTimestampFormat(getTimestampFormat());
        jsonLayout.setTimestampFormatTimezoneId(timeZone.getID());
        jsonLayout.setAppendLineSeparator(isAppendLineSeparator());

        jsonLayout.setIncludeRemoteAddr(includeRemoteAddr);
        jsonLayout.setIncludeRequestContent(includeRequestContent);
        jsonLayout.setIncludeRequestHeader(includeRequestHeader);
        jsonLayout.setIncludeRequestParameter(includeRequestParameter);
        jsonLayout.setIncludeRequestTime(includeRequestTime);
        jsonLayout.setIncludeRequestURI(includeRequestURI);
        jsonLayout.setIncludeRequestURL(includeRequestURL);
        jsonLayout.setIncludeRemoteUser(includeRemoteUser);
        jsonLayout.setIncludeContentLength(includeContentLength);
        jsonLayout.setIncludeLocalPort(includeLocalPort);
        jsonLayout.setIncludeMethod(includeMethod);
        jsonLayout.setIncludeProtocol(includeProtocol);
        jsonLayout.setIncludeRemoteHost(includeRemoteHost);
        jsonLayout.setIncludeResponseContent(includeResponseContent);
        jsonLayout.setIncludeServerName(includeServerName);
        jsonLayout.setIncludeStatusCode(includeStatusCode);
        return jsonLayout;
    }
}
