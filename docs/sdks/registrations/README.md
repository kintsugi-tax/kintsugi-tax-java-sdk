# Registrations
(*registrations()*)

## Overview

### Available Operations

* [getRegistrationsV1RegistrationsGet](#getregistrationsv1registrationsget) - Get Registrations
* [createRegistrationV1RegistrationsPost](#createregistrationv1registrationspost) - Create Registration
* [getRegistrationByIdV1RegistrationsRegistrationIdGet](#getregistrationbyidv1registrationsregistrationidget) - Get Registration By Id
* [updateRegistrationV1RegistrationsRegistrationIdPut](#updateregistrationv1registrationsregistrationidput) - Update Registration
* [deregisterRegistrationV1RegistrationsRegistrationIdDeregisterPost](#deregisterregistrationv1registrationsregistrationidderegisterpost) - Deregister Registration

## getRegistrationsV1RegistrationsGet

The Get Registrations API retrieves a
    paginated list of registrations.
    This API helps in tracking and managing registrations efficiently across multiple
    jurisdictions.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_registrations_v1_registrations_get" method="get" path="/v1/registrations" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetRegistrationsV1RegistrationsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetRegistrationsV1RegistrationsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetRegistrationsV1RegistrationsGetRequest req = GetRegistrationsV1RegistrationsGetRequest.builder()
                .build();

        GetRegistrationsV1RegistrationsGetResponse res = sdk.registrations().getRegistrationsV1RegistrationsGet()
                .request(req)
                .call();

        if (res.pageRegistrationReadWithPassword().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                         | [GetRegistrationsV1RegistrationsGetRequest](../../models/operations/GetRegistrationsV1RegistrationsGetRequest.md) | :heavy_check_mark:                                                                                                | The request object to use for the request.                                                                        |

### Response

**[GetRegistrationsV1RegistrationsGetResponse](../../models/operations/GetRegistrationsV1RegistrationsGetResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401, 404                                                              | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## createRegistrationV1RegistrationsPost

The Create Registration API allows users to create a new registration
    for tracking and managing tax filings efficiently across multiple jurisdictions.

### Example Usage

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.OSSRegistrationCreatePayload;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        CreateRegistration req = OSSRegistrationCreatePayload.builder()
                .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().createRegistrationV1RegistrationsPost()
                .request(req)
                .call();

        if (res.registrationRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [CreateRegistration](../../models/operations/CreateRegistration.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[CreateRegistrationV1RegistrationsPostResponse](../../models/operations/CreateRegistrationV1RegistrationsPostResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401, 409                                                              | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## getRegistrationByIdV1RegistrationsRegistrationIdGet

The Get Registration By ID API retrieves a single registration record
    based on its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_registration_by_id_v1_registrations__registration_id__get" method="get" path="/v1/registrations/{registration_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse res = sdk.registrations().getRegistrationByIdV1RegistrationsRegistrationIdGet()
                .registrationId("<id>")
                .call();

        if (res.registrationRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `registrationId`                                                                       | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier of the<br/>                                registration to retrieve. |

### Response

**[GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse](../../models/operations/GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## updateRegistrationV1RegistrationsRegistrationIdPut

The Update Registration API allows you to modify
    an existing registration using its unique registration_id.

### Example Usage

<!-- UsageSnippet language="java" operationID="update_registration_v1_registrations__registration_id__put" method="put" path="/v1/registrations/{registration_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UpdateRegistrationV1RegistrationsRegistrationIdPutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        UpdateRegistrationV1RegistrationsRegistrationIdPutResponse res = sdk.registrations().updateRegistrationV1RegistrationsRegistrationIdPut()
                .registrationId("<id>")
                .registrationUpdateAPI(RegistrationUpdateAPI.builder()
                    .registrationDate("2025-03-01")
                    .registrationEmail("example@domain.com")
                    .registrationKey("REG-123456")
                    .registrationRequested("2025-02-18T19:43:32.684802")
                    .autoRegistered(true)
                    .registrationsRegime(RegistrationsRegimeEnum.STANDARD)
                    .changeRegimeStatus(ChangeRegimeStatusEnum.REQUESTED)
                    .username("User Name")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .createFilingsFrom("2025-03-01")
                    .isApproaching(false)
                    .comment("Updated registration for compliance")
                    .vda(false)
                    .build())
                .call();

        if (res.registrationRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `registrationId`                                                          | *String*                                                                  | :heavy_check_mark:                                                        | The unique identifier of the registration to be updated.                  |
| `registrationUpdateAPI`                                                   | [RegistrationUpdateAPI](../../models/components/RegistrationUpdateAPI.md) | :heavy_check_mark:                                                        | N/A                                                                       |

### Response

**[UpdateRegistrationV1RegistrationsRegistrationIdPutResponse](../../models/operations/UpdateRegistrationV1RegistrationsRegistrationIdPutResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## deregisterRegistrationV1RegistrationsRegistrationIdDeregisterPost

Deregister an existing registration.

### Example Usage

<!-- UsageSnippet language="java" operationID="deregister_registration_v1_registrations__registration_id__deregister_post" method="post" path="/v1/registrations/{registration_id}/deregister" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse res = sdk.registrations().deregisterRegistrationV1RegistrationsRegistrationIdDeregisterPost()
                .registrationId("regs_123456")
                .call();

        if (res.registrationRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                | Type                                                     | Required                                                 | Description                                              | Example                                                  |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `registrationId`                                         | *String*                                                 | :heavy_check_mark:                                       | The unique identifier of the registration to deregister. | regs_123456                                              |

### Response

**[DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse](../../models/operations/DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |