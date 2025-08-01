/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * TaxItemReturnReasonEnum
 * 
 * <p>We use this to understand the response from get_tax_items
 */
public enum TaxItemReturnReasonEnum {
    NO_RULE_FOUND("NO_RULE_FOUND"),
    RULE_FOUND_TAXABLE("RULE_FOUND_TAXABLE"),
    RULE_FOUND_NOT_TAXABLE("RULE_FOUND_NOT_TAXABLE"),
    PRODUCT_EXEMPT("PRODUCT_EXEMPT"),
    FROM_IMPORT("FROM_IMPORT");

    @JsonValue
    private final String value;

    TaxItemReturnReasonEnum(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<TaxItemReturnReasonEnum> fromValue(String value) {
        for (TaxItemReturnReasonEnum o: TaxItemReturnReasonEnum.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

