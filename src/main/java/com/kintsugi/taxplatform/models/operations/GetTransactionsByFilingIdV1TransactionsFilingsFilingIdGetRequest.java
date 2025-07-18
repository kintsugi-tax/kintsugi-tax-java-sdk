/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.utils.SpeakeasyMetadata;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;


public class GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest {
    /**
     * The unique identifier of the filing
     *         whose transactions you wish to retrieve.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=filing_id")
    private String filingId;

    /**
     * The unique identifier for the organization making the request
     */
    @SpeakeasyMetadata("header:style=simple,explode=false,name=x-organization-id")
    private Optional<String> xOrganizationId;

    @JsonCreator
    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest(
            String filingId,
            Optional<String> xOrganizationId) {
        Utils.checkNotNull(filingId, "filingId");
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.filingId = filingId;
        this.xOrganizationId = xOrganizationId;
    }
    
    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest(
            String filingId) {
        this(filingId, Optional.empty());
    }

    /**
     * The unique identifier of the filing
     *         whose transactions you wish to retrieve.
     */
    @JsonIgnore
    public String filingId() {
        return filingId;
    }

    /**
     * The unique identifier for the organization making the request
     */
    @JsonIgnore
    public Optional<String> xOrganizationId() {
        return xOrganizationId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier of the filing
     *         whose transactions you wish to retrieve.
     */
    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest withFilingId(String filingId) {
        Utils.checkNotNull(filingId, "filingId");
        this.filingId = filingId;
        return this;
    }

    /**
     * The unique identifier for the organization making the request
     */
    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest withXOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.ofNullable(xOrganizationId);
        return this;
    }


    /**
     * The unique identifier for the organization making the request
     */
    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest withXOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
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
        GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest other = (GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest) o;
        return 
            Utils.enhancedDeepEquals(this.filingId, other.filingId) &&
            Utils.enhancedDeepEquals(this.xOrganizationId, other.xOrganizationId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            filingId, xOrganizationId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest.class,
                "filingId", filingId,
                "xOrganizationId", xOrganizationId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String filingId;

        private Optional<String> xOrganizationId = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The unique identifier of the filing
         *         whose transactions you wish to retrieve.
         */
        public Builder filingId(String filingId) {
            Utils.checkNotNull(filingId, "filingId");
            this.filingId = filingId;
            return this;
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

        public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest build() {

            return new GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest(
                filingId, xOrganizationId);
        }

    }
}
