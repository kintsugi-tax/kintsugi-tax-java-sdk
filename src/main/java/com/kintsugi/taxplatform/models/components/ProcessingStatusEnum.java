/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * ProcessingStatusEnum
 * 
 * <p>Our transaction state, used to determine when/if a transaction needs additional
 * processing.
 */
public enum ProcessingStatusEnum {
    NEW("NEW"),
    UPDATED("UPDATED"),
    QUEUED("QUEUED"),
    ADDRESS_DONE("ADDRESS_DONE"),
    EXEMPT_DONE("EXEMPT_DONE"),
    NEXUS_DONE("NEXUS_DONE"),
    PROCESSED("PROCESSED"),
    FILING_STARTED("FILING_STARTED"),
    FILING_DONE("FILING_DONE"),
    LOCKED("LOCKED"),
    PENDING("PENDING"),
    ARCHIVED("ARCHIVED"),
    NEEDS_REFETCH("NEEDS_REFETCH");

    @JsonValue
    private final String value;

    ProcessingStatusEnum(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ProcessingStatusEnum> fromValue(String value) {
        for (ProcessingStatusEnum o: ProcessingStatusEnum.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

