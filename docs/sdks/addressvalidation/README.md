# AddressValidation
(*addressValidation()*)

## Overview

### Available Operations

* [search](#search) - Search
* [suggestions](#suggestions) - Suggestions

## search

This API validates and enriches address information
    submitted by the user. It ensures that the address is standardized, accurate,
    and compliant with geographical and postal standards.
    The API also adds additional fields, such as county, when possible.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        AddressBase req = AddressBase.builder()
                .phone("555-123-4567")
                .street1("1600 Amphitheatre Parkway")
                .street2("Building 40")
                .city("Mountain View")
                .county("Santa Clara")
                .state("CA")
                .postalCode("94043")
                .country(CountryCodeEnum.US)
                .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                .build();

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().search()
                .request(req)
                .security(SearchV1AddressValidationSearchPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                        | Type                                                                                                                                                             | Required                                                                                                                                                         | Description                                                                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                                        | [AddressBase](../../models/shared/AddressBase.md)                                                                                                                | :heavy_check_mark:                                                                                                                                               | The request object to use for the request.                                                                                                                       |
| `security`                                                                                                                                                       | [com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity](../../models/operations/SearchV1AddressValidationSearchPostSecurity.md) | :heavy_check_mark:                                                                                                                                               | The security requirements to use for the request.                                                                                                                |

### Response

**[SearchV1AddressValidationSearchPostResponse](../../models/operations/SearchV1AddressValidationSearchPostResponse.md)**

### Errors

| Error Type                                                                | Status Code                                                               | Content Type                                                              |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| models/errors/ErrorResponse                                               | 401                                                                       | application/json                                                          |
| models/errors/BackendSrcAddressValidationResponsesValidationErrorResponse | 422                                                                       | application/json                                                          |
| models/errors/ErrorResponse                                               | 500                                                                       | application/json                                                          |
| models/errors/APIException                                                | 4XX, 5XX                                                                  | \*/\*                                                                     |

## suggestions

This API endpoint provides address suggestions based on
    partial input data. It helps users auto-complete and validate addresses efficiently
    by returning a list of suggested addresses that match the input criteria.
    This improves accuracy, increases speed, reduces errors,
    and streamlines the data entry process.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.ValidationAddress;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SuggestionsV1AddressValidationSuggestionsPostResponse;
import com.kintsugi.taxplatform.models.operations.SuggestionsV1AddressValidationSuggestionsPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        SuggestionsV1AddressValidationSuggestionsPostResponse res = sdk.addressValidation().suggestions()
                .security(SuggestionsV1AddressValidationSuggestionsPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .xOrganizationId("org_12345")
                .validationAddress(ValidationAddress.builder()
                    .line1("1600 Amphitheatre Parkway")
                    .line2("")
                    .line3("")
                    .city("Mountain View")
                    .state("CA")
                    .country("US")
                    .postalCode("94043")
                    .id(215L)
                    .county("")
                    .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                            | Type                                                                                                                                                                                 | Required                                                                                                                                                                             | Description                                                                                                                                                                          | Example                                                                                                                                                                              |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                                           | [com.kintsugi.taxplatform.models.operations.SuggestionsV1AddressValidationSuggestionsPostSecurity](../../models/operations/SuggestionsV1AddressValidationSuggestionsPostSecurity.md) | :heavy_check_mark:                                                                                                                                                                   | The security requirements to use for the request.                                                                                                                                    |                                                                                                                                                                                      |
| `xOrganizationId`                                                                                                                                                                    | *Optional\<String>*                                                                                                                                                                  | :heavy_check_mark:                                                                                                                                                                   | The unique identifier for the organization making the request                                                                                                                        | org_12345                                                                                                                                                                            |
| `validationAddress`                                                                                                                                                                  | [ValidationAddress](../../models/components/ValidationAddress.md)                                                                                                                    | :heavy_check_mark:                                                                                                                                                                   | N/A                                                                                                                                                                                  |                                                                                                                                                                                      |

### Response

**[SuggestionsV1AddressValidationSuggestionsPostResponse](../../models/operations/SuggestionsV1AddressValidationSuggestionsPostResponse.md)**

### Errors

| Error Type                                                                | Status Code                                                               | Content Type                                                              |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| models/errors/ErrorResponse                                               | 401                                                                       | application/json                                                          |
| models/errors/BackendSrcAddressValidationResponsesValidationErrorResponse | 422                                                                       | application/json                                                          |
| models/errors/ErrorResponse                                               | 500                                                                       | application/json                                                          |
| models/errors/APIException                                                | 4XX, 5XX                                                                  | \*/\*                                                                     |