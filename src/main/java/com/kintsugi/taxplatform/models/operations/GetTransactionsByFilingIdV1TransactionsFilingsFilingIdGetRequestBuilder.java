/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.operations.GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;
import java.lang.String;

public class GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequestBuilder {

    private String filingId;
    private final SDKConfiguration sdkConfiguration;

    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequestBuilder filingId(String filingId) {
        Utils.checkNotNull(filingId, "filingId");
        this.filingId = filingId;
        return this;
    }


    private GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest buildRequest() {

        GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest request = new GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest(filingId);

        return request;
    }

    public GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse call() throws Exception {
        
        RequestOperation<GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest, GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse> operation
              = new GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetOperation(sdkConfiguration);
        GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
