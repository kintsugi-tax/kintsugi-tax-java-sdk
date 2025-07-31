# Customers
(*customers()*)

## Overview

### Available Operations

* [get](#get) - Get Customers
* [create](#create) - Create Customer
* [getById](#getbyid) - Get Customer By Id
* [update](#update) - Update Customer
* [getByExternalId](#getbyexternalid) - Get Customer By External Id
* [createTransaction](#createtransaction) - Create Transaction By Customer Id

## get

The Get Customers API retrieves
    a paginated list of customers based on specified filters.
    This API allows searching, filtering by country and state, and sorting the results.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_customers_v1" method="get" path="/v1/customers" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcCustomersResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetCustomersV1Request;
import com.kintsugi.taxplatform.models.operations.GetCustomersV1Response;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcCustomersResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetCustomersV1Request req = GetCustomersV1Request.builder()
                .searchQuery("John")
                .country(List.of(
                    ,))
                .state("CA")
                .sourceIn("SHOPIFY,API")
                .orderBy("created_at,street_1,street_2,city,state,postal_code,country,status")
                .build();

        GetCustomersV1Response res = sdk.customers().get()
                .request(req)
                .call();

        if (res.pageCustomerRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetCustomersV1Request](../../models/operations/GetCustomersV1Request.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[GetCustomersV1Response](../../models/operations/GetCustomersV1Response.md)**

### Errors

| Error Type                                                        | Status Code                                                       | Content Type                                                      |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| models/errors/ErrorResponse                                       | 401, 404                                                          | application/json                                                  |
| models/errors/BackendSrcCustomersResponsesValidationErrorResponse | 422                                                               | application/json                                                  |
| models/errors/ErrorResponse                                       | 500                                                               | application/json                                                  |
| models/errors/APIException                                        | 4XX, 5XX                                                          | \*/\*                                                             |

## create

The Create Customer API enables the creation of a new customer record with essential
details like name, contact information, and address, along with optional metadata.

### Example Usage

<!-- UsageSnippet language="java" operationID="create_customer_v1_customers_post" method="post" path="/v1/customers" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcCustomersResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateCustomerV1CustomersPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcCustomersResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        CustomerCreate req = CustomerCreate.builder()
                .phone("987-654-3210")
                .street1("456 Elm St")
                .street2("Suite 202")
                .city("Metropolis")
                .county("Wayne")
                .state("NY")
                .postalCode("10001")
                .country(CountryCodeEnum.US)
                .name("Jane Smith")
                .externalId("cust_002")
                .status(StatusEnum.ARCHIVED)
                .email("jane.smith@example.com")
                .source(SourceEnum.SHOPIFY)
                .addressStatus(AddressStatus.PARTIALLY_VERIFIED)
                .build();

        CreateCustomerV1CustomersPostResponse res = sdk.customers().create()
                .request(req)
                .call();

        if (res.customerRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [CustomerCreate](../../models/shared/CustomerCreate.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[CreateCustomerV1CustomersPostResponse](../../models/operations/CreateCustomerV1CustomersPostResponse.md)**

### Errors

| Error Type                                                        | Status Code                                                       | Content Type                                                      |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| models/errors/ErrorResponse                                       | 401, 404                                                          | application/json                                                  |
| models/errors/BackendSrcCustomersResponsesValidationErrorResponse | 422                                                               | application/json                                                  |
| models/errors/ErrorResponse                                       | 500                                                               | application/json                                                  |
| models/errors/APIException                                        | 4XX, 5XX                                                          | \*/\*                                                             |

## getById

The Get Customer By ID API retrieves the details of a single customer
    using their unique identifier. It returns customer-specific data,
    including contact information, address, name and metadata, etc.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_customer_by_id_v1_customers__customer_id__get" method="get" path="/v1/customers/{customer_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetCustomerByIdV1CustomersCustomerIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetCustomerByIdV1CustomersCustomerIdGetResponse res = sdk.customers().getById()
                .customerId("cust_abc123")
                .call();

        if (res.customerRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       | Example                           |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `customerId`                      | *String*                          | :heavy_check_mark:                | Unique identifier of the customer | cust_abc123                       |

### Response

**[GetCustomerByIdV1CustomersCustomerIdGetResponse](../../models/operations/GetCustomerByIdV1CustomersCustomerIdGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## update

The Update Customer API allows you to modify an existing customer's
    information using their unique identifier,
    enabling updates to their details as needed.

### Example Usage

<!-- UsageSnippet language="java" operationID="update_customer_v1_customers__customer_id__put" method="put" path="/v1/customers/{customer_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcCustomersResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UpdateCustomerV1CustomersCustomerIdPutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcCustomersResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        UpdateCustomerV1CustomersCustomerIdPutResponse res = sdk.customers().update()
                .customerId("<id>")
                .customerUpdate(CustomerUpdate.builder()
                    .phone("987-654-3210")
                    .street1("456 Elm St")
                    .street2("Suite 202")
                    .city("Metropolis")
                    .county("Wayne")
                    .state("NY")
                    .postalCode("10001")
                    .country(CountryCodeEnum.US)
                    .fullAddress("456 Elm St, Suite 202, Metropolis, NY 10001, US")
                    .name("Jane Smith")
                    .status(StatusEnum.ACTIVE)
                    .email("john.doe@example.com")
                    .source(SourceEnum.SHOPIFY)
                    .addressStatus(AddressStatus.VERIFIED)
                    .externalId("cust_002")
                    .build())
                .call();

        if (res.customerRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `customerId`                                                | *String*                                                    | :heavy_check_mark:                                          | Unique identifier of the customer to be retrieved.          |
| `customerUpdate`                                            | [CustomerUpdate](../../models/components/CustomerUpdate.md) | :heavy_check_mark:                                          | N/A                                                         |

### Response

**[UpdateCustomerV1CustomersCustomerIdPutResponse](../../models/operations/UpdateCustomerV1CustomersCustomerIdPutResponse.md)**

### Errors

| Error Type                                                        | Status Code                                                       | Content Type                                                      |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| models/errors/ErrorResponse                                       | 401, 404                                                          | application/json                                                  |
| models/errors/BackendSrcCustomersResponsesValidationErrorResponse | 422                                                               | application/json                                                  |
| models/errors/ErrorResponse                                       | 500                                                               | application/json                                                  |
| models/errors/APIException                                        | 4XX, 5XX                                                          | \*/\*                                                             |

## getByExternalId

The Get Customer By External ID API retrieves the details of a single customer using
their external identifier. This endpoint is useful for accessing customer data when only
an external ID is available.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_customer_by_external_id_v1_customers_external__external_id__get" method="get" path="/v1/customers/external/{external_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetCustomerByExternalIdV1CustomersExternalExternalIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetCustomerByExternalIdV1CustomersExternalExternalIdGetResponse res = sdk.customers().getByExternalId()
                .externalId("external_12345")
                .call();

        if (res.customerRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                            | Type                                                 | Required                                             | Description                                          | Example                                              |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| `externalId`                                         | *String*                                             | :heavy_check_mark:                                   | The external identifier of the customer to retrieve. | external_12345                                       |

### Response

**[GetCustomerByExternalIdV1CustomersExternalExternalIdGetResponse](../../models/operations/GetCustomerByExternalIdV1CustomersExternalExternalIdGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## createTransaction

Create a new transaction for a specific customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="create_transaction_by_customer_id_v1_customers__customer_id__transactions_post" method="post" path="/v1/customers/{customer_id}/transactions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.CreateTransactionByCustomerIdV1CustomersCustomerIdTransactionsPostResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        CreateTransactionByCustomerIdV1CustomersCustomerIdTransactionsPostResponse res = sdk.customers().createTransaction()
                .customerId("<id>")
                .transactionCreate(TransactionCreate.builder()
                    .organizationId("<id>")
                    .externalId("<id>")
                    .date(OffsetDateTime.parse("2023-02-16T04:36:50.697Z"))
                    .addresses(List.of())
                    .transactionItems(List.of(
                        TransactionItemCreateUpdate.builder()
                            .organizationId("<id>")
                            .date(OffsetDateTime.parse("2024-05-13T04:49:24.946Z"))
                            .externalProductId("<id>")
                            .quantity(1d)
                            .amount(0d)
                            .taxAmountImported(0d)
                            .taxRateImported(0d)
                            .taxAmountCalculated(0d)
                            .taxRateCalculated(0d)
                            .taxableAmount(0d)
                            .build()))
                    .totalAmount(0d)
                    .totalTaxAmountImported(0d)
                    .taxRateImported(0d)
                    .totalTaxAmountCalculated(0d)
                    .taxRateCalculated(0d)
                    .totalTaxLiabilityAmount(0d)
                    .taxableAmount(0d)
                    .build())
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `customerId`                                                      | *String*                                                          | :heavy_check_mark:                                                | N/A                                                               |
| `transactionCreate`                                               | [TransactionCreate](../../models/components/TransactionCreate.md) | :heavy_check_mark:                                                | N/A                                                               |

### Response

**[CreateTransactionByCustomerIdV1CustomersCustomerIdTransactionsPostResponse](../../models/operations/CreateTransactionByCustomerIdV1CustomersCustomerIdTransactionsPostResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |