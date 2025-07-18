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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;

@JsonDeserialize(using = TransactionUpdateAddresses._Deserializer.class)
public class TransactionUpdateAddresses {

    @JsonValue
    private TypedObject value;
    
    private TransactionUpdateAddresses(TypedObject value) {
        this.value = value;
    }

    public static TransactionUpdateAddresses ofTransactionAddressBuilder(List<TransactionAddressBuilder> value) {
        Utils.checkNotNull(value, "value");
        return new TransactionUpdateAddresses(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<List<TransactionAddressBuilder>>(){}));
    }

    public static TransactionUpdateAddresses ofAddressInput(List<AddressInput> value) {
        Utils.checkNotNull(value, "value");
        return new TransactionUpdateAddresses(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<List<AddressInput>>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code java.util.List<com.kintsugi.taxplatform.models.components.TransactionAddressBuilder>}</li>
     * <li>{@code java.util.List<com.kintsugi.taxplatform.models.components.AddressInput>}</li>
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
        TransactionUpdateAddresses other = (TransactionUpdateAddresses) o;
        return Utils.enhancedDeepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends OneOfDeserializer<TransactionUpdateAddresses> {

        public _Deserializer() {
            super(TransactionUpdateAddresses.class, false,
                  TypeReferenceWithShape.of(new TypeReference<List<AddressInput>>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<List<TransactionAddressBuilder>>() {}, JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(TransactionUpdateAddresses.class,
                "value", value);
    }
 
}

