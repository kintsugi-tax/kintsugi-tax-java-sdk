/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum ChangeRegimeStatusEnum {
    REQUESTED("REQUESTED"),
    APPROVED("APPROVED"),
    DONE("DONE"),
    ACKNOWLEDGED("ACKNOWLEDGED");

    @JsonValue
    private final String value;

    ChangeRegimeStatusEnum(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ChangeRegimeStatusEnum> fromValue(String value) {
        for (ChangeRegimeStatusEnum o: ChangeRegimeStatusEnum.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

