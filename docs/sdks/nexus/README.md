# Nexus
(*nexus()*)

## Overview

### Available Operations

* [list](#list) - Get Nexus For Org

## list

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

        GetNexusForOrgV1NexusGetResponse res = sdk.nexus().list()
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