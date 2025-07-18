/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.TransactionUpdate;
import com.kintsugi.taxplatform.operations.UpdateTransactionV1TransactionsTransactionIdPutOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder {

    private UpdateTransactionV1TransactionsTransactionIdPutSecurity security;
    private String transactionId;
    private Optional<String> xOrganizationId = Optional.empty();
    private TransactionUpdate transactionUpdate;
    private final SDKConfiguration sdkConfiguration;

    public UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder security(UpdateTransactionV1TransactionsTransactionIdPutSecurity security) {
        Utils.checkNotNull(security, "security");
        this.security = security;
        return this;
    }

    public UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder transactionId(String transactionId) {
        Utils.checkNotNull(transactionId, "transactionId");
        this.transactionId = transactionId;
        return this;
    }
                
    public UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder xOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.of(xOrganizationId);
        return this;
    }

    public UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder xOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
        return this;
    }

    public UpdateTransactionV1TransactionsTransactionIdPutRequestBuilder transactionUpdate(TransactionUpdate transactionUpdate) {
        Utils.checkNotNull(transactionUpdate, "transactionUpdate");
        this.transactionUpdate = transactionUpdate;
        return this;
    }


    private UpdateTransactionV1TransactionsTransactionIdPutRequest buildRequest() {

        UpdateTransactionV1TransactionsTransactionIdPutRequest request = new UpdateTransactionV1TransactionsTransactionIdPutRequest(transactionId,
            xOrganizationId,
            transactionUpdate);

        return request;
    }

    public UpdateTransactionV1TransactionsTransactionIdPutResponse call() throws Exception {
        
        RequestOperation<UpdateTransactionV1TransactionsTransactionIdPutRequest, UpdateTransactionV1TransactionsTransactionIdPutResponse> operation
              = new UpdateTransactionV1TransactionsTransactionIdPutOperation(sdkConfiguration, security);
        UpdateTransactionV1TransactionsTransactionIdPutRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
