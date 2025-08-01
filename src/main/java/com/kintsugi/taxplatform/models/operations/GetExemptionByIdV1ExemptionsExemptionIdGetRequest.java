/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kintsugi.taxplatform.utils.SpeakeasyMetadata;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Override;
import java.lang.String;


public class GetExemptionByIdV1ExemptionsExemptionIdGetRequest {
    /**
     * The unique identifier for the exemption being retrieved.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=exemption_id")
    private String exemptionId;

    @JsonCreator
    public GetExemptionByIdV1ExemptionsExemptionIdGetRequest(
            String exemptionId) {
        Utils.checkNotNull(exemptionId, "exemptionId");
        this.exemptionId = exemptionId;
    }

    /**
     * The unique identifier for the exemption being retrieved.
     */
    @JsonIgnore
    public String exemptionId() {
        return exemptionId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier for the exemption being retrieved.
     */
    public GetExemptionByIdV1ExemptionsExemptionIdGetRequest withExemptionId(String exemptionId) {
        Utils.checkNotNull(exemptionId, "exemptionId");
        this.exemptionId = exemptionId;
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
        GetExemptionByIdV1ExemptionsExemptionIdGetRequest other = (GetExemptionByIdV1ExemptionsExemptionIdGetRequest) o;
        return 
            Utils.enhancedDeepEquals(this.exemptionId, other.exemptionId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            exemptionId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetExemptionByIdV1ExemptionsExemptionIdGetRequest.class,
                "exemptionId", exemptionId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String exemptionId;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The unique identifier for the exemption being retrieved.
         */
        public Builder exemptionId(String exemptionId) {
            Utils.checkNotNull(exemptionId, "exemptionId");
            this.exemptionId = exemptionId;
            return this;
        }

        public GetExemptionByIdV1ExemptionsExemptionIdGetRequest build() {

            return new GetExemptionByIdV1ExemptionsExemptionIdGetRequest(
                exemptionId);
        }

    }
}
