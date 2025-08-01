/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Optional;


@SuppressWarnings("serial")
public class ErrorResponse extends RuntimeException {
    /**
     * Error message
     */
    @JsonProperty("detail")
    private String detail;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("RawResponse")
    private Optional<? extends HttpResponse<InputStream>> rawResponse;

    @JsonCreator
    public ErrorResponse(
            @JsonProperty("detail") String detail,
            @JsonProperty("RawResponse") Optional<? extends HttpResponse<InputStream>> rawResponse) {
        super("API error occurred");
        Utils.checkNotNull(detail, "detail");
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.detail = detail;
        this.rawResponse = rawResponse;
    }
    
    public ErrorResponse(
            String detail) {
        this(detail, Optional.empty());
    }

    /**
     * Error message
     */
    @JsonIgnore
    public String detail() {
        return detail;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<HttpResponse<InputStream>> rawResponse() {
        return (Optional<HttpResponse<InputStream>>) rawResponse;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Error message
     */
    public ErrorResponse withDetail(String detail) {
        Utils.checkNotNull(detail, "detail");
        this.detail = detail;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ErrorResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = Optional.ofNullable(rawResponse);
        return this;
    }


    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public ErrorResponse withRawResponse(Optional<? extends HttpResponse<InputStream>> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorResponse other = (ErrorResponse) o;
        return 
            Utils.enhancedDeepEquals(this.detail, other.detail) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            detail, rawResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ErrorResponse.class,
                "detail", detail,
                "rawResponse", rawResponse);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String detail;

        private Optional<? extends HttpResponse<InputStream>> rawResponse;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Error message
         */
        public Builder detail(String detail) {
            Utils.checkNotNull(detail, "detail");
            this.detail = detail;
            return this;
        }


        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = Optional.ofNullable(rawResponse);
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(Optional<? extends HttpResponse<InputStream>> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }

        public ErrorResponse build() {

            return new ErrorResponse(
                detail, rawResponse);
        }

    }
}

