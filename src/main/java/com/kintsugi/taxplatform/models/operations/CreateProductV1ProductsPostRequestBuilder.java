/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.ProductCreateManual;
import com.kintsugi.taxplatform.operations.CreateProductV1ProductsPostOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;

public class CreateProductV1ProductsPostRequestBuilder {

    private ProductCreateManual request;
    private final SDKConfiguration sdkConfiguration;

    public CreateProductV1ProductsPostRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public CreateProductV1ProductsPostRequestBuilder request(ProductCreateManual request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public CreateProductV1ProductsPostResponse call() throws Exception {
        
        RequestOperation<ProductCreateManual, CreateProductV1ProductsPostResponse> operation
              = new CreateProductV1ProductsPostOperation(sdkConfiguration);

        return operation.handleResponse(operation.doRequest(request));
    }
}
