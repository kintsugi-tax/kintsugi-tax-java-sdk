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
import java.lang.SuppressWarnings;
import java.util.Optional;


public class CustomerRead {
    /**
     * Customer's phone number
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("phone")
    private Optional<String> phone;

    /**
     * Primary street address.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("street_1")
    private Optional<String> street1;

    /**
     * Additional street address details, such as an apartment or suite number.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("street_2")
    private Optional<String> street2;

    /**
     * City where the customer resides.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("city")
    private Optional<String> city;

    /**
     * County or district of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("county")
    private Optional<String> county;

    /**
     * State or province of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("state")
    private Optional<String> state;

    /**
     * ZIP or Postal code of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("postal_code")
    private Optional<String> postalCode;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("country")
    private Optional<? extends CountryCodeEnum> country;

    /**
     * Complete address string of the customer, which can be used as an alternative to individual fields.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("full_address")
    private Optional<String> fullAddress;

    /**
     * Name of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private Optional<String> name;

    /**
     * External identifier associated with the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("external_id")
    private Optional<String> externalId;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<? extends StatusEnum> status;

    /**
     * Customer's email address
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("email")
    private Optional<String> email;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("source")
    private Optional<? extends SourceEnum> source;

    /**
     * Identifier for the connection source, if applicable.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("connection_id")
    private Optional<String> connectionId;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("address_status")
    private Optional<? extends AddressStatus> addressStatus;

    /**
     * Registration number of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("registration_number")
    private Optional<String> registrationNumber;

    /**
     * Unique identifier for the customer required.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Unique identifier for the organization associated with the customer. Required.
     */
    @JsonProperty("organization_id")
    private String organizationId;

    @JsonCreator
    public CustomerRead(
            @JsonProperty("phone") Optional<String> phone,
            @JsonProperty("street_1") Optional<String> street1,
            @JsonProperty("street_2") Optional<String> street2,
            @JsonProperty("city") Optional<String> city,
            @JsonProperty("county") Optional<String> county,
            @JsonProperty("state") Optional<String> state,
            @JsonProperty("postal_code") Optional<String> postalCode,
            @JsonProperty("country") Optional<? extends CountryCodeEnum> country,
            @JsonProperty("full_address") Optional<String> fullAddress,
            @JsonProperty("name") Optional<String> name,
            @JsonProperty("external_id") Optional<String> externalId,
            @JsonProperty("status") Optional<? extends StatusEnum> status,
            @JsonProperty("email") Optional<String> email,
            @JsonProperty("source") Optional<? extends SourceEnum> source,
            @JsonProperty("connection_id") Optional<String> connectionId,
            @JsonProperty("address_status") Optional<? extends AddressStatus> addressStatus,
            @JsonProperty("registration_number") Optional<String> registrationNumber,
            @JsonProperty("id") String id,
            @JsonProperty("organization_id") String organizationId) {
        Utils.checkNotNull(phone, "phone");
        Utils.checkNotNull(street1, "street1");
        Utils.checkNotNull(street2, "street2");
        Utils.checkNotNull(city, "city");
        Utils.checkNotNull(county, "county");
        Utils.checkNotNull(state, "state");
        Utils.checkNotNull(postalCode, "postalCode");
        Utils.checkNotNull(country, "country");
        Utils.checkNotNull(fullAddress, "fullAddress");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(externalId, "externalId");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(email, "email");
        Utils.checkNotNull(source, "source");
        Utils.checkNotNull(connectionId, "connectionId");
        Utils.checkNotNull(addressStatus, "addressStatus");
        Utils.checkNotNull(registrationNumber, "registrationNumber");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(organizationId, "organizationId");
        this.phone = phone;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.county = county;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.fullAddress = fullAddress;
        this.name = name;
        this.externalId = externalId;
        this.status = status;
        this.email = email;
        this.source = source;
        this.connectionId = connectionId;
        this.addressStatus = addressStatus;
        this.registrationNumber = registrationNumber;
        this.id = id;
        this.organizationId = organizationId;
    }
    
