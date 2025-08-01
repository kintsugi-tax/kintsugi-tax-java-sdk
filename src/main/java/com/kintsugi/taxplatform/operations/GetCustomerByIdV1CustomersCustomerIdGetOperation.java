/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.kintsugi.taxplatform.operations;

import static com.kintsugi.taxplatform.operations.Operations.RequestOperation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kintsugi.taxplatform.SDKConfiguration;
import com.kintsugi.taxplatform.SecuritySource;
import com.kintsugi.taxplatform.models.components.CustomerRead;
import com.kintsugi.taxplatform.models.errors.APIException;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetCustomerByIdV1CustomersCustomerIdGetRequest;
import com.kintsugi.taxplatform.models.operations.GetCustomerByIdV1CustomersCustomerIdGetResponse;
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


public class GetCustomerByIdV1CustomersCustomerIdGetOperation implements RequestOperation<GetCustomerByIdV1CustomersCustomerIdGetRequest, GetCustomerByIdV1CustomersCustomerIdGetResponse> {

    private final SDKConfiguration sdkConfiguration;
    private final String baseUrl;
    private final SecuritySource securitySource;
    private final HTTPClient client;

    public GetCustomerByIdV1CustomersCustomerIdGetOperation(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.baseUrl = this.sdkConfiguration.serverUrl();
        this.securitySource = this.sdkConfiguration.securitySource();
        this.client = this.sdkConfiguration.client();
    }

    private Optional<SecuritySource> securitySource() {
        return Optional.ofNullable(this.securitySource);
    }

    public HttpRequest buildRequest(GetCustomerByIdV1CustomersCustomerIdGetRequest request) throws Exception {
        String url = Utils.generateURL(
                GetCustomerByIdV1CustomersCustomerIdGetRequest.class,
                this.baseUrl,
                "/v1/customers/{customer_id}",
                request, null);
        HTTPRequest req = new HTTPRequest(url, "GET");
        req.addHeader("Accept", "application/json")
                .addHeader("user-agent", SDKConfiguration.USER_AGENT);
        Utils.configureSecurity(req, this.sdkConfiguration.securitySource().getSecurity());

        return sdkConfiguration.hooks().beforeRequest(
              new BeforeRequestContextImpl(
                  this.sdkConfiguration,
                  this.baseUrl,
                  "get_customer_by_id_v1_customers__customer_id__get",
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
                    "get_customer_by_id_v1_customers__customer_id__get",
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
                    "get_customer_by_id_v1_customers__customer_id__get",
                    java.util.Optional.of(java.util.List.of()),
                    securitySource()),
                response);
    }

    @Override
    public HttpResponse<InputStream> doRequest(GetCustomerByIdV1CustomersCustomerIdGetRequest request) throws Exception {
        HttpRequest r = buildRequest(request);
        HttpResponse<InputStream> httpRes;
        try {
            httpRes = client.send(r);
            if (Utils.statusCodeMatches(httpRes.statusCode(), "404", "422", "4XX", "5XX")) {
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
    public GetCustomerByIdV1CustomersCustomerIdGetResponse handleResponse(HttpResponse<InputStream> response) throws Exception {
        String contentType = response
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        GetCustomerByIdV1CustomersCustomerIdGetResponse.Builder resBuilder = 
            GetCustomerByIdV1CustomersCustomerIdGetResponse
                .builder()
                .contentType(contentType)
                .statusCode(response.statusCode())
                .rawResponse(response);

        GetCustomerByIdV1CustomersCustomerIdGetResponse res = resBuilder.build();
        
        if (Utils.statusCodeMatches(response.statusCode(), "200")) {
            if (Utils.contentTypeMatches(contentType, "application/json")) {
                CustomerRead out = Utils.mapper().readValue(
                    response.body(),
                    new TypeReference<>() {
                    });
                res.withCustomerRead(out);
                return res;
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
                HTTPValidationError out = Utils.mapper().readValue(
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
        if (Utils.statusCodeMatches(response.statusCode(), "404", "4XX")) {
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
