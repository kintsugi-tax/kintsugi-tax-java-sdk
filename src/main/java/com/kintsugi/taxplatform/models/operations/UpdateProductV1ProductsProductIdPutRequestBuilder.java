/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.operations.UpdateProductV1ProductsProductIdPutOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class UpdateProductV1ProductsProductIdPutRequestBuilder {

    private UpdateProductV1ProductsProductIdPutSecurity security;
    private String productId;
    private Optional<String> xOrganizationId = Optional.empty();
    private Product requestBody;
    private final SDKConfiguration sdkConfiguration;

    public UpdateProductV1ProductsProductIdPutRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public UpdateProductV1ProductsProductIdPutRequestBuilder security(UpdateProductV1ProductsProductIdPutSecurity security) {
        Utils.checkNotNull(security, "security");
        this.security = security;
        return this;
    }

    public UpdateProductV1ProductsProductIdPutRequestBuilder productId(String productId) {
        Utils.checkNotNull(productId, "productId");
        this.productId = productId;
        return this;
    }
                
    public UpdateProductV1ProductsProductIdPutRequestBuilder xOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.of(xOrganizationId);
        return this;
    }

    public UpdateProductV1ProductsProductIdPutRequestBuilder xOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
        return this;
    }

    public UpdateProductV1ProductsProductIdPutRequestBuilder requestBody(Product requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }


    private UpdateProductV1ProductsProductIdPutRequest buildRequest() {

        UpdateProductV1ProductsProductIdPutRequest request = new UpdateProductV1ProductsProductIdPutRequest(productId,
            xOrganizationId,
            requestBody);

        return request;
    }

    public UpdateProductV1ProductsProductIdPutResponse call() throws Exception {
        
        RequestOperation<UpdateProductV1ProductsProductIdPutRequest, UpdateProductV1ProductsProductIdPutResponse> operation
              = new UpdateProductV1ProductsProductIdPutOperation(sdkConfiguration, security);
        UpdateProductV1ProductsProductIdPutRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
