/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.kintsugi.taxplatform.models.components.BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost;
import com.kintsugi.taxplatform.models.components.ExemptionCreate;
import com.kintsugi.taxplatform.models.operations.CreateExemptionV1ExemptionsPostRequestBuilder;
import com.kintsugi.taxplatform.models.operations.CreateExemptionV1ExemptionsPostResponse;
import com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequestBuilder;
import com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetRequest;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetRequestBuilder;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionsV1ExemptionsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetExemptionsV1ExemptionsGetRequestBuilder;
import com.kintsugi.taxplatform.models.operations.GetExemptionsV1ExemptionsGetResponse;
import com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest;
import com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder;
import com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse;
import com.kintsugi.taxplatform.operations.CreateExemptionV1ExemptionsPostOperation;
import com.kintsugi.taxplatform.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetOperation;
import com.kintsugi.taxplatform.operations.GetExemptionByIdV1ExemptionsExemptionIdGetOperation;
import com.kintsugi.taxplatform.operations.GetExemptionsV1ExemptionsGetOperation;
import com.kintsugi.taxplatform.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostOperation;
import java.lang.Exception;
import java.lang.String;


public class Exemptions {
    private final SDKConfiguration sdkConfiguration;

    Exemptions(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    /**
     * Get Exemptions
     * 
     * <p>Retrieve a list of exemptions based on filters.
     * 
     * @return The call builder
     */
    public GetExemptionsV1ExemptionsGetRequestBuilder get() {
        return new GetExemptionsV1ExemptionsGetRequestBuilder(sdkConfiguration);
    }

    /**
     * Get Exemptions
     * 
     * <p>Retrieve a list of exemptions based on filters.
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetExemptionsV1ExemptionsGetResponse get(GetExemptionsV1ExemptionsGetRequest request) throws Exception {
        RequestOperation<GetExemptionsV1ExemptionsGetRequest, GetExemptionsV1ExemptionsGetResponse> operation
              = new GetExemptionsV1ExemptionsGetOperation(sdkConfiguration);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Create Exemption
     * 
     * <p>The Create Exemption API allows you to create a new exemption record.
     *     This includes defining details such as exemption type, jurisdiction,
     *     Country, State, validity dates, etc.
     * 
     * @return The call builder
     */
    public CreateExemptionV1ExemptionsPostRequestBuilder create() {
        return new CreateExemptionV1ExemptionsPostRequestBuilder(sdkConfiguration);
    }

    /**
     * Create Exemption
     * 
     * <p>The Create Exemption API allows you to create a new exemption record.
     *     This includes defining details such as exemption type, jurisdiction,
     *     Country, State, validity dates, etc.
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateExemptionV1ExemptionsPostResponse create(ExemptionCreate request) throws Exception {
        RequestOperation<ExemptionCreate, CreateExemptionV1ExemptionsPostResponse> operation
              = new CreateExemptionV1ExemptionsPostOperation(sdkConfiguration);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Get Exemption By Id
     * 
     * <p>The Get Exemption By ID API retrieves a specific exemption record by
     *     its unique ID. This API is useful for retrieving detailed information
     *     about a particular exemption, including its associated
     *     customer, organisation id, status, etc.
     * 
     * @return The call builder
     */
    public GetExemptionByIdV1ExemptionsExemptionIdGetRequestBuilder getById() {
        return new GetExemptionByIdV1ExemptionsExemptionIdGetRequestBuilder(sdkConfiguration);
    }

    /**
     * Get Exemption By Id
     * 
     * <p>The Get Exemption By ID API retrieves a specific exemption record by
     *     its unique ID. This API is useful for retrieving detailed information
     *     about a particular exemption, including its associated
     *     customer, organisation id, status, etc.
     * 
     * @param exemptionId The unique identifier for the exemption being retrieved.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetExemptionByIdV1ExemptionsExemptionIdGetResponse getById(String exemptionId) throws Exception {
        GetExemptionByIdV1ExemptionsExemptionIdGetRequest request =
            GetExemptionByIdV1ExemptionsExemptionIdGetRequest
                .builder()
                .exemptionId(exemptionId)
                .build();
        RequestOperation<GetExemptionByIdV1ExemptionsExemptionIdGetRequest, GetExemptionByIdV1ExemptionsExemptionIdGetResponse> operation
              = new GetExemptionByIdV1ExemptionsExemptionIdGetOperation(sdkConfiguration);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Upload Exemption Certificate
     * 
     * <p>The Upload Exemption Certificate API allows you
     *     to upload a file attachment (e.g., exemption certificate) for a specific exemption.
     *     This is primarily used to associate supporting documents with an exemption record
     *     to ensure compliance and facilitate verification.
     * 
     * @return The call builder
     */
    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder uploadCertificate() {
        return new UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequestBuilder(sdkConfiguration);
    }

    /**
     * Upload Exemption Certificate
     * 
     * <p>The Upload Exemption Certificate API allows you
     *     to upload a file attachment (e.g., exemption certificate) for a specific exemption.
     *     This is primarily used to associate supporting documents with an exemption record
     *     to ensure compliance and facilitate verification.
     * 
     * @param exemptionId The unique identifier for the exemption to which the attachment will be associated.
     * @param bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse uploadCertificate(String exemptionId, BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost) throws Exception {
        UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest request =
            UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest
                .builder()
                .exemptionId(exemptionId)
                .bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost(bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost)
                .build();
        RequestOperation<UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostRequest, UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse> operation
              = new UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostOperation(sdkConfiguration);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Get Attachments For Exemption
     * 
     * <p>The Get Attachments for Exemption API retrieves all
     *     attachments associated with a specific exemption.
     *     This is used to view and manage supporting documents
     *     like exemption certificates uploaded for a particular exemption record.
     * 
     * @return The call builder
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequestBuilder getAttachments() {
        return new GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequestBuilder(sdkConfiguration);
    }

    /**
     * Get Attachments For Exemption
     * 
     * <p>The Get Attachments for Exemption API retrieves all
     *     attachments associated with a specific exemption.
     *     This is used to view and manage supporting documents
     *     like exemption certificates uploaded for a particular exemption record.
     * 
     * @param exemptionId The unique identifier for the exemption
     *                 whose attachments are being retrieved.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse getAttachments(String exemptionId) throws Exception {
        GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequest request =
            GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequest
                .builder()
                .exemptionId(exemptionId)
                .build();
        RequestOperation<GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetRequest, GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse> operation
              = new GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetOperation(sdkConfiguration);
        return operation.handleResponse(operation.doRequest(request));
    }

}
