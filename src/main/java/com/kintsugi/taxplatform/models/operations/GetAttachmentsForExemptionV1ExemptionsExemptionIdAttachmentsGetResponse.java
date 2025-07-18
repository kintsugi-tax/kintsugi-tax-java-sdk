/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.models.components.AttachmentRead;
import com.kintsugi.taxplatform.utils.Response;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;


public class GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse implements Response {
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
     * Successfully retrieved attachments for exemption
     */
    private Optional<? extends List<AttachmentRead>> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet;

    @JsonCreator
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends List<AttachmentRead>> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet, "response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet = response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet;
    }
    
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse(
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
     * Successfully retrieved attachments for exemption
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<AttachmentRead>> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet() {
        return (Optional<List<AttachmentRead>>) response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Successfully retrieved attachments for exemption
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse withResponse200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet(List<AttachmentRead> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet) {
        Utils.checkNotNull(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet, "response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet");
        this.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet = Optional.ofNullable(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet);
        return this;
    }


    /**
     * Successfully retrieved attachments for exemption
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse withResponse200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet(Optional<? extends List<AttachmentRead>> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet) {
        Utils.checkNotNull(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet, "response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet");
        this.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet = response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet;
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
        GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse other = (GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet, other.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet", response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends List<AttachmentRead>> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet = Optional.empty();

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
         * Successfully retrieved attachments for exemption
         */
        public Builder response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet(List<AttachmentRead> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet) {
            Utils.checkNotNull(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet, "response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet");
            this.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet = Optional.ofNullable(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet);
            return this;
        }

        /**
         * Successfully retrieved attachments for exemption
         */
        public Builder response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet(Optional<? extends List<AttachmentRead>> response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet) {
            Utils.checkNotNull(response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet, "response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet");
            this.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet = response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet;
            return this;
        }

        public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse build() {

            return new GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse(
                contentType, statusCode, rawResponse,
                response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet);
        }

    }
}
