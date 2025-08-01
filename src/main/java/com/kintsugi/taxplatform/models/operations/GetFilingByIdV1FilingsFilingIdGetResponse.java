/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.models.components.FilingDetailsRead;
import com.kintsugi.taxplatform.utils.Response;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Optional;


public class GetFilingByIdV1FilingsFilingIdGetResponse implements Response {
    /**
     * HTTP response content type for this operation
     */
    private String contentType;

    /**
     * HTTP response status code for this operation
     */
    private int statusCode;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    private HttpResponse<InputStream> rawResponse;

    /**
     * Successfully retrieved filing by id
     */
    private Optional<? extends FilingDetailsRead> filingDetailsRead;

    @JsonCreator
    public GetFilingByIdV1FilingsFilingIdGetResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends FilingDetailsRead> filingDetailsRead) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(filingDetailsRead, "filingDetailsRead");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.filingDetailsRead = filingDetailsRead;
    }
    
    public GetFilingByIdV1FilingsFilingIdGetResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse,
            Optional.empty());
    }

    /**
     * HTTP response content type for this operation
     */
    @JsonIgnore
    public String contentType() {
        return contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    @JsonIgnore
    public int statusCode() {
        return statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonIgnore
    public HttpResponse<InputStream> rawResponse() {
        return rawResponse;
    }

    /**
     * Successfully retrieved filing by id
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<FilingDetailsRead> filingDetailsRead() {
        return (Optional<FilingDetailsRead>) filingDetailsRead;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public GetFilingByIdV1FilingsFilingIdGetResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public GetFilingByIdV1FilingsFilingIdGetResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public GetFilingByIdV1FilingsFilingIdGetResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Successfully retrieved filing by id
     */
    public GetFilingByIdV1FilingsFilingIdGetResponse withFilingDetailsRead(FilingDetailsRead filingDetailsRead) {
        Utils.checkNotNull(filingDetailsRead, "filingDetailsRead");
        this.filingDetailsRead = Optional.ofNullable(filingDetailsRead);
        return this;
    }


    /**
     * Successfully retrieved filing by id
     */
    public GetFilingByIdV1FilingsFilingIdGetResponse withFilingDetailsRead(Optional<? extends FilingDetailsRead> filingDetailsRead) {
        Utils.checkNotNull(filingDetailsRead, "filingDetailsRead");
        this.filingDetailsRead = filingDetailsRead;
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
        GetFilingByIdV1FilingsFilingIdGetResponse other = (GetFilingByIdV1FilingsFilingIdGetResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.filingDetailsRead, other.filingDetailsRead);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            filingDetailsRead);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetFilingByIdV1FilingsFilingIdGetResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "filingDetailsRead", filingDetailsRead);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends FilingDetailsRead> filingDetailsRead = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(String contentType) {
            Utils.checkNotNull(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }


        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }


        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }


        /**
         * Successfully retrieved filing by id
         */
        public Builder filingDetailsRead(FilingDetailsRead filingDetailsRead) {
            Utils.checkNotNull(filingDetailsRead, "filingDetailsRead");
            this.filingDetailsRead = Optional.ofNullable(filingDetailsRead);
            return this;
        }

        /**
         * Successfully retrieved filing by id
         */
        public Builder filingDetailsRead(Optional<? extends FilingDetailsRead> filingDetailsRead) {
            Utils.checkNotNull(filingDetailsRead, "filingDetailsRead");
            this.filingDetailsRead = filingDetailsRead;
            return this;
        }

        public GetFilingByIdV1FilingsFilingIdGetResponse build() {

            return new GetFilingByIdV1FilingsFilingIdGetResponse(
                contentType, statusCode, rawResponse,
                filingDetailsRead);
        }

    }
}
