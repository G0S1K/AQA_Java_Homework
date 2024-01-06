package org.example.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Headers {
    @JsonProperty("x-forwarded-proto")
    private String xForwardedProto;

    @JsonProperty("x-forwarded-port")
    private String xForwardedPort;

    @JsonProperty("host")
    private String host;

    @JsonProperty("x-amzn-trace-id")
    private String xAmznTraceId;

    @JsonProperty("user-agent")
    private String userAgent;

    private String accept;

    @JsonProperty("content-type")
    private String contentType;

    @JsonProperty("content-length")
    private String contentLength;

    @JsonProperty("accept-encoding")
    private String acceptEncoding;
}
