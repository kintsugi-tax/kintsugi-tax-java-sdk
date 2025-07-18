/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.models.components.TransactionPublicRequest;
import com.kintsugi.taxplatform.utils.SpeakeasyMetadata;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;


public class CreateTransactionV1TransactionsPostRequest {
    /**
     * The unique identifier for the organization making the request
     */
    @SpeakeasyMetadata("header:style=simple,explode=false,name=x-organization-id")
    private Optional<String> xOrganizationId;


    @SpeakeasyMetadata("request:mediaType=application/json")
    private TransactionPublicRequest transactionPublicRequest;

    @JsonCreator
    public CreateTransactionV1TransactionsPostRequest(
            Optional<String> xOrganizationId,
            TransactionPublicRequest transactionPublicRequest) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        Utils.checkNotNull(transactionPublicRequest, "transactionPublicRequest");
        this.xOrganizationId = xOrganizationId;
        this.transactionPublicRequest = transactionPublicRequest;
    }
    
    public CreateTransactionV1TransactionsPostRequest(
            TransactionPublicRequest transactionPublicRequest) {
        this(Optional.empty(), transactionPublicRequest);
    }

    /**
     * The unique identifier for the organization making the request
     */
    @JsonIgnore
    public Optional<String> xOrganizationId() {
        return xOrganizationId;
    }

    @JsonIgnore
    public TransactionPublicRequest transactionPublicRequest() {
        return transactionPublicRequest;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier for the organization making the request
     */
    public CreateTransactionV1TransactionsPostRequest withXOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.ofNullable(xOrganizationId);
        return this;
    }


    /**
     * The unique identifier for the organization making the request
     */
    public CreateTransactionV1TransactionsPostRequest withXOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
        return this;
    }

    public CreateTransactionV1TransactionsPostRequest withTransactionPublicRequest(TransactionPublicRequest transactionPublicRequest) {
        Utils.checkNotNull(transactionPublicRequest, "transactionPublicRequest");
        this.transactionPublicRequest = transactionPublicRequest;
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
        CreateTransactionV1TransactionsPostRequest other = (CreateTransactionV1TransactionsPostRequest) o;
        return 
            Utils.enhancedDeepEquals(this.xOrganizationId, other.xOrganizationId) &&
            Utils.enhancedDeepEquals(this.transactionPublicRequest, other.transactionPublicRequest);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            xOrganizationId, transactionPublicRequest);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateTransactionV1TransactionsPostRequest.class,
                "xOrganizationId", xOrganizationId,
                "transactionPublicRequest", transactionPublicRequest);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> xOrganizationId = Optional.empty();

        private TransactionPublicRequest transactionPublicRequest;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The unique identifier for the organization making the request
         */
        public Builder xOrganizationId(String xOrganizationId) {
            Utils.checkNotNull(xOrganizationId, "xOrganizationId");
            this.xOrganizationId = Optional.ofNullable(xOrganizationId);
            return this;
        }

        /**
         * The unique identifier for the organization making the request
         */
        public Builder xOrganizationId(Optional<String> xOrganizationId) {
            Utils.checkNotNull(xOrganizationId, "xOrganizationId");
            this.xOrganizationId = xOrganizationId;
            return this;
        }


        public Builder transactionPublicRequest(TransactionPublicRequest transactionPublicRequest) {
            Utils.checkNotNull(transactionPublicRequest, "transactionPublicRequest");
            this.transactionPublicRequest = transactionPublicRequest;
            return this;
        }

        public CreateTransactionV1TransactionsPostRequest build() {

            return new CreateTransactionV1TransactionsPostRequest(
                xOrganizationId, transactionPublicRequest);
        }

    }
}
