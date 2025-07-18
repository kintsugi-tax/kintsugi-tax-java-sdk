/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kintsugi.taxplatform.models.components.ValidationError;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("serial")
public class HTTPValidationError extends RuntimeException {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("detail")
    private Optional<? extends List<ValidationError>> detail;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("RawResponse")
    private Optional<? extends HttpResponse<InputStream>> rawResponse;

    @JsonCreator
    public HTTPValidationError(
            @JsonProperty("detail") Optional<? extends List<ValidationError>> detail,
            @JsonProperty("RawResponse") Optional<? extends HttpResponse<InputStream>> rawResponse) {
        super("API error occurred");
        Utils.checkNotNull(detail, "detail");
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.detail = detail;
        this.rawResponse = rawResponse;
    }
    
    public HTTPValidationError() {
        this(Optional.empty(), Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<ValidationError>> detail() {
        return (Optional<List<ValidationError>>) detail;
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


    public HTTPValidationError withDetail(List<ValidationError> detail) {
        Utils.checkNotNull(detail, "detail");
        this.detail = Optional.ofNullable(detail);
        return this;
    }


    public HTTPValidationError withDetail(Optional<? extends List<ValidationError>> detail) {
        Utils.checkNotNull(detail, "detail");
        this.detail = detail;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public HTTPValidationError withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = Optional.ofNullable(rawResponse);
        return this;
    }


    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public HTTPValidationError withRawResponse(Optional<? extends HttpResponse<InputStream>> rawResponse) {
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
        HTTPValidationError other = (HTTPValidationError) o;
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
        return Utils.toString(HTTPValidationError.class,
                "detail", detail,
                "rawResponse", rawResponse);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends List<ValidationError>> detail = Optional.empty();

        private Optional<? extends HttpResponse<InputStream>> rawResponse;

        private Builder() {
          // force use of static builder() method
        }


        public Builder detail(List<ValidationError> detail) {
            Utils.checkNotNull(detail, "detail");
            this.detail = Optional.ofNullable(detail);
            return this;
        }

        public Builder detail(Optional<? extends List<ValidationError>> detail) {
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

        public HTTPValidationError build() {

            return new HTTPValidationError(
                detail, rawResponse);
        }

    }
}

