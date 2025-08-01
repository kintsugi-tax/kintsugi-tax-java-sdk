/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.models.components.CustomerRead;
import com.kintsugi.taxplatform.utils.Response;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Optional;


public class GetCustomerByIdV1CustomersCustomerIdGetResponse implements Response {
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
     * Successfully retrieved customer
     */
    private Optional<? extends CustomerRead> customerRead;

    @JsonCreator
    public GetCustomerByIdV1CustomersCustomerIdGetResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends CustomerRead> customerRead) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(customerRead, "customerRead");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.customerRead = customerRead;
    }
    
    public GetCustomerByIdV1CustomersCustomerIdGetResponse(
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
     * Successfully retrieved customer
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CustomerRead> customerRead() {
        return (Optional<CustomerRead>) customerRead;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public GetCustomerByIdV1CustomersCustomerIdGetResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public GetCustomerByIdV1CustomersCustomerIdGetResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public GetCustomerByIdV1CustomersCustomerIdGetResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Successfully retrieved customer
     */
    public GetCustomerByIdV1CustomersCustomerIdGetResponse withCustomerRead(CustomerRead customerRead) {
        Utils.checkNotNull(customerRead, "customerRead");
        this.customerRead = Optional.ofNullable(customerRead);
        return this;
    }


    /**
     * Successfully retrieved customer
     */
    public GetCustomerByIdV1CustomersCustomerIdGetResponse withCustomerRead(Optional<? extends CustomerRead> customerRead) {
        Utils.checkNotNull(customerRead, "customerRead");
        this.customerRead = customerRead;
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
        GetCustomerByIdV1CustomersCustomerIdGetResponse other = (GetCustomerByIdV1CustomersCustomerIdGetResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.customerRead, other.customerRead);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            customerRead);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetCustomerByIdV1CustomersCustomerIdGetResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "customerRead", customerRead);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String contentType;

        private Integer statusCode;

        private HttpResponse<InputStream> rawResponse;

        private Optional<? extends CustomerRead> customerRead = Optional.empty();

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
         * Successfully retrieved customer
         */
        public Builder customerRead(CustomerRead customerRead) {
            Utils.checkNotNull(customerRead, "customerRead");
            this.customerRead = Optional.ofNullable(customerRead);
            return this;
        }

        /**
         * Successfully retrieved customer
         */
        public Builder customerRead(Optional<? extends CustomerRead> customerRead) {
            Utils.checkNotNull(customerRead, "customerRead");
            this.customerRead = customerRead;
            return this;
        }

        public GetCustomerByIdV1CustomersCustomerIdGetResponse build() {

            return new GetCustomerByIdV1CustomersCustomerIdGetResponse(
                contentType, statusCode, rawResponse,
                customerRead);
        }

    }
}
