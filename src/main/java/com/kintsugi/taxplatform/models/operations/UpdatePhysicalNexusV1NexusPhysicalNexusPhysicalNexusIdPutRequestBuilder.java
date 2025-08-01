/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.PhysicalNexusUpdate;
import com.kintsugi.taxplatform.operations.UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;
import java.lang.String;

public class UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequestBuilder {

    private String physicalNexusId;
    private PhysicalNexusUpdate physicalNexusUpdate;
    private final SDKConfiguration sdkConfiguration;

    public UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequestBuilder physicalNexusId(String physicalNexusId) {
        Utils.checkNotNull(physicalNexusId, "physicalNexusId");
        this.physicalNexusId = physicalNexusId;
        return this;
    }

    public UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequestBuilder physicalNexusUpdate(PhysicalNexusUpdate physicalNexusUpdate) {
        Utils.checkNotNull(physicalNexusUpdate, "physicalNexusUpdate");
        this.physicalNexusUpdate = physicalNexusUpdate;
        return this;
    }


    private UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequest buildRequest() {

        UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequest request = new UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequest(physicalNexusId,
            physicalNexusUpdate);

        return request;
    }

    public UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse call() throws Exception {
        
        RequestOperation<UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequest, UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse> operation
              = new UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutOperation(sdkConfiguration);
        UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
