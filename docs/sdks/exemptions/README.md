# Exemptions
(*exemptions()*)

## Overview

### Available Operations

* [list](#list) - Get Exemptions
* [create](#create) - Create Exemption
* [get](#get) - Get Exemption By Id
* [uploadCertificate](#uploadcertificate) - Upload Exemption Certificate
* [getAttachments](#getattachments) - Get Attachments For Exemption

## list

Retrieve a list of exemptions based on filters.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.*;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetExemptionsV1ExemptionsGetRequest req = GetExemptionsV1ExemptionsGetRequest.builder()
                .xOrganizationId("org_12345")
                .searchQuery("John")
                .countryCode(List.of(
                    CountryCode.of("U"),
                    CountryCode.of("S")))
                .jurisdiction("CA")
                .startDate(LocalDate.parse("2024-01-01"))
                .endDate(LocalDate.parse("2024-01-01"))
                .customerId("cust_1234")
                .transactionId("trans_1234")
                .build();

        GetExemptionsV1ExemptionsGetResponse res = sdk.exemptions().list()
                .request(req)
                .security(GetExemptionsV1ExemptionsGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.fastapiPaginationDefaultPageExemptionRead2().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                          | Type                                                                                                                                               | Required                                                                                                                                           | Description                                                                                                                                        |
| -------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                          | [GetExemptionsV1ExemptionsGetRequest](../../models/operations/GetExemptionsV1ExemptionsGetRequest.md)                                              | :heavy_check_mark:                                                                                                                                 | The request object to use for the request.                                                                                                         |
| `security`                                                                                                                                         | [com.kintsugi.taxplatform.models.operations.GetExemptionsV1ExemptionsGetSecurity](../../models/operations/GetExemptionsV1ExemptionsGetSecurity.md) | :heavy_check_mark:                                                                                                                                 | The security requirements to use for the request.                                                                                                  |

### Response

**[GetExemptionsV1ExemptionsGetResponse](../../models/operations/GetExemptionsV1ExemptionsGetResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## create

The Create Exemption API allows you to create a new exemption record.
    This includes defining details such as exemption type, jurisdiction,
    Country, State, validity dates, etc.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateExemptionV1ExemptionsPostResponse;
import com.kintsugi.taxplatform.models.operations.CreateExemptionV1ExemptionsPostSecurity;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        CreateExemptionV1ExemptionsPostResponse res = sdk.exemptions().create()
                .security(CreateExemptionV1ExemptionsPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .xOrganizationId("org_12345")
                .exemptionCreate(ExemptionCreate.builder()
                    .exemptionType(ExemptionType.WHOLESALE)
                    .startDate(LocalDate.parse("2024-01-01"))
                    .customerId("cust_001")
                    .fein("12-3456789")
                    .salesTaxId("ST-98765")
                    .status(ExemptionStatus.ACTIVE)
                    .jurisdiction("CA")
                    .countryCode(CountryCodeEnum.US)
                    .endDate(LocalDate.parse("2026-01-01"))
                    .transactionId("txn_123")
                    .reseller(true)
                    .build())
                .call();

        if (res.backendSrcExemptionsSerializersExemptionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                | Type                                                                                                                                                     | Required                                                                                                                                                 | Description                                                                                                                                              | Example                                                                                                                                                  |
| -------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                               | [com.kintsugi.taxplatform.models.operations.CreateExemptionV1ExemptionsPostSecurity](../../models/operations/CreateExemptionV1ExemptionsPostSecurity.md) | :heavy_check_mark:                                                                                                                                       | The security requirements to use for the request.                                                                                                        |                                                                                                                                                          |
| `xOrganizationId`                                                                                                                                        | *Optional\<String>*                                                                                                                                      | :heavy_check_mark:                                                                                                                                       | The unique identifier for the organization making the request                                                                                            | org_12345                                                                                                                                                |
| `exemptionCreate`                                                                                                                                        | [ExemptionCreate](../../models/components/ExemptionCreate.md)                                                                                            | :heavy_check_mark:                                                                                                                                       | N/A                                                                                                                                                      |                                                                                                                                                          |

### Response

**[CreateExemptionV1ExemptionsPostResponse](../../models/operations/CreateExemptionV1ExemptionsPostResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## get

The Get Exemption By ID API retrieves a specific exemption record by
    its unique ID. This API is useful for retrieving detailed information
    about a particular exemption, including its associated
    customer, organisation id, status, etc.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetResponse;
import com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetExemptionByIdV1ExemptionsExemptionIdGetResponse res = sdk.exemptions().get()
                .security(GetExemptionByIdV1ExemptionsExemptionIdGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .exemptionId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.backendSrcExemptionsModelsExemptionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                      | Type                                                                                                                                                                           | Required                                                                                                                                                                       | Description                                                                                                                                                                    | Example                                                                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                                     | [com.kintsugi.taxplatform.models.operations.GetExemptionByIdV1ExemptionsExemptionIdGetSecurity](../../models/operations/GetExemptionByIdV1ExemptionsExemptionIdGetSecurity.md) | :heavy_check_mark:                                                                                                                                                             | The security requirements to use for the request.                                                                                                                              |                                                                                                                                                                                |
| `exemptionId`                                                                                                                                                                  | *String*                                                                                                                                                                       | :heavy_check_mark:                                                                                                                                                             | The unique identifier for the exemption being retrieved.                                                                                                                       |                                                                                                                                                                                |
| `xOrganizationId`                                                                                                                                                              | *Optional\<String>*                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                             | The unique identifier for the organization making the request                                                                                                                  | org_12345                                                                                                                                                                      |

### Response

**[GetExemptionByIdV1ExemptionsExemptionIdGetResponse](../../models/operations/GetExemptionByIdV1ExemptionsExemptionIdGetResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 404                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## uploadCertificate

The Upload Exemption Certificate API allows you
    to upload a file attachment (e.g., exemption certificate) for a specific exemption.
    This is primarily used to associate supporting documents with an exemption record
    to ensure compliance and facilitate verification.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost;
import com.kintsugi.taxplatform.models.components.File;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse;
import com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostSecurity;
import com.kintsugi.taxplatform.utils.Utils;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse res = sdk.exemptions().uploadCertificate()
                .security(UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .exemptionId("<id>")
                .xOrganizationId("org_12345")
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

| Parameter                                                                                                                                                                                                                  | Type                                                                                                                                                                                                                       | Required                                                                                                                                                                                                                   | Description                                                                                                                                                                                                                | Example                                                                                                                                                                                                                    |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                                                 | [com.kintsugi.taxplatform.models.operations.UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostSecurity](../../models/operations/UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostSecurity.md) | :heavy_check_mark:                                                                                                                                                                                                         | The security requirements to use for the request.                                                                                                                                                                          |                                                                                                                                                                                                                            |
| `exemptionId`                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                   | :heavy_check_mark:                                                                                                                                                                                                         | The unique identifier for the exemption to which the attachment will be associated.                                                                                                                                        |                                                                                                                                                                                                                            |
| `xOrganizationId`                                                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                                                        | :heavy_check_mark:                                                                                                                                                                                                         | The unique identifier for the organization making the request                                                                                                                                                              | org_12345                                                                                                                                                                                                                  |
| `bodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost`                                                                                                                                                     | [BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost](../../models/components/BodyUploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost.md)                                                    | :heavy_check_mark:                                                                                                                                                                                                         | N/A                                                                                                                                                                                                                        |                                                                                                                                                                                                                            |

### Response

**[UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse](../../models/operations/UploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPostResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/ErrorResponse                                        | 500                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |

## getAttachments

The Get Attachments for Exemption API retrieves all
    attachments associated with a specific exemption.
    This is used to view and manage supporting documents
    like exemption certificates uploaded for a particular exemption record.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse;
import com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcExemptionsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse res = sdk.exemptions().getAttachments()
                .security(GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .exemptionId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.response200GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                | Type                                                                                                                                                                                                                     | Required                                                                                                                                                                                                                 | Description                                                                                                                                                                                                              | Example                                                                                                                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                                                                               | [com.kintsugi.taxplatform.models.operations.GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetSecurity](../../models/operations/GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetSecurity.md) | :heavy_check_mark:                                                                                                                                                                                                       | The security requirements to use for the request.                                                                                                                                                                        |                                                                                                                                                                                                                          |
| `exemptionId`                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                       | The unique identifier for the exemption<br/>        whose attachments are being retrieved.                                                                                                                               |                                                                                                                                                                                                                          |
| `xOrganizationId`                                                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                                                      | :heavy_check_mark:                                                                                                                                                                                                       | The unique identifier for the organization making the request                                                                                                                                                            | org_12345                                                                                                                                                                                                                |

### Response

**[GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse](../../models/operations/GetAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGetResponse.md)**

### Errors

| Error Type                                                         | Status Code                                                        | Content Type                                                       |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| models/errors/ErrorResponse                                        | 401                                                                | application/json                                                   |
| models/errors/BackendSrcExemptionsResponsesValidationErrorResponse | 422                                                                | application/json                                                   |
| models/errors/APIException                                         | 4XX, 5XX                                                           | \*/\*                                                              |