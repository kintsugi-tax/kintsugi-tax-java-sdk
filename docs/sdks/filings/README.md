# Filings
(*filings()*)

## Overview

### Available Operations

* [get](#get) - Get Filings
* [getById](#getbyid) - Get Filing By Id
* [getByRegistrationId](#getbyregistrationid) - Get Filings By Registration Id

## get

The Get Filings API retrieves a paginated list of filings based on
    filters such as dates, jurisdiction, Country, status, etc. This helps track
    and manage tax filings efficiently across multiple jurisdictions.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_filings_v1_filings_get" method="get" path="/v1/filings" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetFilingsV1FilingsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetFilingsV1FilingsGetResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcFilingsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetFilingsV1FilingsGetRequest req = GetFilingsV1FilingsGetRequest.builder()
                .startDate("2024-01-01")
                .endDate("2024-12-31")
                .dateFiledGte("2024-01-01")
                .dateFiledLte("2024-12-31")
                .orderBy("status,start_date,end_date,amount")
                .stateCode("CA")
                .countryCode(List.of(
                    ,))
                .build();

        GetFilingsV1FilingsGetResponse res = sdk.filings().get()
                .request(req)
                .call();

        if (res.pageFilingRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [GetFilingsV1FilingsGetRequest](../../models/operations/GetFilingsV1FilingsGetRequest.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[GetFilingsV1FilingsGetResponse](../../models/operations/GetFilingsV1FilingsGetResponse.md)**

### Errors

| Error Type                                                      | Status Code                                                     | Content Type                                                    |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| models/errors/ErrorResponse                                     | 401, 404                                                        | application/json                                                |
| models/errors/BackendSrcFilingsResponsesValidationErrorResponse | 422                                                             | application/json                                                |
| models/errors/ErrorResponse                                     | 500                                                             | application/json                                                |
| models/errors/APIException                                      | 4XX, 5XX                                                        | \*/\*                                                           |

## getById

This API retrieves detailed information about a specific
    filing using its unique identifier (filing_id).

### Example Usage

<!-- UsageSnippet language="java" operationID="get_filing_by_id_v1_filings__filing_id__get" method="get" path="/v1/filings/{filing_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetFilingByIdV1FilingsFilingIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcFilingsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetFilingByIdV1FilingsFilingIdGetResponse res = sdk.filings().getById()
                .filingId("<id>")
                .call();

        if (res.filingDetailsRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                     | Type                                          | Required                                      | Description                                   |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| `filingId`                                    | *String*                                      | :heavy_check_mark:                            | Unique identifier for the filing to retrieve. |

### Response

**[GetFilingByIdV1FilingsFilingIdGetResponse](../../models/operations/GetFilingByIdV1FilingsFilingIdGetResponse.md)**

### Errors

| Error Type                                                      | Status Code                                                     | Content Type                                                    |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| models/errors/ErrorResponse                                     | 401, 404                                                        | application/json                                                |
| models/errors/BackendSrcFilingsResponsesValidationErrorResponse | 422                                                             | application/json                                                |
| models/errors/ErrorResponse                                     | 500                                                             | application/json                                                |
| models/errors/APIException                                      | 4XX, 5XX                                                        | \*/\*                                                           |

## getByRegistrationId

The Get Filings By Registration ID API
    retrieves all filings
    associated with a specific registration ID. This allows users to query detailed
    filing information tied to
    a specific registration record.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_filings_by_registration_id_v1_filings_registration__registration_id__get" method="get" path="/v1/filings/registration/{registration_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcFilingsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse res = sdk.filings().getByRegistrationId()
                .registrationId("<id>")
                .page(1L)
                .size(50L)
                .call();

        if (res.pageFilingRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `registrationId`                                                            | *String*                                                                    | :heavy_check_mark:                                                          | Unique identifier for the registration<br/>        associated with the filings. |
| `page`                                                                      | *Optional\<Long>*                                                           | :heavy_minus_sign:                                                          | Page number                                                                 |
| `size`                                                                      | *Optional\<Long>*                                                           | :heavy_minus_sign:                                                          | Page size                                                                   |

### Response

**[GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse](../../models/operations/GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse.md)**

### Errors

| Error Type                                                      | Status Code                                                     | Content Type                                                    |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| models/errors/ErrorResponse                                     | 401, 404                                                        | application/json                                                |
| models/errors/BackendSrcFilingsResponsesValidationErrorResponse | 422                                                             | application/json                                                |
| models/errors/ErrorResponse                                     | 500                                                             | application/json                                                |
| models/errors/APIException                                      | 4XX, 5XX                                                        | \*/\*                                                           |