    public CustomerRead(
            String id,
            String organizationId) {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), id,
            organizationId);
    }

    /**
     * Customer's phone number
     */
    @JsonIgnore
    public Optional<String> phone() {
        return phone;
    }

    /**
     * Primary street address.
     */
    @JsonIgnore
    public Optional<String> street1() {
        return street1;
    }

    /**
     * Additional street address details, such as an apartment or suite number.
     */
    @JsonIgnore
    public Optional<String> street2() {
        return street2;
    }

    /**
     * City where the customer resides.
     */
    @JsonIgnore
    public Optional<String> city() {
        return city;
    }

    /**
     * County or district of the customer.
     */
    @JsonIgnore
    public Optional<String> county() {
        return county;
    }

    /**
     * State or province of the customer.
     */
    @JsonIgnore
    public Optional<String> state() {
        return state;
    }

    /**
     * ZIP or Postal code of the customer.
     */
    @JsonIgnore
    public Optional<String> postalCode() {
        return postalCode;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CountryCodeEnum> country() {
        return (Optional<CountryCodeEnum>) country;
    }

    /**
     * Complete address string of the customer, which can be used as an alternative to individual fields.
     */
    @JsonIgnore
    public Optional<String> fullAddress() {
        return fullAddress;
    }

    /**
     * Name of the customer.
     */
    @JsonIgnore
    public Optional<String> name() {
        return name;
    }

    /**
     * External identifier associated with the customer.
     */
    @JsonIgnore
    public Optional<String> externalId() {
        return externalId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<StatusEnum> status() {
        return (Optional<StatusEnum>) status;
    }

    /**
     * Customer's email address
     */
    @JsonIgnore
    public Optional<String> email() {
        return email;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SourceEnum> source() {
        return (Optional<SourceEnum>) source;
    }

    /**
     * Identifier for the connection source, if applicable.
     */
    @JsonIgnore
    public Optional<String> connectionId() {
        return connectionId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<AddressStatus> addressStatus() {
        return (Optional<AddressStatus>) addressStatus;
    }

    /**
     * Registration number of the customer.
     */
    @JsonIgnore
    public Optional<String> registrationNumber() {
        return registrationNumber;
    }

    /**
     * Unique identifier for the customer required.
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    /**
     * Unique identifier for the organization associated with the customer. Required.
     */
    @JsonIgnore
    public String organizationId() {
        return organizationId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Customer's phone number
     */
    public CustomerRead withPhone(String phone) {
        Utils.checkNotNull(phone, "phone");
        this.phone = Optional.ofNullable(phone);
        return this;
    }


    /**
     * Customer's phone number
     */
    public CustomerRead withPhone(Optional<String> phone) {
        Utils.checkNotNull(phone, "phone");
        this.phone = phone;
        return this;
    }

    /**
     * Primary street address.
     */
    public CustomerRead withStreet1(String street1) {
        Utils.checkNotNull(street1, "street1");
        this.street1 = Optional.ofNullable(street1);
        return this;
    }


    /**
     * Primary street address.
     */
    public CustomerRead withStreet1(Optional<String> street1) {
        Utils.checkNotNull(street1, "street1");
        this.street1 = street1;
        return this;
    }

    /**
     * Additional street address details, such as an apartment or suite number.
     */
    public CustomerRead withStreet2(String street2) {
        Utils.checkNotNull(street2, "street2");
        this.street2 = Optional.ofNullable(street2);
        return this;
    }


    /**
     * Additional street address details, such as an apartment or suite number.
     */
    public CustomerRead withStreet2(Optional<String> street2) {
        Utils.checkNotNull(street2, "street2");
        this.street2 = street2;
        return this;
    }

    /**
     * City where the customer resides.
     */
    public CustomerRead withCity(String city) {
        Utils.checkNotNull(city, "city");
        this.city = Optional.ofNullable(city);
        return this;
    }


    /**
     * City where the customer resides.
     */
    public CustomerRead withCity(Optional<String> city) {
        Utils.checkNotNull(city, "city");
        this.city = city;
        return this;
    }

    /**
     * County or district of the customer.
     */
    public CustomerRead withCounty(String county) {
        Utils.checkNotNull(county, "county");
        this.county = Optional.ofNullable(county);
        return this;
    }


    /**
     * County or district of the customer.
     */
    public CustomerRead withCounty(Optional<String> county) {
        Utils.checkNotNull(county, "county");
        this.county = county;
        return this;
    }

    /**
     * State or province of the customer.
     */
    public CustomerRead withState(String state) {
        Utils.checkNotNull(state, "state");
        this.state = Optional.ofNullable(state);
        return this;
    }


    /**
     * State or province of the customer.
     */
    public CustomerRead withState(Optional<String> state) {
        Utils.checkNotNull(state, "state");
        this.state = state;
        return this;
    }

    /**
     * ZIP or Postal code of the customer.
     */
    public CustomerRead withPostalCode(String postalCode) {
        Utils.checkNotNull(postalCode, "postalCode");
        this.postalCode = Optional.ofNullable(postalCode);
        return this;
    }


    /**
     * ZIP or Postal code of the customer.
     */
    public CustomerRead withPostalCode(Optional<String> postalCode) {
        Utils.checkNotNull(postalCode, "postalCode");
        this.postalCode = postalCode;
        return this;
    }

    public CustomerRead withCountry(CountryCodeEnum country) {
        Utils.checkNotNull(country, "country");
        this.country = Optional.ofNullable(country);
        return this;
    }


    public CustomerRead withCountry(Optional<? extends CountryCodeEnum> country) {
        Utils.checkNotNull(country, "country");
        this.country = country;
        return this;
    }

    /**
     * Complete address string of the customer, which can be used as an alternative to individual fields.
     */
    public CustomerRead withFullAddress(String fullAddress) {
        Utils.checkNotNull(fullAddress, "fullAddress");
        this.fullAddress = Optional.ofNullable(fullAddress);
        return this;
    }


    /**
     * Complete address string of the customer, which can be used as an alternative to individual fields.
     */
    public CustomerRead withFullAddress(Optional<String> fullAddress) {
        Utils.checkNotNull(fullAddress, "fullAddress");
        this.fullAddress = fullAddress;
        return this;
    }

    /**
     * Name of the customer.
     */
    public CustomerRead withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = Optional.ofNullable(name);
        return this;
    }


    /**
     * Name of the customer.
     */
    public CustomerRead withName(Optional<String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * External identifier associated with the customer.
     */
    public CustomerRead withExternalId(String externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = Optional.ofNullable(externalId);
        return this;
    }


    /**
     * External identifier associated with the customer.
     */
    public CustomerRead withExternalId(Optional<String> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = externalId;
        return this;
    }

    public CustomerRead withStatus(StatusEnum status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }


    public CustomerRead withStatus(Optional<? extends StatusEnum> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * Customer's email address
     */
    public CustomerRead withEmail(String email) {
        Utils.checkNotNull(email, "email");
        this.email = Optional.ofNullable(email);
        return this;
    }


    /**
     * Customer's email address
     */
    public CustomerRead withEmail(Optional<String> email) {
        Utils.checkNotNull(email, "email");
        this.email = email;
        return this;
    }

    public CustomerRead withSource(SourceEnum source) {
        Utils.checkNotNull(source, "source");
        this.source = Optional.ofNullable(source);
        return this;
    }


    public CustomerRead withSource(Optional<? extends SourceEnum> source) {
        Utils.checkNotNull(source, "source");
        this.source = source;
        return this;
    }

    /**
     * Identifier for the connection source, if applicable.
     */
    public CustomerRead withConnectionId(String connectionId) {
        Utils.checkNotNull(connectionId, "connectionId");
        this.connectionId = Optional.ofNullable(connectionId);
        return this;
    }


    /**
     * Identifier for the connection source, if applicable.
     */
    public CustomerRead withConnectionId(Optional<String> connectionId) {
        Utils.checkNotNull(connectionId, "connectionId");
        this.connectionId = connectionId;
        return this;
    }

    public CustomerRead withAddressStatus(AddressStatus addressStatus) {
        Utils.checkNotNull(addressStatus, "addressStatus");
        this.addressStatus = Optional.ofNullable(addressStatus);
        return this;
    }


    public CustomerRead withAddressStatus(Optional<? extends AddressStatus> addressStatus) {
        Utils.checkNotNull(addressStatus, "addressStatus");
        this.addressStatus = addressStatus;
        return this;
    }

    /**
     * Registration number of the customer.
     */
    public CustomerRead withRegistrationNumber(String registrationNumber) {
        Utils.checkNotNull(registrationNumber, "registrationNumber");
        this.registrationNumber = Optional.ofNullable(registrationNumber);
        return this;
    }


    /**
     * Registration number of the customer.
     */
    public CustomerRead withRegistrationNumber(Optional<String> registrationNumber) {
        Utils.checkNotNull(registrationNumber, "registrationNumber");
        this.registrationNumber = registrationNumber;
        return this;
    }

    /**
     * Unique identifier for the customer required.
     */
    public CustomerRead withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * Unique identifier for the organization associated with the customer. Required.
     */
    public CustomerRead withOrganizationId(String organizationId) {
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
        CustomerRead other = (CustomerRead) o;
        return 
            Utils.enhancedDeepEquals(this.phone, other.phone) &&
            Utils.enhancedDeepEquals(this.street1, other.street1) &&
            Utils.enhancedDeepEquals(this.street2, other.street2) &&
            Utils.enhancedDeepEquals(this.city, other.city) &&
            Utils.enhancedDeepEquals(this.county, other.county) &&
            Utils.enhancedDeepEquals(this.state, other.state) &&
            Utils.enhancedDeepEquals(this.postalCode, other.postalCode) &&
            Utils.enhancedDeepEquals(this.country, other.country) &&
            Utils.enhancedDeepEquals(this.fullAddress, other.fullAddress) &&
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.externalId, other.externalId) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.email, other.email) &&
            Utils.enhancedDeepEquals(this.source, other.source) &&
            Utils.enhancedDeepEquals(this.connectionId, other.connectionId) &&
            Utils.enhancedDeepEquals(this.addressStatus, other.addressStatus) &&
            Utils.enhancedDeepEquals(this.registrationNumber, other.registrationNumber) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.organizationId, other.organizationId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            phone, street1, street2,
            city, county, state,
            postalCode, country, fullAddress,
            name, externalId, status,
            email, source, connectionId,
            addressStatus, registrationNumber, id,
            organizationId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CustomerRead.class,
                "phone", phone,
                "street1", street1,
                "street2", street2,
                "city", city,
                "county", county,
                "state", state,
                "postalCode", postalCode,
                "country", country,
                "fullAddress", fullAddress,
                "name", name,
                "externalId", externalId,
                "status", status,
                "email", email,
                "source", source,
                "connectionId", connectionId,
                "addressStatus", addressStatus,
                "registrationNumber", registrationNumber,
                "id", id,
                "organizationId", organizationId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> phone = Optional.empty();

        private Optional<String> street1 = Optional.empty();

        private Optional<String> street2 = Optional.empty();

        private Optional<String> city = Optional.empty();

        private Optional<String> county = Optional.empty();

        private Optional<String> state = Optional.empty();

        private Optional<String> postalCode = Optional.empty();

        private Optional<? extends CountryCodeEnum> country = Optional.empty();

        private Optional<String> fullAddress = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> externalId = Optional.empty();

        private Optional<? extends StatusEnum> status = Optional.empty();

        private Optional<String> email = Optional.empty();

        private Optional<? extends SourceEnum> source = Optional.empty();

        private Optional<String> connectionId = Optional.empty();

        private Optional<? extends AddressStatus> addressStatus = Optional.empty();

        private Optional<String> registrationNumber = Optional.empty();

        private String id;

        private String organizationId;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Customer's phone number
         */
        public Builder phone(String phone) {
            Utils.checkNotNull(phone, "phone");
            this.phone = Optional.ofNullable(phone);
            return this;
        }

        /**
         * Customer's phone number
         */
        public Builder phone(Optional<String> phone) {
            Utils.checkNotNull(phone, "phone");
            this.phone = phone;
            return this;
        }


        /**
         * Primary street address.
         */
        public Builder street1(String street1) {
            Utils.checkNotNull(street1, "street1");
            this.street1 = Optional.ofNullable(street1);
            return this;
        }

        /**
         * Primary street address.
         */
        public Builder street1(Optional<String> street1) {
            Utils.checkNotNull(street1, "street1");
            this.street1 = street1;
            return this;
        }


        /**
         * Additional street address details, such as an apartment or suite number.
         */
        public Builder street2(String street2) {
            Utils.checkNotNull(street2, "street2");
            this.street2 = Optional.ofNullable(street2);
            return this;
        }

        /**
         * Additional street address details, such as an apartment or suite number.
         */
        public Builder street2(Optional<String> street2) {
            Utils.checkNotNull(street2, "street2");
            this.street2 = street2;
            return this;
        }


        /**
         * City where the customer resides.
         */
        public Builder city(String city) {
            Utils.checkNotNull(city, "city");
            this.city = Optional.ofNullable(city);
            return this;
        }

        /**
         * City where the customer resides.
         */
        public Builder city(Optional<String> city) {
            Utils.checkNotNull(city, "city");
            this.city = city;
            return this;
        }


        /**
         * County or district of the customer.
         */
        public Builder county(String county) {
            Utils.checkNotNull(county, "county");
            this.county = Optional.ofNullable(county);
            return this;
        }

        /**
         * County or district of the customer.
         */
        public Builder county(Optional<String> county) {
            Utils.checkNotNull(county, "county");
            this.county = county;
            return this;
        }


        /**
         * State or province of the customer.
         */
        public Builder state(String state) {
            Utils.checkNotNull(state, "state");
            this.state = Optional.ofNullable(state);
            return this;
        }

        /**
         * State or province of the customer.
         */
        public Builder state(Optional<String> state) {
            Utils.checkNotNull(state, "state");
            this.state = state;
            return this;
        }


        /**
         * ZIP or Postal code of the customer.
         */
        public Builder postalCode(String postalCode) {
            Utils.checkNotNull(postalCode, "postalCode");
            this.postalCode = Optional.ofNullable(postalCode);
            return this;
        }

        /**
         * ZIP or Postal code of the customer.
         */
        public Builder postalCode(Optional<String> postalCode) {
            Utils.checkNotNull(postalCode, "postalCode");
            this.postalCode = postalCode;
            return this;
        }


        public Builder country(CountryCodeEnum country) {
            Utils.checkNotNull(country, "country");
            this.country = Optional.ofNullable(country);
            return this;
        }

        public Builder country(Optional<? extends CountryCodeEnum> country) {
            Utils.checkNotNull(country, "country");
            this.country = country;
            return this;
        }


        /**
         * Complete address string of the customer, which can be used as an alternative to individual fields.
         */
        public Builder fullAddress(String fullAddress) {
            Utils.checkNotNull(fullAddress, "fullAddress");
            this.fullAddress = Optional.ofNullable(fullAddress);
            return this;
        }

        /**
         * Complete address string of the customer, which can be used as an alternative to individual fields.
         */
        public Builder fullAddress(Optional<String> fullAddress) {
            Utils.checkNotNull(fullAddress, "fullAddress");
            this.fullAddress = fullAddress;
            return this;
        }


        /**
         * Name of the customer.
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = Optional.ofNullable(name);
            return this;
        }

        /**
         * Name of the customer.
         */
        public Builder name(Optional<String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }


        /**
         * External identifier associated with the customer.
         */
        public Builder externalId(String externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = Optional.ofNullable(externalId);
            return this;
        }

        /**
         * External identifier associated with the customer.
         */
        public Builder externalId(Optional<String> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = externalId;
            return this;
        }


        public Builder status(StatusEnum status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        public Builder status(Optional<? extends StatusEnum> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        /**
         * Customer's email address
         */
        public Builder email(String email) {
            Utils.checkNotNull(email, "email");
            this.email = Optional.ofNullable(email);
            return this;
        }

        /**
         * Customer's email address
         */
        public Builder email(Optional<String> email) {
            Utils.checkNotNull(email, "email");
            this.email = email;
            return this;
        }


        public Builder source(SourceEnum source) {
            Utils.checkNotNull(source, "source");
            this.source = Optional.ofNullable(source);
            return this;
        }

        public Builder source(Optional<? extends SourceEnum> source) {
            Utils.checkNotNull(source, "source");
            this.source = source;
            return this;
        }


        /**
         * Identifier for the connection source, if applicable.
         */
        public Builder connectionId(String connectionId) {
            Utils.checkNotNull(connectionId, "connectionId");
            this.connectionId = Optional.ofNullable(connectionId);
            return this;
        }

        /**
         * Identifier for the connection source, if applicable.
         */
        public Builder connectionId(Optional<String> connectionId) {
            Utils.checkNotNull(connectionId, "connectionId");
            this.connectionId = connectionId;
            return this;
        }


        public Builder addressStatus(AddressStatus addressStatus) {
            Utils.checkNotNull(addressStatus, "addressStatus");
            this.addressStatus = Optional.ofNullable(addressStatus);
            return this;
        }

        public Builder addressStatus(Optional<? extends AddressStatus> addressStatus) {
            Utils.checkNotNull(addressStatus, "addressStatus");
            this.addressStatus = addressStatus;
            return this;
        }


        /**
         * Registration number of the customer.
         */
        public Builder registrationNumber(String registrationNumber) {
            Utils.checkNotNull(registrationNumber, "registrationNumber");
            this.registrationNumber = Optional.ofNullable(registrationNumber);
            return this;
        }

        /**
         * Registration number of the customer.
         */
        public Builder registrationNumber(Optional<String> registrationNumber) {
            Utils.checkNotNull(registrationNumber, "registrationNumber");
            this.registrationNumber = registrationNumber;
            return this;
        }


        /**
         * Unique identifier for the customer required.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * Unique identifier for the organization associated with the customer. Required.
         */
        public Builder organizationId(String organizationId) {
            Utils.checkNotNull(organizationId, "organizationId");
            this.organizationId = organizationId;
            return this;
        }

        public CustomerRead build() {

            return new CustomerRead(
                phone, street1, street2,
                city, county, state,
                postalCode, country, fullAddress,
                name, externalId, status,
                email, source, connectionId,
                addressStatus, registrationNumber, id,
                organizationId);
        }

    }
}
