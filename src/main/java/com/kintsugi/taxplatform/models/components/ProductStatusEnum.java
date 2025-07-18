/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum ProductStatusEnum {
    APPROVED("APPROVED"),
    PARTIALLY_APPROVED("PARTIALLY_APPROVED"),
    PENDING("PENDING");

    @JsonValue
    private final String value;

    ProductStatusEnum(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ProductStatusEnum> fromValue(String value) {
        for (ProductStatusEnum o: ProductStatusEnum.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

