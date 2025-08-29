# Nexus
(*nexus()*)

## Overview

### Available Operations

* [getPhysical](#getphysical) - Get Physical Nexus
* [createPhysical](#createphysical) - Create Physical Nexus
* [updatePhysical](#updatephysical) - Update Physical Nexus
* [deletePhysical](#deletephysical) - Delete Physical Nexus
* [get](#get) - Get Nexus For Org

## getPhysical

Retrieve a paginated list of
    physical nexuses for a specific organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_physical_nexus_v1_nexus_physical_nexus_get" method="get" path="/v1/nexus/physical_nexus" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetPhysicalNexusV1NexusPhysicalNexusGetRequest;
import com.kintsugi.taxplatform.models.operations.GetPhysicalNexusV1NexusPhysicalNexusGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetPhysicalNexusV1NexusPhysicalNexusGetRequest req = GetPhysicalNexusV1NexusPhysicalNexusGetRequest.builder()
                .build();

        GetPhysicalNexusV1NexusPhysicalNexusGetResponse res = sdk.nexus().getPhysical()
                .request(req)
                .call();

        if (res.pagePhysicalNexusRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                   | Type                                                                                                                        | Required                                                                                                                    | Description                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                   | [GetPhysicalNexusV1NexusPhysicalNexusGetRequest](../../models/operations/GetPhysicalNexusV1NexusPhysicalNexusGetRequest.md) | :heavy_check_mark:                                                                                                          | The request object to use for the request.                                                                                  |

### Response

**[GetPhysicalNexusV1NexusPhysicalNexusGetResponse](../../models/operations/GetPhysicalNexusV1NexusPhysicalNexusGetResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401, 404                                                      | application/json                                              |
| models/errors/BackendSrcNexusResponsesValidationErrorResponse | 422                                                           | application/json                                              |
| models/errors/ErrorResponse                                   | 500                                                           | application/json                                              |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |

## createPhysical

The Create Physical Nexus API allows you to create a new physical
    nexus by specifying its attributes, including the location,
    start date, end date, etc.

### Example Usage

<!-- UsageSnippet language="java" operationID="create_physical_nexus_v1_nexus_physical_nexus_post" method="post" path="/v1/nexus/physical_nexus" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreatePhysicalNexusV1NexusPhysicalNexusPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        PhysicalNexusCreate req = PhysicalNexusCreate.builder()
                .countryCode(CountryCodeEnum.US)
                .stateCode("CA")
                .startDate(LocalDate.parse("2024-01-01"))
                .category(PhysicalNexusCategory.PHYSICAL_BUSINESS_LOCATION)
                .endDate("2025-01-01")
                .externalId("ext_ABC123")
                .source(PhysicalNexusSource.USER)
                .build();

        CreatePhysicalNexusV1NexusPhysicalNexusPostResponse res = sdk.nexus().createPhysical()
                .request(req)
                .call();

        if (res.physicalNexusRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [PhysicalNexusCreate](../../models/shared/PhysicalNexusCreate.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[CreatePhysicalNexusV1NexusPhysicalNexusPostResponse](../../models/operations/CreatePhysicalNexusV1NexusPhysicalNexusPostResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401                                                           | application/json                                              |
| models/errors/BackendSrcNexusResponsesValidationErrorResponse | 422                                                           | application/json                                              |
| models/errors/ErrorResponse                                   | 500                                                           | application/json                                              |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |

## updatePhysical

The Update Physical Nexus API allows you to modify the details of
    an existing physical nexus by its unique ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="update_physical_nexus_v1_nexus_physical_nexus__physical_nexus_id__put" method="put" path="/v1/nexus/physical_nexus/{physical_nexus_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse res = sdk.nexus().updatePhysical()
                .physicalNexusId("<id>")
                .physicalNexusUpdate(PhysicalNexusUpdate.builder()
                    .startDate(LocalDate.parse("2024-01-01"))
                    .category(PhysicalNexusCategory.PHYSICAL_BUSINESS_LOCATION)
                    .endDate("2025-01-01")
                    .build())
                .call();

        if (res.physicalNexusRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `physicalNexusId`                                                                      | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier of the physical<br/>                                nexus to update. |
| `physicalNexusUpdate`                                                                  | [PhysicalNexusUpdate](../../models/components/PhysicalNexusUpdate.md)                  | :heavy_check_mark:                                                                     | N/A                                                                                    |

### Response

**[UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse](../../models/operations/UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401, 404                                                      | application/json                                              |
| models/errors/BackendSrcNexusResponsesValidationErrorResponse | 422                                                           | application/json                                              |
| models/errors/ErrorResponse                                   | 500                                                           | application/json                                              |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |

## deletePhysical

The Delete Physical Nexus API allows you to remove an existing
    physical nexus by its unique ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete_physical_nexus_v1_nexus_physical_nexus__physical_nexus_id__delete" method="delete" path="/v1/nexus/physical_nexus/{physical_nexus_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse res = sdk.nexus().deletePhysical()
                .physicalNexusId("<id>")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `physicalNexusId`                                                                      | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier of the physical<br/>                                nexus to delete. |

### Response

**[DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse](../../models/operations/DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401, 404                                                      | application/json                                              |
| models/errors/BackendSrcNexusResponsesValidationErrorResponse | 422                                                           | application/json                                              |
| models/errors/ErrorResponse                                   | 500                                                           | application/json                                              |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |

## get

Get a list of all nexuses for the organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_nexus_for_org_v1_nexus_get" method="get" path="/v1/nexus" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetNexusForOrgV1NexusGetRequest;
import com.kintsugi.taxplatform.models.operations.GetNexusForOrgV1NexusGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetNexusForOrgV1NexusGetRequest req = GetNexusForOrgV1NexusGetRequest.builder()
                .build();

        GetNexusForOrgV1NexusGetResponse res = sdk.nexus().get()
                .request(req)
                .call();

        if (res.pageNexusResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [GetNexusForOrgV1NexusGetRequest](../../models/operations/GetNexusForOrgV1NexusGetRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[GetNexusForOrgV1NexusGetResponse](../../models/operations/GetNexusForOrgV1NexusGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |