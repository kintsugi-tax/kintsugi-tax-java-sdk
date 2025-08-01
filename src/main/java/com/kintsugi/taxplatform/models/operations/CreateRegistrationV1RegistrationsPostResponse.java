/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.models.components.RegistrationRead;
import com.kintsugi.taxplatform.utils.Response;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Optional;


public class CreateRegistrationV1RegistrationsPostResponse implements Response {
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
     * Successfully created registration
     */
    private Optional<? extends RegistrationRead> registrationRead;

    @JsonCreator
    public CreateRegistrationV1RegistrationsPostResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends RegistrationRead> registrationRead) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(registrationRead, "registrationRead");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.registrationRead = registrationRead;
    }
    
    public CreateRegistrationV1RegistrationsPostResponse(
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
     * Successfully created registration
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<RegistrationRead> registrationRead() {
        return (Optional<RegistrationRead>) registrationRead;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public CreateRegistrationV1RegistrationsPostResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public CreateRegistrationV1RegistrationsPostResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public CreateRegistrationV1RegistrationsPostResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Successfully created registration
     */
    public CreateRegistrationV1RegistrationsPostResponse withRegistrationRead(RegistrationRead registrationRead) {
        Utils.checkNotNull(registrationRead, "registrationRead");
        this.registrationRead = Optional.ofNullable(registrationRead);
        return this;
    }


    /**
     * Successfully created registration
     */
    public CreateRegistrationV1RegistrationsPostResponse withRegistrationRead(Optional<? extends RegistrationRead> registrationRead) {
        Utils.checkNotNull(registrationRead, "registrationRead");
        this.registrationRead = registrationRead;
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
        CreateRegistrationV1RegistrationsPostResponse other = (CreateRegistrationV1RegistrationsPostResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.registrationRead, other.registrationRead);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            registrationRead);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateRegistrationV1RegistrationsPostResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "registrationRead", registrationRead);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends RegistrationRead> registrationRead = Optional.empty();

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
         * Successfully created registration
         */
        public Builder registrationRead(RegistrationRead registrationRead) {
            Utils.checkNotNull(registrationRead, "registrationRead");
            this.registrationRead = Optional.ofNullable(registrationRead);
            return this;
        }

        /**
         * Successfully created registration
         */
        public Builder registrationRead(Optional<? extends RegistrationRead> registrationRead) {
            Utils.checkNotNull(registrationRead, "registrationRead");
            this.registrationRead = registrationRead;
            return this;
        }

        public CreateRegistrationV1RegistrationsPostResponse build() {

            return new CreateRegistrationV1RegistrationsPostResponse(
                contentType, statusCode, rawResponse,
                registrationRead);
        }

    }
}
