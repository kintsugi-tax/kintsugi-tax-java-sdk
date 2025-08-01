/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.models.components.TransactionRead;
import com.kintsugi.taxplatform.utils.Response;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Optional;


public class UpdateTransactionV1TransactionsTransactionIdPutResponse implements Response {
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
     * Successful Response
     */
    private Optional<? extends TransactionRead> transactionRead;

    @JsonCreator
    public UpdateTransactionV1TransactionsTransactionIdPutResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends TransactionRead> transactionRead) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(transactionRead, "transactionRead");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.transactionRead = transactionRead;
    }
    
    public UpdateTransactionV1TransactionsTransactionIdPutResponse(
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
     * Successful Response
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<TransactionRead> transactionRead() {
        return (Optional<TransactionRead>) transactionRead;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public UpdateTransactionV1TransactionsTransactionIdPutResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public UpdateTransactionV1TransactionsTransactionIdPutResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UpdateTransactionV1TransactionsTransactionIdPutResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Successful Response
     */
    public UpdateTransactionV1TransactionsTransactionIdPutResponse withTransactionRead(TransactionRead transactionRead) {
        Utils.checkNotNull(transactionRead, "transactionRead");
        this.transactionRead = Optional.ofNullable(transactionRead);
        return this;
    }


    /**
     * Successful Response
     */
    public UpdateTransactionV1TransactionsTransactionIdPutResponse withTransactionRead(Optional<? extends TransactionRead> transactionRead) {
        Utils.checkNotNull(transactionRead, "transactionRead");
        this.transactionRead = transactionRead;
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
        UpdateTransactionV1TransactionsTransactionIdPutResponse other = (UpdateTransactionV1TransactionsTransactionIdPutResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.transactionRead, other.transactionRead);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            transactionRead);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateTransactionV1TransactionsTransactionIdPutResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "transactionRead", transactionRead);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends TransactionRead> transactionRead = Optional.empty();

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
         * Successful Response
         */
        public Builder transactionRead(TransactionRead transactionRead) {
            Utils.checkNotNull(transactionRead, "transactionRead");
            this.transactionRead = Optional.ofNullable(transactionRead);
            return this;
        }

        /**
         * Successful Response
         */
        public Builder transactionRead(Optional<? extends TransactionRead> transactionRead) {
            Utils.checkNotNull(transactionRead, "transactionRead");
            this.transactionRead = transactionRead;
            return this;
        }

        public UpdateTransactionV1TransactionsTransactionIdPutResponse build() {

            return new UpdateTransactionV1TransactionsTransactionIdPutResponse(
                contentType, statusCode, rawResponse,
                transactionRead);
        }

    }
}
