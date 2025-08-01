/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.Optional;


public class PhysicalNexusCreate {

    @JsonProperty("country_code")
    private CountryCodeEnum countryCode;

    /**
     * The state or province code in
     *                             ISO 3166-2 format (e.g., CA).
     */
    @JsonProperty("state_code")
    private String stateCode;

    /**
     * The date when the nexus became
     *                             effective (YYYY-MM-DD).
     */
    @JsonProperty("start_date")
    private LocalDate startDate;

    /**
     * The date when the
     *                                         nexus ended, if applicable.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("end_date")
    private Optional<String> endDate;


    @JsonProperty("category")
    private PhysicalNexusCategory category;

    /**
     * Optional
     *                                         external identifier for the nexus.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("external_id")
    private Optional<String> externalId;

    @JsonCreator
    public PhysicalNexusCreate(
            @JsonProperty("country_code") CountryCodeEnum countryCode,
            @JsonProperty("state_code") String stateCode,
            @JsonProperty("start_date") LocalDate startDate,
            @JsonProperty("end_date") Optional<String> endDate,
            @JsonProperty("category") PhysicalNexusCategory category,
            @JsonProperty("external_id") Optional<String> externalId) {
        Utils.checkNotNull(countryCode, "countryCode");
        Utils.checkNotNull(stateCode, "stateCode");
        Utils.checkNotNull(startDate, "startDate");
        Utils.checkNotNull(endDate, "endDate");
        Utils.checkNotNull(category, "category");
        Utils.checkNotNull(externalId, "externalId");
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.externalId = externalId;
    }
    
    public PhysicalNexusCreate(
            CountryCodeEnum countryCode,
            String stateCode,
            LocalDate startDate,
            PhysicalNexusCategory category) {
        this(countryCode, stateCode, startDate,
            Optional.empty(), category, Optional.empty());
    }

    @JsonIgnore
    public CountryCodeEnum countryCode() {
        return countryCode;
    }

    /**
     * The state or province code in
     *                             ISO 3166-2 format (e.g., CA).
     */
    @JsonIgnore
    public String stateCode() {
        return stateCode;
    }

    /**
     * The date when the nexus became
     *                             effective (YYYY-MM-DD).
     */
    @JsonIgnore
    public LocalDate startDate() {
        return startDate;
    }

    /**
     * The date when the
     *                                         nexus ended, if applicable.
     */
    @JsonIgnore
    public Optional<String> endDate() {
        return endDate;
    }

    @JsonIgnore
    public PhysicalNexusCategory category() {
        return category;
    }

    /**
     * Optional
     *                                         external identifier for the nexus.
     */
    @JsonIgnore
    public Optional<String> externalId() {
        return externalId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public PhysicalNexusCreate withCountryCode(CountryCodeEnum countryCode) {
        Utils.checkNotNull(countryCode, "countryCode");
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The state or province code in
     *                             ISO 3166-2 format (e.g., CA).
     */
    public PhysicalNexusCreate withStateCode(String stateCode) {
        Utils.checkNotNull(stateCode, "stateCode");
        this.stateCode = stateCode;
        return this;
    }

    /**
     * The date when the nexus became
     *                             effective (YYYY-MM-DD).
     */
    public PhysicalNexusCreate withStartDate(LocalDate startDate) {
        Utils.checkNotNull(startDate, "startDate");
        this.startDate = startDate;
        return this;
    }

    /**
     * The date when the
     *                                         nexus ended, if applicable.
     */
    public PhysicalNexusCreate withEndDate(String endDate) {
        Utils.checkNotNull(endDate, "endDate");
        this.endDate = Optional.ofNullable(endDate);
        return this;
    }


    /**
     * The date when the
     *                                         nexus ended, if applicable.
     */
    public PhysicalNexusCreate withEndDate(Optional<String> endDate) {
        Utils.checkNotNull(endDate, "endDate");
        this.endDate = endDate;
        return this;
    }

    public PhysicalNexusCreate withCategory(PhysicalNexusCategory category) {
        Utils.checkNotNull(category, "category");
        this.category = category;
        return this;
    }

    /**
     * Optional
     *                                         external identifier for the nexus.
     */
    public PhysicalNexusCreate withExternalId(String externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = Optional.ofNullable(externalId);
        return this;
    }


    /**
     * Optional
     *                                         external identifier for the nexus.
     */
    public PhysicalNexusCreate withExternalId(Optional<String> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = externalId;
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
        PhysicalNexusCreate other = (PhysicalNexusCreate) o;
        return 
            Utils.enhancedDeepEquals(this.countryCode, other.countryCode) &&
            Utils.enhancedDeepEquals(this.stateCode, other.stateCode) &&
            Utils.enhancedDeepEquals(this.startDate, other.startDate) &&
            Utils.enhancedDeepEquals(this.endDate, other.endDate) &&
            Utils.enhancedDeepEquals(this.category, other.category) &&
            Utils.enhancedDeepEquals(this.externalId, other.externalId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            countryCode, stateCode, startDate,
            endDate, category, externalId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PhysicalNexusCreate.class,
                "countryCode", countryCode,
                "stateCode", stateCode,
                "startDate", startDate,
                "endDate", endDate,
                "category", category,
                "externalId", externalId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private CountryCodeEnum countryCode;

        private String stateCode;

        private LocalDate startDate;

        private Optional<String> endDate = Optional.empty();

        private PhysicalNexusCategory category;

        private Optional<String> externalId = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder countryCode(CountryCodeEnum countryCode) {
            Utils.checkNotNull(countryCode, "countryCode");
            this.countryCode = countryCode;
            return this;
        }


        /**
         * The state or province code in
         *                             ISO 3166-2 format (e.g., CA).
         */
        public Builder stateCode(String stateCode) {
            Utils.checkNotNull(stateCode, "stateCode");
            this.stateCode = stateCode;
            return this;
        }


        /**
         * The date when the nexus became
         *                             effective (YYYY-MM-DD).
         */
        public Builder startDate(LocalDate startDate) {
            Utils.checkNotNull(startDate, "startDate");
            this.startDate = startDate;
            return this;
        }


        /**
         * The date when the
         *                                         nexus ended, if applicable.
         */
        public Builder endDate(String endDate) {
            Utils.checkNotNull(endDate, "endDate");
            this.endDate = Optional.ofNullable(endDate);
            return this;
        }

        /**
         * The date when the
         *                                         nexus ended, if applicable.
         */
        public Builder endDate(Optional<String> endDate) {
            Utils.checkNotNull(endDate, "endDate");
            this.endDate = endDate;
            return this;
        }


        public Builder category(PhysicalNexusCategory category) {
            Utils.checkNotNull(category, "category");
            this.category = category;
            return this;
        }


        /**
         * Optional
         *                                         external identifier for the nexus.
         */
        public Builder externalId(String externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = Optional.ofNullable(externalId);
            return this;
        }

        /**
         * Optional
         *                                         external identifier for the nexus.
         */
        public Builder externalId(Optional<String> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = externalId;
            return this;
        }

        public PhysicalNexusCreate build() {

            return new PhysicalNexusCreate(
                countryCode, stateCode, startDate,
                endDate, category, externalId);
        }

    }
}
