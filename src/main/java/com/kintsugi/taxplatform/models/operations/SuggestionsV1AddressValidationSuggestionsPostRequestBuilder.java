/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.ValidationAddress;
import com.kintsugi.taxplatform.operations.SuggestionsV1AddressValidationSuggestionsPostOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;

public class SuggestionsV1AddressValidationSuggestionsPostRequestBuilder {

    private ValidationAddress request;
    private final SDKConfiguration sdkConfiguration;

    public SuggestionsV1AddressValidationSuggestionsPostRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public SuggestionsV1AddressValidationSuggestionsPostRequestBuilder request(ValidationAddress request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public SuggestionsV1AddressValidationSuggestionsPostResponse call() throws Exception {
        
        RequestOperation<ValidationAddress, SuggestionsV1AddressValidationSuggestionsPostResponse> operation
              = new SuggestionsV1AddressValidationSuggestionsPostOperation(sdkConfiguration);

        return operation.handleResponse(operation.doRequest(request));
    }
}
