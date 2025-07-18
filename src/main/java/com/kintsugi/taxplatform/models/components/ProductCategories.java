/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.List;


public class ProductCategories {
    /**
     * Name of the product category
     *             (e.g., PHYSICAL, SERVICE, DIGITAL, MISCELLANEOUS)
     */
    @JsonProperty("name")
    private String name;

    /**
     * List of subcategories associated with the product category
     */
    @JsonProperty("subcategories")
    private List<ProductSubCategory> subcategories;

    @JsonCreator
    public ProductCategories(
            @JsonProperty("name") String name,
            @JsonProperty("subcategories") List<ProductSubCategory> subcategories) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(subcategories, "subcategories");
        this.name = name;
        this.subcategories = subcategories;
    }

    /**
     * Name of the product category
     *             (e.g., PHYSICAL, SERVICE, DIGITAL, MISCELLANEOUS)
     */
    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * List of subcategories associated with the product category
     */
    @JsonIgnore
    public List<ProductSubCategory> subcategories() {
        return subcategories;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Name of the product category
     *             (e.g., PHYSICAL, SERVICE, DIGITAL, MISCELLANEOUS)
     */
    public ProductCategories withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * List of subcategories associated with the product category
     */
    public ProductCategories withSubcategories(List<ProductSubCategory> subcategories) {
        Utils.checkNotNull(subcategories, "subcategories");
        this.subcategories = subcategories;
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
        ProductCategories other = (ProductCategories) o;
        return 
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.subcategories, other.subcategories);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            name, subcategories);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ProductCategories.class,
                "name", name,
                "subcategories", subcategories);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String name;

        private List<ProductSubCategory> subcategories;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Name of the product category
         *             (e.g., PHYSICAL, SERVICE, DIGITAL, MISCELLANEOUS)
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }


        /**
         * List of subcategories associated with the product category
         */
        public Builder subcategories(List<ProductSubCategory> subcategories) {
            Utils.checkNotNull(subcategories, "subcategories");
            this.subcategories = subcategories;
            return this;
        }

        public ProductCategories build() {

            return new ProductCategories(
                name, subcategories);
        }

    }
}
