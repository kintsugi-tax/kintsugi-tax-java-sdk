/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.ExemptionCreate;
import com.kintsugi.taxplatform.operations.CreateExemptionV1ExemptionsPostOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;

public class CreateExemptionV1ExemptionsPostRequestBuilder {

    private ExemptionCreate request;
    private final SDKConfiguration sdkConfiguration;

    public CreateExemptionV1ExemptionsPostRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public CreateExemptionV1ExemptionsPostRequestBuilder request(ExemptionCreate request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public CreateExemptionV1ExemptionsPostResponse call() throws Exception {
        
        RequestOperation<ExemptionCreate, CreateExemptionV1ExemptionsPostResponse> operation
              = new CreateExemptionV1ExemptionsPostOperation(sdkConfiguration);

        return operation.handleResponse(operation.doRequest(request));
    }
}
