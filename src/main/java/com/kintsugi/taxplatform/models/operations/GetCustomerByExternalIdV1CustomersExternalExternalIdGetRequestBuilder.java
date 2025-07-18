/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.operations.GetCustomerByExternalIdV1CustomersExternalExternalIdGetOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequestBuilder {

    private GetCustomerByExternalIdV1CustomersExternalExternalIdGetSecurity security;
    private String externalId;
    private Optional<String> xOrganizationId = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequestBuilder security(GetCustomerByExternalIdV1CustomersExternalExternalIdGetSecurity security) {
        Utils.checkNotNull(security, "security");
        this.security = security;
        return this;
    }

    public GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequestBuilder externalId(String externalId) {
        Utils.checkNotNull(externalId, "externalId");
        this.externalId = externalId;
        return this;
    }
                
    public GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequestBuilder xOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.of(xOrganizationId);
        return this;
    }

    public GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequestBuilder xOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
        return this;
    }


    private GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequest buildRequest() {

        GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequest request = new GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequest(externalId,
            xOrganizationId);

        return request;
    }

    public GetCustomerByExternalIdV1CustomersExternalExternalIdGetResponse call() throws Exception {
        
        RequestOperation<GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequest, GetCustomerByExternalIdV1CustomersExternalExternalIdGetResponse> operation
              = new GetCustomerByExternalIdV1CustomersExternalExternalIdGetOperation(sdkConfiguration, security);
        GetCustomerByExternalIdV1CustomersExternalExternalIdGetRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
