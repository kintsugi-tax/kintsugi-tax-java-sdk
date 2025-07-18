/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.TransactionEstimatePublicRequest;
import com.kintsugi.taxplatform.operations.EstimateTaxV1TaxEstimatePostOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class EstimateTaxV1TaxEstimatePostRequestBuilder {

    private EstimateTaxV1TaxEstimatePostSecurity security;
    private Optional<Boolean> simulateNexusMet = Optional.empty();
    private Optional<String> xOrganizationId = Optional.empty();
    private TransactionEstimatePublicRequest transactionEstimatePublicRequest;
    private final SDKConfiguration sdkConfiguration;

    public EstimateTaxV1TaxEstimatePostRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public EstimateTaxV1TaxEstimatePostRequestBuilder security(EstimateTaxV1TaxEstimatePostSecurity security) {
        Utils.checkNotNull(security, "security");
        this.security = security;
        return this;
    }
                
    public EstimateTaxV1TaxEstimatePostRequestBuilder simulateNexusMet(boolean simulateNexusMet) {
        Utils.checkNotNull(simulateNexusMet, "simulateNexusMet");
        this.simulateNexusMet = Optional.of(simulateNexusMet);
        return this;
    }

    public EstimateTaxV1TaxEstimatePostRequestBuilder simulateNexusMet(Optional<Boolean> simulateNexusMet) {
        Utils.checkNotNull(simulateNexusMet, "simulateNexusMet");
        this.simulateNexusMet = simulateNexusMet;
        return this;
    }
                
    public EstimateTaxV1TaxEstimatePostRequestBuilder xOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.of(xOrganizationId);
        return this;
    }

    public EstimateTaxV1TaxEstimatePostRequestBuilder xOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
        return this;
    }

    public EstimateTaxV1TaxEstimatePostRequestBuilder transactionEstimatePublicRequest(TransactionEstimatePublicRequest transactionEstimatePublicRequest) {
        Utils.checkNotNull(transactionEstimatePublicRequest, "transactionEstimatePublicRequest");
        this.transactionEstimatePublicRequest = transactionEstimatePublicRequest;
        return this;
    }


    private EstimateTaxV1TaxEstimatePostRequest buildRequest() {

        EstimateTaxV1TaxEstimatePostRequest request = new EstimateTaxV1TaxEstimatePostRequest(simulateNexusMet,
            xOrganizationId,
            transactionEstimatePublicRequest);

        return request;
    }

    public EstimateTaxV1TaxEstimatePostResponse call() throws Exception {
        
        RequestOperation<EstimateTaxV1TaxEstimatePostRequest, EstimateTaxV1TaxEstimatePostResponse> operation
              = new EstimateTaxV1TaxEstimatePostOperation(sdkConfiguration, security);
        EstimateTaxV1TaxEstimatePostRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
