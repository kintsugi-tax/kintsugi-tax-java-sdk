/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kintsugi.taxplatform.utils.OneOfDeserializer;
import com.kintsugi.taxplatform.utils.TypedObject;
import com.kintsugi.taxplatform.utils.Utils.JsonShape;
import com.kintsugi.taxplatform.utils.Utils.TypeReferenceWithShape;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * TransactionItemBuilderConvertedSubtotal
 * 
 * <p>Converted subtotal amount.
 */
@JsonDeserialize(using = TransactionItemBuilderConvertedSubtotal._Deserializer.class)
public class TransactionItemBuilderConvertedSubtotal {

    @JsonValue
    private TypedObject value;
    
    private TransactionItemBuilderConvertedSubtotal(TypedObject value) {
        this.value = value;
    }

    public static TransactionItemBuilderConvertedSubtotal of(double value) {
        Utils.checkNotNull(value, "value");
        return new TransactionItemBuilderConvertedSubtotal(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<java.lang.Double>(){}));
    }

    public static TransactionItemBuilderConvertedSubtotal of(String value) {
        Utils.checkNotNull(value, "value");
        return new TransactionItemBuilderConvertedSubtotal(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<String>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code double}</li>
     * <li>{@code java.lang.String}</li>
     * </ul>
     * 
     * <p>Use {@code instanceof} to determine what type is returned. For example:
     * 
     * <pre>
     * if (obj.value() instanceof String) {
     *     String answer = (String) obj.value();
     *     System.out.println("answer=" + answer);
     * }
     * </pre>
     * 
     * @return value of oneOf type
     **/ 
    public java.lang.Object value() {
        return value.value();
    }    
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionItemBuilderConvertedSubtotal other = (TransactionItemBuilderConvertedSubtotal) o;
        return Utils.enhancedDeepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends OneOfDeserializer<TransactionItemBuilderConvertedSubtotal> {

        public _Deserializer() {
            super(TransactionItemBuilderConvertedSubtotal.class, false,
                  TypeReferenceWithShape.of(new TypeReference<String>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<Double>() {}, JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(TransactionItemBuilderConvertedSubtotal.class,
                "value", value);
    }
 
}

