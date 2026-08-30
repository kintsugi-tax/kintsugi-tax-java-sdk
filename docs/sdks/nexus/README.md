# Nexus

## Overview

### Available Operations

* [get](#get) - Get nexus for org
* [getPhysical](#getphysical) - Get physical nexus
* [createPhysical](#createphysical) - Create physical nexus
* [getPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGet](#getphysicalnexuscategoriesv1nexusphysicalnexuscategoriesget) - Get physical nexus categories
* [deletePhysical](#deletephysical) - Delete physical nexus
* [updatePhysical](#updatephysical) - Update physical nexus
* [getNexusDetailsForIdV1NexusNexusIdGet](#getnexusdetailsforidv1nexusnexusidget) - Get nexus details for id

## get

Get a list of all nexuses for the organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_nexus_for_org_v1_nexus_get" method="get" path="/v1/nexus" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.NexusResponse;
import com.kintsugi.taxplatform.models.components.PageNexusResponse;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.*;
import java.lang.Exception;
import java.lang.Object;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetNexusForOrgV1NexusGetRequest req = GetNexusForOrgV1NexusGetRequest.builder()
                .xOrganizationId("org_12345")
                .statusIn("APPROACHING,NOT_EXPOSED,PENDING_REGISTRATION,EXPOSED,APPROACHING,REGISTERED")
                .orderBy("state_code,country_code")
                .build();

        GetNexusForOrgV1NexusGetResponse res = sdk.nexus().get()
                .request(req)
                .call();

        if (res.responseGetNexusForOrgV1NexusGet().isPresent()) {
            ResponseGetNexusForOrgV1NexusGet unionValue = res.responseGetNexusForOrgV1NexusGet().get();
            Object raw = unionValue.value();
            if (raw instanceof PageNexusResponse) {
                PageNexusResponse pageNexusResponseValue = (PageNexusResponse) raw;
                // Handle pageNexusResponse variant
            } else if (raw instanceof List) {
                List<NexusResponse> arrayOfNexusResponseValue = (List<NexusResponse>) raw;
                // Handle arrayOfNexusResponse variant
            } else {
                // Unknown or unsupported variant
            }
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

## getPhysical

Retrieve a paginated list of
    physical nexuses for a specific organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_physical_nexus_v1_nexus_physical_nexus_get" method="get" path="/v1/nexus/physical_nexus" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetPhysicalNexusV1NexusPhysicalNexusGetRequest;
import com.kintsugi.taxplatform.models.operations.GetPhysicalNexusV1NexusPhysicalNexusGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetPhysicalNexusV1NexusPhysicalNexusGetRequest req = GetPhysicalNexusV1NexusPhysicalNexusGetRequest.builder()
                .xOrganizationId("org_12345")
                .orderBy("country_code,state_code,start_date,end_date")
                .build();

        GetPhysicalNexusV1NexusPhysicalNexusGetResponse res = sdk.nexus().getPhysical()
                .request(req)
                .call();

        if (res.pagePhysicalNexusRead().isPresent()) {
            System.out.println(res.pagePhysicalNexusRead().get());
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

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreatePhysicalNexusV1NexusPhysicalNexusPostResponse res = sdk.nexus().createPhysical()
                .xOrganizationId("org_12345")
                .physicalNexusCreate(PhysicalNexusCreate.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("CA")
                    .startDate(LocalDate.parse("2024-01-01"))
                    .category(PhysicalNexusCategory.PHYSICAL_BUSINESS_LOCATION)
                    .endDate(LocalDate.parse("2025-01-01"))
                    .externalId("ext_ABC123")
                    .source(PhysicalNexusSource.USER)
                    .street1("123 Main Street")
                    .street2("Suite 100")
                    .city("San Francisco")
                    .postalCode("94102")
                    .build())
                .call();

        if (res.physicalNexusRead().isPresent()) {
            System.out.println(res.physicalNexusRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           | Example                                                               |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `xOrganizationId`                                                     | *Optional\<String>*                                                   | :heavy_check_mark:                                                    | The unique identifier for the organization making the request         | org_12345                                                             |
| `physicalNexusCreate`                                                 | [PhysicalNexusCreate](../../models/components/PhysicalNexusCreate.md) | :heavy_check_mark:                                                    | N/A                                                                   |                                                                       |

### Response

**[CreatePhysicalNexusV1NexusPhysicalNexusPostResponse](../../models/operations/CreatePhysicalNexusV1NexusPhysicalNexusPostResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401                                                           | application/json                                              |
| models/errors/BackendSrcNexusResponsesValidationErrorResponse | 422                                                           | application/json                                              |
| models/errors/ErrorResponse                                   | 500                                                           | application/json                                              |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |

## getPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGet

Get physical nexus categories

### Example Usage

<!-- UsageSnippet language="java" operationID="get_physical_nexus_categories_v1_nexus_physical_nexus_categories_get" method="get" path="/v1/nexus/physical_nexus/categories" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGetResponse res = sdk.nexus().getPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGet()
                .xOrganizationId("org_12345")
                .call();

        if (res.responseGetPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGet().isPresent()) {
            System.out.println(res.responseGetPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGet().get());
        }
    }
}
```

### Parameters

| Parameter                                                                    | Type                                                                         | Required                                                                     | Description                                                                  | Example                                                                      |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `countryCode`                                                                | [JsonNullable\<CountryCodeEnum>](../../models/components/CountryCodeEnum.md) | :heavy_minus_sign:                                                           | N/A                                                                          |                                                                              |
| `stateCode`                                                                  | *JsonNullable\<String>*                                                      | :heavy_minus_sign:                                                           | N/A                                                                          |                                                                              |
| `xOrganizationId`                                                            | *Optional\<String>*                                                          | :heavy_check_mark:                                                           | The unique identifier for the organization making the request                | org_12345                                                                    |

### Response

**[GetPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGetResponse](../../models/operations/GetPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## deletePhysical

The Delete Physical Nexus API allows you to remove an existing
    physical nexus by its unique ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete_physical_nexus_v1_nexus_physical_nexus__physical_nexus_id__delete" method="delete" path="/v1/nexus/physical_nexus/{physical_nexus_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse res = sdk.nexus().deletePhysical()
                .physicalNexusId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.any().isPresent()) {
            System.out.println(res.any().get());
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `physicalNexusId`                                                                      | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier of the physical<br/>                                nexus to delete. |                                                                                        |
| `xOrganizationId`                                                                      | *Optional\<String>*                                                                    | :heavy_check_mark:                                                                     | The unique identifier for the organization making the request                          | org_12345                                                                              |

### Response

**[DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse](../../models/operations/DeletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDeleteResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401, 404                                                      | application/json                                              |
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
import com.kintsugi.taxplatform.models.components.PhysicalNexusCategory;
import com.kintsugi.taxplatform.models.components.PhysicalNexusUpdate;
import com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcNexusResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse res = sdk.nexus().updatePhysical()
                .physicalNexusId("<id>")
                .xOrganizationId("org_12345")
                .physicalNexusUpdate(PhysicalNexusUpdate.builder()
                    .startDate(LocalDate.parse("2024-01-01"))
                    .category(PhysicalNexusCategory.PHYSICAL_BUSINESS_LOCATION)
                    .endDate(LocalDate.parse("2025-01-01"))
                    .street1("123 Main Street")
                    .street2("Suite 100")
                    .city("San Francisco")
                    .postalCode("94102")
                    .build())
                .call();

        if (res.physicalNexusRead().isPresent()) {
            System.out.println(res.physicalNexusRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `physicalNexusId`                                                                      | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier of the physical<br/>                                nexus to update. |                                                                                        |
| `xOrganizationId`                                                                      | *Optional\<String>*                                                                    | :heavy_check_mark:                                                                     | The unique identifier for the organization making the request                          | org_12345                                                                              |
| `physicalNexusUpdate`                                                                  | [PhysicalNexusUpdate](../../models/components/PhysicalNexusUpdate.md)                  | :heavy_check_mark:                                                                     | N/A                                                                                    |                                                                                        |

### Response

**[UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse](../../models/operations/UpdatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPutResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/ErrorResponse                                   | 401, 404                                                      | application/json                                              |
| models/errors/BackendSrcNexusResponsesValidationErrorResponse | 422                                                           | application/json                                              |
| models/errors/ErrorResponse                                   | 500                                                           | application/json                                              |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |

## getNexusDetailsForIdV1NexusNexusIdGet

Get details for a specific nexus by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_nexus_details_for_id_v1_nexus__nexus_id__get" method="get" path="/v1/nexus/{nexus_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetNexusDetailsForIdV1NexusNexusIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetNexusDetailsForIdV1NexusNexusIdGetResponse res = sdk.nexus().getNexusDetailsForIdV1NexusNexusIdGet()
                .nexusId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.nexusResponse().isPresent()) {
            System.out.println(res.nexusResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `nexusId`                                                     | *String*                                                      | :heavy_check_mark:                                            | The unique identifier of the nexus.                           |                                                               |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetNexusDetailsForIdV1NexusNexusIdGetResponse](../../models/operations/GetNexusDetailsForIdV1NexusNexusIdGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |