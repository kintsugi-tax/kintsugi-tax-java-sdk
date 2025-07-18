/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.kintsugi.taxplatform.utils.LazySingletonValue;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class Exemption {
    /**
     * Unique identifier for the exemption
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    /**
     * Timestamp when transaction was created in Kintsugi.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("created_at")
    private Optional<OffsetDateTime> createdAt;

    /**
     * Timestamp when transaction was last updated.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("updated_at")
    private JsonNullable<OffsetDateTime> updatedAt;


    @JsonProperty("exemption_type")
    private ExemptionType exemptionType;

    /**
     * The jurisdiction identifier for the exemption
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("jurisdiction")
    private JsonNullable<String> jurisdiction;

    /**
     * Country code in ISO 3166-1 alpha-2 format (e.g., 'US')
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("country_code")
    private JsonNullable<? extends CountryCodeEnum> countryCode;

    /**
     * Start date for the exemption validity period (YYYY-MM-DD format)
     */
    @JsonProperty("start_date")
    private LocalDate startDate;

    /**
     * End date for the exemption validity period (YYYY-MM-DD format)
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("end_date")
    private JsonNullable<LocalDate> endDate;

    /**
     * Unique identifier for the customer associated with the exemption
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("customer_id")
    private JsonNullable<String> customerId;

    /**
     * Unique identifier for the transaction
     *         associated with the exemption, if applicable.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("transaction_id")
    private JsonNullable<String> transactionId;

    /**
     * Indicates whether the exemption is for a reseller
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reseller")
    private Optional<Boolean> reseller;

    /**
     * Federal Employer Identification Number
     *         associated with the exemption.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("FEIN")
    private JsonNullable<String> fein;

    /**
     * Sales tax ID for the exemption
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sales_tax_id")
    private JsonNullable<String> salesTaxId;

    /**
     * The status of the exemption.
     *         Defaults to ACTIVE if not provided.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private JsonNullable<? extends ExemptionStatus> status;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("organization_id")
    private Optional<String> organizationId;

    @JsonCreator
    public Exemption(
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("created_at") Optional<OffsetDateTime> createdAt,
            @JsonProperty("updated_at") JsonNullable<OffsetDateTime> updatedAt,
            @JsonProperty("exemption_type") ExemptionType exemptionType,
            @JsonProperty("jurisdiction") JsonNullable<String> jurisdiction,
            @JsonProperty("country_code") JsonNullable<? extends CountryCodeEnum> countryCode,
            @JsonProperty("start_date") LocalDate startDate,
            @JsonProperty("end_date") JsonNullable<LocalDate> endDate,
            @JsonProperty("customer_id") JsonNullable<String> customerId,
            @JsonProperty("transaction_id") JsonNullable<String> transactionId,
            @JsonProperty("reseller") Optional<Boolean> reseller,
            @JsonProperty("FEIN") JsonNullable<String> fein,
            @JsonProperty("sales_tax_id") JsonNullable<String> salesTaxId,
            @JsonProperty("status") JsonNullable<? extends ExemptionStatus> status,
            @JsonProperty("organization_id") Optional<String> organizationId) {
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(updatedAt, "updatedAt");
        Utils.checkNotNull(exemptionType, "exemptionType");
        Utils.checkNotNull(jurisdiction, "jurisdiction");
        Utils.checkNotNull(countryCode, "countryCode");
        Utils.checkNotNull(startDate, "startDate");
        Utils.checkNotNull(endDate, "endDate");
        Utils.checkNotNull(customerId, "customerId");
        Utils.checkNotNull(transactionId, "transactionId");
        Utils.checkNotNull(reseller, "reseller");
        Utils.checkNotNull(fein, "fein");
        Utils.checkNotNull(salesTaxId, "salesTaxId");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(organizationId, "organizationId");
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.exemptionType = exemptionType;
        this.jurisdiction = jurisdiction;
        this.countryCode = countryCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.reseller = reseller;
        this.fein = fein;
        this.salesTaxId = salesTaxId;
        this.status = status;
        this.organizationId = organizationId;
    }
    
    public Exemption(
            ExemptionType exemptionType,
            LocalDate startDate) {
        this(Optional.empty(), Optional.empty(), JsonNullable.undefined(),
            exemptionType, JsonNullable.undefined(), JsonNullable.undefined(),
            startDate, JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty());
    }

    /**
     * Unique identifier for the exemption
     */
    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    /**
     * Timestamp when transaction was created in Kintsugi.
     */
    @JsonIgnore
    public Optional<OffsetDateTime> createdAt() {
        return createdAt;
    }

    /**
     * Timestamp when transaction was last updated.
     */
    @JsonIgnore
    public JsonNullable<OffsetDateTime> updatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    public ExemptionType exemptionType() {
        return exemptionType;
    }

    /**
     * The jurisdiction identifier for the exemption
     */
    @JsonIgnore
    public JsonNullable<String> jurisdiction() {
        return jurisdiction;
    }

    /**
     * Country code in ISO 3166-1 alpha-2 format (e.g., 'US')
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<CountryCodeEnum> countryCode() {
        return (JsonNullable<CountryCodeEnum>) countryCode;
    }

    /**
     * Start date for the exemption validity period (YYYY-MM-DD format)
     */
    @JsonIgnore
    public LocalDate startDate() {
        return startDate;
    }

    /**
     * End date for the exemption validity period (YYYY-MM-DD format)
     */
    @JsonIgnore
    public JsonNullable<LocalDate> endDate() {
        return endDate;
    }

    /**
     * Unique identifier for the customer associated with the exemption
     */
    @JsonIgnore
    public JsonNullable<String> customerId() {
        return customerId;
    }

    /**
     * Unique identifier for the transaction
     *         associated with the exemption, if applicable.
     */
    @JsonIgnore
    public JsonNullable<String> transactionId() {
        return transactionId;
    }

    /**
     * Indicates whether the exemption is for a reseller
     */
    @JsonIgnore
    public Optional<Boolean> reseller() {
        return reseller;
    }

    /**
     * Federal Employer Identification Number
     *         associated with the exemption.
     */
    @JsonIgnore
    public JsonNullable<String> fein() {
        return fein;
    }

    /**
     * Sales tax ID for the exemption
     */
    @JsonIgnore
    public JsonNullable<String> salesTaxId() {
        return salesTaxId;
    }

    /**
     * The status of the exemption.
     *         Defaults to ACTIVE if not provided.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ExemptionStatus> status() {
        return (JsonNullable<ExemptionStatus>) status;
    }

    @JsonIgnore
    public Optional<String> organizationId() {
        return organizationId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Unique identifier for the exemption
     */
    public Exemption withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }


    /**
     * Unique identifier for the exemption
     */
    public Exemption withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * Timestamp when transaction was created in Kintsugi.
     */
    public Exemption withCreatedAt(OffsetDateTime createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = Optional.ofNullable(createdAt);
        return this;
    }


    /**
     * Timestamp when transaction was created in Kintsugi.
     */
    public Exemption withCreatedAt(Optional<OffsetDateTime> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Timestamp when transaction was last updated.
     */
    public Exemption withUpdatedAt(OffsetDateTime updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = JsonNullable.of(updatedAt);
        return this;
    }

    /**
     * Timestamp when transaction was last updated.
     */
    public Exemption withUpdatedAt(JsonNullable<OffsetDateTime> updatedAt) {
        Utils.checkNotNull(updatedAt, "updatedAt");
        this.updatedAt = updatedAt;
        return this;
    }

    public Exemption withExemptionType(ExemptionType exemptionType) {
        Utils.checkNotNull(exemptionType, "exemptionType");
        this.exemptionType = exemptionType;
        return this;
    }

    /**
     * The jurisdiction identifier for the exemption
     */
    public Exemption withJurisdiction(String jurisdiction) {
        Utils.checkNotNull(jurisdiction, "jurisdiction");
        this.jurisdiction = JsonNullable.of(jurisdiction);
        return this;
    }

    /**
     * The jurisdiction identifier for the exemption
     */
    public Exemption withJurisdiction(JsonNullable<String> jurisdiction) {
        Utils.checkNotNull(jurisdiction, "jurisdiction");
        this.jurisdiction = jurisdiction;
        return this;
    }

    /**
     * Country code in ISO 3166-1 alpha-2 format (e.g., 'US')
     */
    public Exemption withCountryCode(CountryCodeEnum countryCode) {
        Utils.checkNotNull(countryCode, "countryCode");
        this.countryCode = JsonNullable.of(countryCode);
        return this;
    }

    /**
     * Country code in ISO 3166-1 alpha-2 format (e.g., 'US')
     */
    public Exemption withCountryCode(JsonNullable<? extends CountryCodeEnum> countryCode) {
        Utils.checkNotNull(countryCode, "countryCode");
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Start date for the exemption validity period (YYYY-MM-DD format)
     */
    public Exemption withStartDate(LocalDate startDate) {
        Utils.checkNotNull(startDate, "startDate");
        this.startDate = startDate;
        return this;
    }

    /**
     * End date for the exemption validity period (YYYY-MM-DD format)
     */
    public Exemption withEndDate(LocalDate endDate) {
        Utils.checkNotNull(endDate, "endDate");
        this.endDate = JsonNullable.of(endDate);
        return this;
    }

    /**
     * End date for the exemption validity period (YYYY-MM-DD format)
     */
    public Exemption withEndDate(JsonNullable<LocalDate> endDate) {
        Utils.checkNotNull(endDate, "endDate");
        this.endDate = endDate;
        return this;
    }

    /**
     * Unique identifier for the customer associated with the exemption
     */
    public Exemption withCustomerId(String customerId) {
        Utils.checkNotNull(customerId, "customerId");
        this.customerId = JsonNullable.of(customerId);
        return this;
    }

    /**
     * Unique identifier for the customer associated with the exemption
     */
    public Exemption withCustomerId(JsonNullable<String> customerId) {
        Utils.checkNotNull(customerId, "customerId");
        this.customerId = customerId;
        return this;
    }

    /**
     * Unique identifier for the transaction
     *         associated with the exemption, if applicable.
     */
    public Exemption withTransactionId(String transactionId) {
        Utils.checkNotNull(transactionId, "transactionId");
        this.transactionId = JsonNullable.of(transactionId);
        return this;
    }

    /**
     * Unique identifier for the transaction
     *         associated with the exemption, if applicable.
     */
    public Exemption withTransactionId(JsonNullable<String> transactionId) {
        Utils.checkNotNull(transactionId, "transactionId");
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Indicates whether the exemption is for a reseller
     */
    public Exemption withReseller(boolean reseller) {
        Utils.checkNotNull(reseller, "reseller");
        this.reseller = Optional.ofNullable(reseller);
        return this;
    }


    /**
     * Indicates whether the exemption is for a reseller
     */
    public Exemption withReseller(Optional<Boolean> reseller) {
        Utils.checkNotNull(reseller, "reseller");
        this.reseller = reseller;
        return this;
    }

    /**
     * Federal Employer Identification Number
     *         associated with the exemption.
     */
    public Exemption withFein(String fein) {
        Utils.checkNotNull(fein, "fein");
        this.fein = JsonNullable.of(fein);
        return this;
    }

    /**
     * Federal Employer Identification Number
     *         associated with the exemption.
     */
    public Exemption withFein(JsonNullable<String> fein) {
        Utils.checkNotNull(fein, "fein");
        this.fein = fein;
        return this;
    }

    /**
     * Sales tax ID for the exemption
     */
    public Exemption withSalesTaxId(String salesTaxId) {
        Utils.checkNotNull(salesTaxId, "salesTaxId");
        this.salesTaxId = JsonNullable.of(salesTaxId);
        return this;
    }

    /**
     * Sales tax ID for the exemption
     */
    public Exemption withSalesTaxId(JsonNullable<String> salesTaxId) {
        Utils.checkNotNull(salesTaxId, "salesTaxId");
        this.salesTaxId = salesTaxId;
        return this;
    }

    /**
     * The status of the exemption.
     *         Defaults to ACTIVE if not provided.
     */
    public Exemption withStatus(ExemptionStatus status) {
        Utils.checkNotNull(status, "status");
        this.status = JsonNullable.of(status);
        return this;
    }

    /**
     * The status of the exemption.
     *         Defaults to ACTIVE if not provided.
     */
    public Exemption withStatus(JsonNullable<? extends ExemptionStatus> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    public Exemption withOrganizationId(String organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = Optional.ofNullable(organizationId);
        return this;
    }


    public Exemption withOrganizationId(Optional<String> organizationId) {
        Utils.checkNotNull(organizationId, "organizationId");
        this.organizationId = organizationId;
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
        Exemption other = (Exemption) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.updatedAt, other.updatedAt) &&
            Utils.enhancedDeepEquals(this.exemptionType, other.exemptionType) &&
            Utils.enhancedDeepEquals(this.jurisdiction, other.jurisdiction) &&
            Utils.enhancedDeepEquals(this.countryCode, other.countryCode) &&
            Utils.enhancedDeepEquals(this.startDate, other.startDate) &&
            Utils.enhancedDeepEquals(this.endDate, other.endDate) &&
            Utils.enhancedDeepEquals(this.customerId, other.customerId) &&
            Utils.enhancedDeepEquals(this.transactionId, other.transactionId) &&
            Utils.enhancedDeepEquals(this.reseller, other.reseller) &&
            Utils.enhancedDeepEquals(this.fein, other.fein) &&
            Utils.enhancedDeepEquals(this.salesTaxId, other.salesTaxId) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.organizationId, other.organizationId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id, createdAt, updatedAt,
            exemptionType, jurisdiction, countryCode,
            startDate, endDate, customerId,
            transactionId, reseller, fein,
            salesTaxId, status, organizationId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Exemption.class,
                "id", id,
                "createdAt", createdAt,
                "updatedAt", updatedAt,
                "exemptionType", exemptionType,
                "jurisdiction", jurisdiction,
                "countryCode", countryCode,
                "startDate", startDate,
                "endDate", endDate,
                "customerId", customerId,
                "transactionId", transactionId,
                "reseller", reseller,
                "fein", fein,
                "salesTaxId", salesTaxId,
                "status", status,
                "organizationId", organizationId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> id = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private JsonNullable<OffsetDateTime> updatedAt = JsonNullable.undefined();

        private ExemptionType exemptionType;

        private JsonNullable<String> jurisdiction = JsonNullable.undefined();

        private JsonNullable<? extends CountryCodeEnum> countryCode = JsonNullable.undefined();

        private LocalDate startDate;

        private JsonNullable<LocalDate> endDate = JsonNullable.undefined();

        private JsonNullable<String> customerId = JsonNullable.undefined();

        private JsonNullable<String> transactionId = JsonNullable.undefined();

        private Optional<Boolean> reseller;

        private JsonNullable<String> fein = JsonNullable.undefined();

        private JsonNullable<String> salesTaxId = JsonNullable.undefined();

        private JsonNullable<? extends ExemptionStatus> status = JsonNullable.undefined();

        private Optional<String> organizationId = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Unique identifier for the exemption
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * Unique identifier for the exemption
         */
        public Builder id(Optional<String> id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * Timestamp when transaction was created in Kintsugi.
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * Timestamp when transaction was created in Kintsugi.
         */
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }


        /**
         * Timestamp when transaction was last updated.
         */
        public Builder updatedAt(OffsetDateTime updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = JsonNullable.of(updatedAt);
            return this;
        }

        /**
         * Timestamp when transaction was last updated.
         */
        public Builder updatedAt(JsonNullable<OffsetDateTime> updatedAt) {
            Utils.checkNotNull(updatedAt, "updatedAt");
            this.updatedAt = updatedAt;
            return this;
        }


        public Builder exemptionType(ExemptionType exemptionType) {
            Utils.checkNotNull(exemptionType, "exemptionType");
            this.exemptionType = exemptionType;
            return this;
        }


        /**
         * The jurisdiction identifier for the exemption
         */
        public Builder jurisdiction(String jurisdiction) {
            Utils.checkNotNull(jurisdiction, "jurisdiction");
            this.jurisdiction = JsonNullable.of(jurisdiction);
            return this;
        }

        /**
         * The jurisdiction identifier for the exemption
         */
        public Builder jurisdiction(JsonNullable<String> jurisdiction) {
            Utils.checkNotNull(jurisdiction, "jurisdiction");
            this.jurisdiction = jurisdiction;
            return this;
        }


        /**
         * Country code in ISO 3166-1 alpha-2 format (e.g., 'US')
         */
        public Builder countryCode(CountryCodeEnum countryCode) {
            Utils.checkNotNull(countryCode, "countryCode");
            this.countryCode = JsonNullable.of(countryCode);
            return this;
        }

        /**
         * Country code in ISO 3166-1 alpha-2 format (e.g., 'US')
         */
        public Builder countryCode(JsonNullable<? extends CountryCodeEnum> countryCode) {
            Utils.checkNotNull(countryCode, "countryCode");
            this.countryCode = countryCode;
            return this;
        }


        /**
         * Start date for the exemption validity period (YYYY-MM-DD format)
         */
        public Builder startDate(LocalDate startDate) {
            Utils.checkNotNull(startDate, "startDate");
            this.startDate = startDate;
            return this;
        }


        /**
         * End date for the exemption validity period (YYYY-MM-DD format)
         */
        public Builder endDate(LocalDate endDate) {
            Utils.checkNotNull(endDate, "endDate");
            this.endDate = JsonNullable.of(endDate);
            return this;
        }

        /**
         * End date for the exemption validity period (YYYY-MM-DD format)
         */
        public Builder endDate(JsonNullable<LocalDate> endDate) {
            Utils.checkNotNull(endDate, "endDate");
            this.endDate = endDate;
            return this;
        }


        /**
         * Unique identifier for the customer associated with the exemption
         */
        public Builder customerId(String customerId) {
            Utils.checkNotNull(customerId, "customerId");
            this.customerId = JsonNullable.of(customerId);
            return this;
        }

        /**
         * Unique identifier for the customer associated with the exemption
         */
        public Builder customerId(JsonNullable<String> customerId) {
            Utils.checkNotNull(customerId, "customerId");
            this.customerId = customerId;
            return this;
        }


        /**
         * Unique identifier for the transaction
         *         associated with the exemption, if applicable.
         */
        public Builder transactionId(String transactionId) {
            Utils.checkNotNull(transactionId, "transactionId");
            this.transactionId = JsonNullable.of(transactionId);
            return this;
        }

        /**
         * Unique identifier for the transaction
         *         associated with the exemption, if applicable.
         */
        public Builder transactionId(JsonNullable<String> transactionId) {
            Utils.checkNotNull(transactionId, "transactionId");
            this.transactionId = transactionId;
            return this;
        }


        /**
         * Indicates whether the exemption is for a reseller
         */
        public Builder reseller(boolean reseller) {
            Utils.checkNotNull(reseller, "reseller");
            this.reseller = Optional.ofNullable(reseller);
            return this;
        }

        /**
         * Indicates whether the exemption is for a reseller
         */
        public Builder reseller(Optional<Boolean> reseller) {
            Utils.checkNotNull(reseller, "reseller");
            this.reseller = reseller;
            return this;
        }


        /**
         * Federal Employer Identification Number
         *         associated with the exemption.
         */
        public Builder fein(String fein) {
            Utils.checkNotNull(fein, "fein");
            this.fein = JsonNullable.of(fein);
            return this;
        }

        /**
         * Federal Employer Identification Number
         *         associated with the exemption.
         */
        public Builder fein(JsonNullable<String> fein) {
            Utils.checkNotNull(fein, "fein");
            this.fein = fein;
            return this;
        }


        /**
         * Sales tax ID for the exemption
         */
        public Builder salesTaxId(String salesTaxId) {
            Utils.checkNotNull(salesTaxId, "salesTaxId");
            this.salesTaxId = JsonNullable.of(salesTaxId);
            return this;
        }

        /**
         * Sales tax ID for the exemption
         */
        public Builder salesTaxId(JsonNullable<String> salesTaxId) {
            Utils.checkNotNull(salesTaxId, "salesTaxId");
            this.salesTaxId = salesTaxId;
            return this;
        }


        /**
         * The status of the exemption.
         *         Defaults to ACTIVE if not provided.
         */
        public Builder status(ExemptionStatus status) {
            Utils.checkNotNull(status, "status");
            this.status = JsonNullable.of(status);
            return this;
        }

        /**
         * The status of the exemption.
         *         Defaults to ACTIVE if not provided.
         */
        public Builder status(JsonNullable<? extends ExemptionStatus> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = Optional.ofNullable(organizationId);
            return this;
        }

        public Builder organizationId(Optional<String> organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        public Exemption build() {
            if (reseller == null) {
                reseller = _SINGLETON_VALUE_Reseller.value();
            }

            return new Exemption(
                id, createdAt, updatedAt,
                exemptionType, jurisdiction, countryCode,
                startDate, endDate, customerId,
                transactionId, reseller, fein,
                salesTaxId, status, organizationId);
        }


        private static final LazySingletonValue<Optional<Boolean>> _SINGLETON_VALUE_Reseller =
                new LazySingletonValue<>(
                        "reseller",
                        "false",
                        new TypeReference<Optional<Boolean>>() {});
    }
}
