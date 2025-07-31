# Exemptions
(*exemptions()*)

## Overview

### Available Operations

* [getExemptionsV1ExemptionsGet](#getexemptionsv1exemptionsget) - Get Exemptions
* [createExemptionV1ExemptionsPost](#createexemptionv1exemptionspost) - Create Exemption
* [getExemptionByIdV1ExemptionsExemptionIdGet](#getexemptionbyidv1exemptionsexemptionidget) - Get Exemption By Id
* [uploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost](#uploadexemptioncertificatev1exemptionsexemptionidattachmentspost) - Upload Exemption Certificate
* [getAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet](#getattachmentsforexemptionv1exemptionsexemptionidattachmentsget) - Get Attachments For Exemption

## getExemptionsV1ExemptionsGet

Retrieve a list of exemptions based on filters.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_exemptions_v1_exemptions_get" method="get" path="/v1/exemptions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionsV1ExemptionsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetExemptionsV1ExemptionsGetResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetExemptionsV1ExemptionsGetRequest req = GetExemptionsV1ExemptionsGetRequest.builder()
                .searchQuery("John")
                .countryCode(List.of(
                    ,))
                .jurisdiction("CA")
                .startDate("2024-01-01")
                .endDate("2024-01-01")
                .customerId("cust_1234")
                .transactionId("trans_1234")
                .build();

        GetExemptionsV1ExemptionsGetResponse res = sdk.exemptions().getExemptionsV1ExemptionsGet()
                .request(req)
                .call();

        if (res.fastapiPaginationDefaultPageExemptionRead2().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `request`                                                                                             | [GetExemptionsV1ExemptionsGetRequest](../../models/operations/GetExemptionsV1ExemptionsGetRequest.md) | :heavy_check_mark:                                                                                    | The request object to use for the request.                                                            |

### Response

**[GetExemptionsV1ExemptionsGetResponse](../../models/operations/GetExemptionsV1ExemptionsGetResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## createExemptionV1ExemptionsPost

The Create Exemption API allows you to create a new exemption record.
    This includes defining details such as exemption type, jurisdiction,
    Country, State, validity dates, etc.

### Example Usage

<!-- UsageSnippet language="java" operationID="create_exemption_v1_exemptions_post" method="post" path="/v1/exemptions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateExemptionV1ExemptionsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        ExemptionCreate req = ExemptionCreate.builder()
                .exemptionType(ExemptionType.WHOLESALE)
                .startDate(LocalDate.parse("2024-01-01"))
                .customerId("cust_001")
                .fein("12-3456789")
                .salesTaxId("ST-98765")
                .status(ExemptionStatus.ACTIVE)
                .jurisdiction("CA")
                .countryCode(CountryCodeEnum.US)
                .endDate("2026-01-01")
                .transactionId("txn_123")
                .reseller(true)
                .build();

        CreateExemptionV1ExemptionsPostResponse res = sdk.exemptions().createExemptionV1ExemptionsPost()
                .request(req)
                .call();

        if (res.backendSrcExemptionsSerializersExemptionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `request`                                                 | [ExemptionCreate](../../models/shared/ExemptionCreate.md) | :heavy_check_mark:                                        | The request object to use for the request.                |

### Response

**[CreateExemptionV1ExemptionsPostResponse](../../models/operations/CreateExemptionV1ExemptionsPostResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## getExemptionByIdV1ExemptionsExemptionIdGet

The Get Exemption By ID API retrieves a specific exemption record by
    its unique ID. This API is useful for retrieving detailed information
    about a particular exemption, including its associated
    customer, organisation id, status, etc.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_exemption_by_id_v1_exemptions__exemption_id__get" method="get" path="/v1/exemptions/{exemption_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetExemptionByIdV1ExemptionsExemptionIdGetResponse res = sdk.exemptions().getExemptionByIdV1ExemptionsExemptionIdGet()
                .exemptionId("<id>")
                .call();

        if (res.backendSrcExemptionsModelsExemptionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                | Type                                                     | Required                                                 | Description                                              |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `exemptionId`                                            | *String*                                                 | :heavy_check_mark:                                       | The unique identifier for the exemption being retrieved. |

### Response

**[GetExemptionByIdV1ExemptionsExemptionIdGetResponse](../../models/operations/GetExemptionByIdV1ExemptionsExemptionIdGetResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 404                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## uploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost

The Upload Exemption Certificate API allows you
    to upload a file attachment (e.g., exemption certificate) for a specific exemption.
    This is primarily used to associate supporting documents with an exemption record
    to ensure compliance and facilitate verification.

### Example Usage

<!-- UsageSnippet language="java" operationID="upload_exemption_certificate_v1_exemptions__exemption_id__attachments_post" method="post" path="/v1/exemptions/{exemption_id}/attachments" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse res = sdk.exemptions().uploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost()
                .exemptionId("<id>")
                .bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost(BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost.builder()
                    .file(File.builder()
                        .fileName("example.file")
                        .content(Utils.readBytes("example.file"))
                        .build())
                    .build())
                .call();

        if (res.attachmentRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                               | Type                                                                                                                                                                    | Required                                                                                                                                                                | Description                                                                                                                                                             |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `exemptionId`                                                                                                                                                           | *String*                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                      | The unique identifier for the exemption to which the attachment will be associated.                                                                                     |
| `bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost`                                                                                                  | [BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost](../../models/components/BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost.md) | :heavy_check_mark:                                                                                                                                                      | N/A                                                                                                                                                                     |

### Response

**[UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse](../../models/operations/UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## getAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet

The Get Attachments for Exemption API retrieves all
    attachments associated with a specific exemption.
    This is used to view and manage supporting documents
    like exemption certificates uploaded for a particular exemption record.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_attachments_for_exemption_v1_exemptions__exemption_id__attachments_get" method="get" path="/v1/exemptions/{exemption_id}/attachments" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse res = sdk.exemptions().getAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet()
                .exemptionId("<id>")
                .call();

        if (res.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `exemptionId`                                                                          | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier for the exemption<br/>        whose attachments are being retrieved. |

### Response

**[GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse](../../models/operations/GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |