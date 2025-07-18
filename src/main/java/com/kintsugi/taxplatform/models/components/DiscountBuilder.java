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
import org.openapitools.jackson.nullable.JsonNullable;


public class DiscountBuilder {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("external_id")
    private JsonNullable<String> externalId;


    @JsonProperty("applied_to")
    private AppliedTo appliedTo;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("discount_amount")
    private Optional<? extends DiscountAmount> discountAmount;

    @JsonCreator
    public DiscountBuilder(
            @JsonProperty("external_id") JsonNullable<String> externalId,
            @JsonProperty("applied_to") AppliedTo appliedTo,
            @JsonProperty("discount_amount") Optional<? extends DiscountAmount> discountAmount) {
        Utils.checkNotNull(externalId, "externalId");
        Utils.checkNotNull(appliedTo, "appliedTo");
        Utils.checkNotNull(discountAmount, "discountAmount");
        this.externalId = externalId;
        this.appliedTo = appliedTo;
        this.discountAmount = discountAmount;
    }
    
    public DiscountBuilder(
            AppliedTo appliedTo) {
        this(JsonNullable.undefined(), appliedTo, Optional.empty());
    }

    @JsonIgnore
    public JsonNullable<String> externalId() {
        return externalId;
    }

    @JsonIgnore
    public AppliedTo appliedTo() {
        return appliedTo;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<DiscountAmount> discountAmount() {
        return (Optional<DiscountAmount>) discountAmount;
    }

    public static Builder builder() {
        return new Builder();
    }


    public DiscountBuilder withExternalId(String externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = JsonNullable.of(externalId);
        return this;
    }

    public DiscountBuilder withExternalId(JsonNullable<String> externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = externalId;
        return this;
    }

    public DiscountBuilder withAppliedTo(AppliedTo appliedTo) {
        Utils.checkNotNull(appliedTo, "appliedTo");
        this.appliedTo = appliedTo;
        return this;
    }

    public DiscountBuilder withDiscountAmount(DiscountAmount discountAmount) {
        Utils.checkNotNull(discountAmount, "discountAmount");
        this.discountAmount = Optional.ofNullable(discountAmount);
        return this;
    }


    public DiscountBuilder withDiscountAmount(Optional<? extends DiscountAmount> discountAmount) {
        Utils.checkNotNull(discountAmount, "discountAmount");
        this.discountAmount = discountAmount;
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
        DiscountBuilder other = (DiscountBuilder) o;
        return 
            Utils.enhancedDeepEquals(this.externalId, other.externalId) &&
            Utils.enhancedDeepEquals(this.appliedTo, other.appliedTo) &&
            Utils.enhancedDeepEquals(this.discountAmount, other.discountAmount);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            externalId, appliedTo, discountAmount);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DiscountBuilder.class,
                "externalId", externalId,
                "appliedTo", appliedTo,
                "discountAmount", discountAmount);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<String> externalId = JsonNullable.undefined();

        private AppliedTo appliedTo;

        private Optional<? extends DiscountAmount> discountAmount = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder externalId(String externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = JsonNullable.of(externalId);
            return this;
        }

        public Builder externalId(JsonNullable<String> externalId) {
            Utils.checkNotNull(externalId, "externalId");
            this.externalId = externalId;
            return this;
        }


        public Builder appliedTo(AppliedTo appliedTo) {
            Utils.checkNotNull(appliedTo, "appliedTo");
            this.appliedTo = appliedTo;
            return this;
        }


        public Builder discountAmount(DiscountAmount discountAmount) {
            Utils.checkNotNull(discountAmount, "discountAmount");
            this.discountAmount = Optional.ofNullable(discountAmount);
            return this;
        }

        public Builder discountAmount(Optional<? extends DiscountAmount> discountAmount) {
            Utils.checkNotNull(discountAmount, "discountAmount");
            this.discountAmount = discountAmount;
            return this;
        }

        public DiscountBuilder build() {

            return new DiscountBuilder(
                externalId, appliedTo, discountAmount);
        }

    }
}
