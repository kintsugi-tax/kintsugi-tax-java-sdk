# Filings

## Overview

### Available Operations

* [get](#get) - Get filings
* [createBackFilingRequestV1FilingsBackFilingRequestPost](#createbackfilingrequestv1filingsbackfilingrequestpost) - Create back filing request
* [getBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGet](#getbackfilingrequestoptionsv1filingsbackfilingrequestoptionsget) - Get back filing request options
* [getCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGet](#getcurrentbackfilingtermsv1filingsbackfilingtermscurrentget) - Get current back filing terms
* [getByRegistrationId](#getbyregistrationid) - Get filings by registration id
* [getById](#getbyid) - Get filing by id
* [approveFilingV1FilingsFilingIdApprovePut](#approvefilingv1filingsfilingidapproveput) - Approve filing

## get

The Get Filings API retrieves a paginated list of filings based on
    filters such as dates, jurisdiction, Country, status, etc. This helps track
    and manage tax filings efficiently across multiple jurisdictions.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_filings_v1_filings_get" method="get" path="/v1/filings" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.*;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcFilingsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetFilingsV1FilingsGetRequest req = GetFilingsV1FilingsGetRequest.builder()
                .xOrganizationId("org_12345")
                .statusIn("FILED,FILING,SUBMITTED,UNFILED,PAUSED,CANCELLED,ISSUE,SKIPPED")
                .startDate(LocalDate.parse("2024-01-01"))
                .endDate(LocalDate.parse("2024-12-31"))
                .dateFiledGte(LocalDate.parse("2024-01-01"))
                .dateFiledLte(LocalDate.parse("2024-12-31"))
                .orderBy("status,start_date,end_date,amount")
                .stateCode("CA")
                .countryCode(List.of(
                    GetFilingsV1FilingsGetCountryCode.of("U"),
                    GetFilingsV1FilingsGetCountryCode.of("S")))
                .filingCategoryIn("REGULAR")
                .taxTypeIn("SALES_TAX,USE_TAX")
                .build();

        GetFilingsV1FilingsGetResponse res = sdk.filings().get()
                .request(req)
                .call();

        if (res.pageFilingRead().isPresent()) {
            System.out.println(res.pageFilingRead().get());
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

## createBackFilingRequestV1FilingsBackFilingRequestPost

Create unapproved BACK_FILING rows for requested in-bounds periods.

### Example Usage

<!-- UsageSnippet language="java" operationID="create_back_filing_request_v1_filings_back_filing_request_post" method="post" path="/v1/filings/back-filing-request" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.CreateBackFilingRequestV1FilingsBackFilingRequestPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateBackFilingRequestV1FilingsBackFilingRequestPostResponse res = sdk.filings().createBackFilingRequestV1FilingsBackFilingRequestPost()
                .xOrganizationId("<id>")
                .backFilingRequestCreate(BackFilingRequestCreate.builder()
                    .requests(List.of(
                        BackFilingRequestRegistrationInput.builder()
                            .registrationId("<id>")
                            .periods(List.of(
                                BackFilingRequestPeriodInput.builder()
                                    .startDate(LocalDate.parse("2026-03-03"))
                                    .endDate(LocalDate.parse("2026-08-19"))
                                    .build()))
                            .build()))
                    .build())
                .call();

        if (res.backFilingRequestCreateResponse().isPresent()) {
            System.out.println(res.backFilingRequestCreateResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `xOrganizationId`                                                             | *Optional\<String>*                                                           | :heavy_check_mark:                                                            | N/A                                                                           |
| `backFilingRequestCreate`                                                     | [BackFilingRequestCreate](../../models/components/BackFilingRequestCreate.md) | :heavy_check_mark:                                                            | N/A                                                                           |

### Response

**[CreateBackFilingRequestV1FilingsBackFilingRequestPostResponse](../../models/operations/CreateBackFilingRequestV1FilingsBackFilingRequestPostResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## getBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGet

Eligible US registrations and periods for a customer back-filing request.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_back_filing_request_options_v1_filings_back_filing_request_options_get" method="get" path="/v1/filings/back-filing-request/options" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGetResponse res = sdk.filings().getBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGet()
                .xOrganizationId("org_12345")
                .call();

        if (res.backFilingRequestOptionsResponse().isPresent()) {
            System.out.println(res.backFilingRequestOptionsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGetResponse](../../models/operations/GetBackFilingRequestOptionsV1FilingsBackFilingRequestOptionsGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## getCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGet

Current back filing terms shown before BACK_FILING approval.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_current_back_filing_terms_v1_filings_back_filing_terms_current_get" method="get" path="/v1/filings/back-filing-terms/current" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGetResponse res = sdk.filings().getCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGet()
                .xOrganizationId("org_12345")
                .call();

        if (res.backFilingTermsRead().isPresent()) {
            System.out.println(res.backFilingTermsRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGetResponse](../../models/operations/GetCurrentBackFilingTermsV1FilingsBackFilingTermsCurrentGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

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
import com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcFilingsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse res = sdk.filings().getByRegistrationId()
                .registrationId("<id>")
                .page(1L)
                .size(50L)
                .xOrganizationId("org_12345")
                .call();

        if (res.pageFilingRead().isPresent()) {
            System.out.println(res.pageFilingRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 | Example                                                                     |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `registrationId`                                                            | *String*                                                                    | :heavy_check_mark:                                                          | Unique identifier for the registration<br/>        associated with the filings. |                                                                             |
| `page`                                                                      | *Optional\<Long>*                                                           | :heavy_minus_sign:                                                          | Page number                                                                 |                                                                             |
| `size`                                                                      | *Optional\<Long>*                                                           | :heavy_minus_sign:                                                          | Page size                                                                   |                                                                             |
| `xOrganizationId`                                                           | *Optional\<String>*                                                         | :heavy_check_mark:                                                          | The unique identifier for the organization making the request               | org_12345                                                                   |

### Response

**[GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse](../../models/operations/GetFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGetResponse.md)**

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
import com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetFilingByIdV1FilingsFilingIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcFilingsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetFilingByIdV1FilingsFilingIdGetResponse res = sdk.filings().getById()
                .filingId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.filingDetailsRead().isPresent()) {
            System.out.println(res.filingDetailsRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `filingId`                                                    | *String*                                                      | :heavy_check_mark:                                            | Unique identifier for the filing to retrieve.                 |                                                               |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetFilingByIdV1FilingsFilingIdGetResponse](../../models/operations/GetFilingByIdV1FilingsFilingIdGetResponse.md)**

### Errors

| Error Type                                                      | Status Code                                                     | Content Type                                                    |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| models/errors/ErrorResponse                                     | 401, 404                                                        | application/json                                                |
| models/errors/BackendSrcFilingsResponsesValidationErrorResponse | 422                                                             | application/json                                                |
| models/errors/ErrorResponse                                     | 500                                                             | application/json                                                |
| models/errors/APIException                                      | 4XX, 5XX                                                        | \*/\*                                                           |

## approveFilingV1FilingsFilingIdApprovePut

Approve a specific filing by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="approve_filing_v1_filings__filing_id__approve_put" method="put" path="/v1/filings/{filing_id}/approve" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.ApproveFilingV1FilingsFilingIdApprovePutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        ApproveFilingV1FilingsFilingIdApprovePutResponse res = sdk.filings().approveFilingV1FilingsFilingIdApprovePut()
                .filingId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.filingRead().isPresent()) {
            System.out.println(res.filingRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `filingId`                                                                             | *String*                                                                               | :heavy_check_mark:                                                                     | N/A                                                                                    |                                                                                        |
| `xOrganizationId`                                                                      | *Optional\<String>*                                                                    | :heavy_check_mark:                                                                     | The unique identifier for the organization making the request                          | org_12345                                                                              |
| `filingApproveRequest`                                                                 | [JsonNullable\<FilingApproveRequest>](../../models/components/FilingApproveRequest.md) | :heavy_minus_sign:                                                                     | N/A                                                                                    |                                                                                        |

### Response

**[ApproveFilingV1FilingsFilingIdApprovePutResponse](../../models/operations/ApproveFilingV1FilingsFilingIdApprovePutResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |