/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.models.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.models.components.BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost;
import com.kintsugi.taxplatform.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostOperation;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder {

    private UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostSecurity security;
    private String exemptionId;
    private Optional<String> xOrganizationId = Optional.empty();
    private BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost;
    private final SDKConfiguration sdkConfiguration;

    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder security(UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostSecurity security) {
        Utils.checkNotNull(security, "security");
        this.security = security;
        return this;
    }

    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder exemptionId(String exemptionId) {
        Utils.checkNotNull(exemptionId, "exemptionId");
        this.exemptionId = exemptionId;
        return this;
    }
                
    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder xOrganizationId(String xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = Optional.of(xOrganizationId);
        return this;
    }

    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder xOrganizationId(Optional<String> xOrganizationId) {
        Utils.checkNotNull(xOrganizationId, "xOrganizationId");
        this.xOrganizationId = xOrganizationId;
        return this;
    }

    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost(BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost) {
        Utils.checkNotNull(bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost, "bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost");
        this.bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost = bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost;
        return this;
    }


    private UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest buildRequest() {

        UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest request = new UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest(exemptionId,
            xOrganizationId,
            bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost);

        return request;
    }

    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse call() throws Exception {
        
        RequestOperation<UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest, UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse> operation
              = new UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostOperation(sdkConfiguration, security);
        UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
