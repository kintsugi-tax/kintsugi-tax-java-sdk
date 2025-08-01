/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.SecuritySource;
import com.kintsugi.taxplatform.models.components.BackendSrcExemptionsModelsExemptionRead;
import com.kintsugi.taxplatform.models.errors.APIException;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetRequest;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetResponse;
import com.kintsugi.taxplatform.utils.HTTPClient;
import com.kintsugi.taxplatform.utils.HTTPRequest;
import com.kintsugi.taxplatform.utils.Hook.AfterErrorContextImpl;
import com.kintsugi.taxplatform.utils.Hook.AfterSuccessContextImpl;
import com.kintsugi.taxplatform.utils.Hook.BeforeRequestContextImpl;
import com.kintsugi.taxplatform.utils.Utils;
import java.io.InputStream;
import java.lang.Exception;
import java.lang.String;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;


public class GetExemptionByIdV1ExemptionsExemptionIdGetOperation implements RequestOperation<GetExemptionByIdV1ExemptionsExemptionIdGetRequest, GetExemptionByIdV1ExemptionsExemptionIdGetResponse> {

    private final SDKConfiguration sdkConfiguration;
    private final String baseUrl;
    private final SecuritySource securitySource;
    private final HTTPClient client;

    public GetExemptionByIdV1ExemptionsExemptionIdGetOperation(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.baseUrl = this.sdkConfiguration.serverUrl();
        this.securitySource = this.sdkConfiguration.securitySource();
        this.client = this.sdkConfiguration.client();
    }

    private Optional<SecuritySource> securitySource() {
        return Optional.ofNullable(this.securitySource);
    }

    public HttpRequest buildRequest(GetExemptionByIdV1ExemptionsExemptionIdGetRequest request) throws Exception {
        String url = Utils.generateURL(
                GetExemptionByIdV1ExemptionsExemptionIdGetRequest.class,
                this.baseUrl,
                "/v1/exemptions/{exemption_id}",
                request, null);
        HTTPRequest req = new HTTPRequest(url, "GET");
        req.addHeader("Accept", "application/json")
                .addHeader("user-agent", SDKConfiguration.USER_AGENT);
        Utils.configureSecurity(req, this.sdkConfiguration.securitySource().getSecurity());

        return sdkConfiguration.hooks().beforeRequest(
              new BeforeRequestContextImpl(
                  this.sdkConfiguration,
                  this.baseUrl,
                  "get_exemption_by_id_v1_exemptions__exemption_id__get",
                  java.util.Optional.of(java.util.List.of()),
                  securitySource()),
              req.build());
    }

    private HttpResponse<InputStream> onError(HttpResponse<InputStream> response,
                                              Exception error) throws Exception {
        return sdkConfiguration.hooks()
            .afterError(
                new AfterErrorContextImpl(
                    this.sdkConfiguration,
                    this.baseUrl,
                    "get_exemption_by_id_v1_exemptions__exemption_id__get",
                    java.util.Optional.of(java.util.List.of()),
                    securitySource()),
                Optional.ofNullable(response),
                Optional.ofNullable(error));
    }

    private HttpResponse<InputStream> onSuccess(HttpResponse<InputStream> response) throws Exception {
        return sdkConfiguration.hooks()
            .afterSuccess(
                new AfterSuccessContextImpl(
                    this.sdkConfiguration,
                    this.baseUrl,
                    "get_exemption_by_id_v1_exemptions__exemption_id__get",
                    java.util.Optional.of(java.util.List.of()),
                    securitySource()),
                response);
    }

    @Override
    public HttpResponse<InputStream> doRequest(GetExemptionByIdV1ExemptionsExemptionIdGetRequest request) throws Exception {
        HttpRequest r = buildRequest(request);
        HttpResponse<InputStream> httpRes;
        try {
            httpRes = client.send(r);
            if (Utils.statusCodeMatches(httpRes.statusCode(), "404", "422", "4XX", "500", "5XX")) {
                httpRes = onError(httpRes, null);
            } else {
                httpRes = onSuccess(httpRes);
            }
        } catch (Exception e) {
            httpRes = onError(null, e);
        }

        return httpRes;
    }


    @Override
    public GetExemptionByIdV1ExemptionsExemptionIdGetResponse handleResponse(HttpResponse<InputStream> response) throws Exception {
        String contentType = response
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        GetExemptionByIdV1ExemptionsExemptionIdGetResponse.Builder resBuilder = 
            GetExemptionByIdV1ExemptionsExemptionIdGetResponse
                .builder()
                .contentType(contentType)
                .statusCode(response.statusCode())
                .rawResponse(response);

        GetExemptionByIdV1ExemptionsExemptionIdGetResponse res = resBuilder.build();
        
        if (Utils.statusCodeMatches(response.statusCode(), "200")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                BackendSrcExemptionsModelsExemptionRead out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                res.withBackendSrcExemptionsModelsExemptionRead(out);
                return res;
            } else {
                throw new APIException(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "404")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                ErrorResponse out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                    out.withRawResponse(response);
                
                throw out;
            } else {
                throw new APIException(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "422")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                BackendSrcExemptionsResponsesValidationErrorResponse out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                    out.withRawResponse(response);
                
                throw out;
            } else {
                throw new APIException(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "500")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                ErrorResponse out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                    out.withRawResponse(response);
                
                throw out;
            } else {
                throw new APIException(
                    response, 
                    response.statusCode(), 
                    "Unexpected content-type received: " + contentType, 
                    Utils.extractByteArrayFromBody(response));
            }
        }
        if (Utils.statusCodeMatches(response.statusCode(), "4XX")) {
            // no content 
            throw new APIException(
                    response, 
                    response.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(response));
        }
        if (Utils.statusCodeMatches(response.statusCode(), "5XX")) {
            // no content 
            throw new APIException(
                    response, 
                    response.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(response));
        }
        throw new APIException(
            response, 
            response.statusCode(), 
            "Unexpected status code received: " + response.statusCode(), 
            Utils.extractByteArrayFromBody(response));
    }
}
