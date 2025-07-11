# Transactions
(*transactions()*)

## Overview

### Available Operations

* [list](#list) - Get Transactions
* [create](#create) - Create Transaction
* [getByExternalId](#getbyexternalid) - Get Transaction By External Id
* [update](#update) - Update Transaction
* [getById](#getbyid) - Get Transaction By Id
* [getByFilingId](#getbyfilingid) - Get Transactions By Filing Id
* [createCreditNote](#createcreditnote) - Create Credit Note By Transaction Id
* [updateCreditNote](#updatecreditnote) - Update Credit Note By Transaction Id

## list

The Get Transactions API retrieves a list of transactions with
    optional filtering, sorting, and pagination.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetTransactionsV1TransactionsGetRequest req = GetTransactionsV1TransactionsGetRequest.builder()
                .xOrganizationId("org_12345")
                .build();

        GetTransactionsV1TransactionsGetResponse res = sdk.transactions().list()
                .request(req)
                .security(GetTransactionsV1TransactionsGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.pageTransactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                  | Type                                                                                                                                                       | Required                                                                                                                                                   | Description                                                                                                                                                |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                                                  | [GetTransactionsV1TransactionsGetRequest](../../models/operations/GetTransactionsV1TransactionsGetRequest.md)                                              | :heavy_check_mark:                                                                                                                                         | The request object to use for the request.                                                                                                                 |
| `security`                                                                                                                                                 | [com.kintsugi.taxplatform.models.operations.GetTransactionsV1TransactionsGetSecurity](../../models/operations/GetTransactionsV1TransactionsGetSecurity.md) | :heavy_check_mark:                                                                                                                                         | The security requirements to use for the request.                                                                                                          |

### Response

**[GetTransactionsV1TransactionsGetResponse](../../models/operations/GetTransactionsV1TransactionsGetResponse.md)**

### Errors

| Error Type                                                           | Status Code                                                          | Content Type                                                         |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| models/errors/ErrorResponse                                          | 401, 404                                                             | application/json                                                     |
| models/errors/BackendSrcTransactionsResponsesValidationErrorResponse | 422                                                                  | application/json                                                     |
| models/errors/ErrorResponse                                          | 500                                                                  | application/json                                                     |
| models/errors/APIException                                           | 4XX, 5XX                                                             | \*/\*                                                                |

## create

Create a transaction.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateTransactionV1TransactionsPostResponse;
import com.kintsugi.taxplatform.models.operations.CreateTransactionV1TransactionsPostSecurity;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        CreateTransactionV1TransactionsPostResponse res = sdk.transactions().create()
                .security(CreateTransactionV1TransactionsPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .xOrganizationId("org_12345")
                .transactionPublicRequest(TransactionPublicRequest.builder()
                    .organizationId("orgn_YourOrgIdHere")
                    .externalId("YourUniqueOrder123")
                    .date(OffsetDateTime.parse("2024-01-15T14:30:00Z"))
                    .addresses(List.of(
                        TransactionAddressPublic.builder()
                            .type(AddressType.SHIP_TO)
                            .street1("123 Main St")
                            .city("San Francisco")
                            .state("CA")
                            .postalCode("94107")
                            .country(CountryCodeEnum.US)
                            .build()))
                    .transactionItems(List.of(
                        TransactionItemBuilder.builder()
                            .organizationId("orgn_YourOrgIdHere")
                            .date(OffsetDateTime.parse("2024-01-15T14:30:00Z"))
                            .externalProductId("SKU-ABC")
                            .product("Example Widget")
                            .quantity(TransactionItemBuilderQuantity.of(2d))
                            .amount(TransactionItemBuilderAmount.of(50d))
                            .build()))
                    .customer(Customer.of(TransactionImportCustomer.builder()
                        .externalId("Cust456")
                        .name("John Doe")
                        .organizationId("orgn_YourOrgIdHere")
                        .build()))
                    .type(TransactionTypeEnum.SALE)
                    .currency(CurrencyEnum.USD)
                    .source(SourceEnum.API)
                    .build())
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                        | Type                                                                                                                                                             | Required                                                                                                                                                         | Description                                                                                                                                                      | Example                                                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                       | [com.kintsugi.taxplatform.models.operations.CreateTransactionV1TransactionsPostSecurity](../../models/operations/CreateTransactionV1TransactionsPostSecurity.md) | :heavy_check_mark:                                                                                                                                               | The security requirements to use for the request.                                                                                                                |                                                                                                                                                                  |
| `xOrganizationId`                                                                                                                                                | *Optional\<String>*                                                                                                                                              | :heavy_check_mark:                                                                                                                                               | The unique identifier for the organization making the request                                                                                                    | org_12345                                                                                                                                                        |
| `transactionPublicRequest`                                                                                                                                       | [TransactionPublicRequest](../../models/components/TransactionPublicRequest.md)                                                                                  | :heavy_check_mark:                                                                                                                                               | N/A                                                                                                                                                              |                                                                                                                                                                  |

### Response

**[CreateTransactionV1TransactionsPostResponse](../../models/operations/CreateTransactionV1TransactionsPostResponse.md)**

### Errors

| Error Type                                                           | Status Code                                                          | Content Type                                                         |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| models/errors/ErrorResponse                                          | 400, 401                                                             | application/json                                                     |
| models/errors/BackendSrcTransactionsResponsesValidationErrorResponse | 422                                                                  | application/json                                                     |
| models/errors/ErrorResponse                                          | 500                                                                  | application/json                                                     |
| models/errors/APIException                                           | 4XX, 5XX                                                             | \*/\*                                                                |

## getByExternalId

Retrieves a specific transaction based on its external ID.
    This allows users to fetch transaction details using an identifier from an external system.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionByExternalIdV1TransactionsExternalExternalIdGetResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionByExternalIdV1TransactionsExternalExternalIdGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetTransactionByExternalIdV1TransactionsExternalExternalIdGetResponse res = sdk.transactions().getByExternalId()
                .security(GetTransactionByExternalIdV1TransactionsExternalExternalIdGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .externalId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                            | Type                                                                                                                                                                                                                 | Required                                                                                                                                                                                                             | Description                                                                                                                                                                                                          | Example                                                                                                                                                                                                              |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                                           | [com.kintsugi.taxplatform.models.operations.GetTransactionByExternalIdV1TransactionsExternalExternalIdGetSecurity](../../models/operations/GetTransactionByExternalIdV1TransactionsExternalExternalIdGetSecurity.md) | :heavy_check_mark:                                                                                                                                                                                                   | The security requirements to use for the request.                                                                                                                                                                    |                                                                                                                                                                                                                      |
| `externalId`                                                                                                                                                                                                         | *String*                                                                                                                                                                                                             | :heavy_check_mark:                                                                                                                                                                                                   | The unique external identifier of the transaction.                                                                                                                                                                   |                                                                                                                                                                                                                      |
| `xOrganizationId`                                                                                                                                                                                                    | *Optional\<String>*                                                                                                                                                                                                  | :heavy_check_mark:                                                                                                                                                                                                   | The unique identifier for the organization making the request                                                                                                                                                        | org_12345                                                                                                                                                                                                            |

### Response

**[GetTransactionByExternalIdV1TransactionsExternalExternalIdGetResponse](../../models/operations/GetTransactionByExternalIdV1TransactionsExternalExternalIdGetResponse.md)**

### Errors

| Error Type                                                           | Status Code                                                          | Content Type                                                         |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| models/errors/ErrorResponse                                          | 401, 404                                                             | application/json                                                     |
| models/errors/BackendSrcTransactionsResponsesValidationErrorResponse | 422                                                                  | application/json                                                     |
| models/errors/ErrorResponse                                          | 500                                                                  | application/json                                                     |
| models/errors/APIException                                           | 4XX, 5XX                                                             | \*/\*                                                                |

## update

Update a specific transaction by its ID.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.UpdateTransactionV1TransactionsTransactionIdPutResponse;
import com.kintsugi.taxplatform.models.operations.UpdateTransactionV1TransactionsTransactionIdPutSecurity;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
            .build();

        UpdateTransactionV1TransactionsTransactionIdPutResponse res = sdk.transactions().update()
                .security(UpdateTransactionV1TransactionsTransactionIdPutSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .transactionId("<id>")
                .xOrganizationId("org_12345")
                .transactionUpdate(TransactionUpdate.builder()
                    .organizationId("orgn_argaLQwMy2fJc")
                    .externalId("EXT12345")
                    .date(OffsetDateTime.parse("2025-04-02T17:36:59.814Z"))
                    .addresses(TransactionUpdateAddresses.ofTransactionAddressBuilder(List.of(
                        TransactionAddressBuilder.builder()
                            .type(AddressType.BILL_TO)
                            .build())))
                    .transactionItems(List.of(
                        TransactionItemCreateUpdate.builder()
                            .organizationId("orgn_argaLQwMy2fJc")
                            .date(OffsetDateTime.parse("2025-04-02T17:36:59.814Z"))
                            .externalProductId("1186DUMMYITEM")
                            .build()))
                    .customer(CustomerUpdate.builder()
                        .build())
                    .build())
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                | Type                                                                                                                                                                                     | Required                                                                                                                                                                                 | Description                                                                                                                                                                              | Example                                                                                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                               | [com.kintsugi.taxplatform.models.operations.UpdateTransactionV1TransactionsTransactionIdPutSecurity](../../models/operations/UpdateTransactionV1TransactionsTransactionIdPutSecurity.md) | :heavy_check_mark:                                                                                                                                                                       | The security requirements to use for the request.                                                                                                                                        |                                                                                                                                                                                          |
| `transactionId`                                                                                                                                                                          | *String*                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                       | N/A                                                                                                                                                                                      |                                                                                                                                                                                          |
| `xOrganizationId`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                      | :heavy_check_mark:                                                                                                                                                                       | The unique identifier for the organization making the request                                                                                                                            | org_12345                                                                                                                                                                                |
| `transactionUpdate`                                                                                                                                                                      | [TransactionUpdate](../../models/components/TransactionUpdate.md)                                                                                                                        | :heavy_check_mark:                                                                                                                                                                       | N/A                                                                                                                                                                                      |                                                                                                                                                                                          |

### Response

**[UpdateTransactionV1TransactionsTransactionIdPutResponse](../../models/operations/UpdateTransactionV1TransactionsTransactionIdPutResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## getById

The Get Transaction By Id API retrieves detailed information
    about a specific transaction by providing its unique transaction ID.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionByIdV1TransactionsTransactionIdGetResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionByIdV1TransactionsTransactionIdGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetTransactionByIdV1TransactionsTransactionIdGetResponse res = sdk.transactions().getById()
                .security(GetTransactionByIdV1TransactionsTransactionIdGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .transactionId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                  | Type                                                                                                                                                                                       | Required                                                                                                                                                                                   | Description                                                                                                                                                                                | Example                                                                                                                                                                                    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                                                 | [com.kintsugi.taxplatform.models.operations.GetTransactionByIdV1TransactionsTransactionIdGetSecurity](../../models/operations/GetTransactionByIdV1TransactionsTransactionIdGetSecurity.md) | :heavy_check_mark:                                                                                                                                                                         | The security requirements to use for the request.                                                                                                                                          |                                                                                                                                                                                            |
| `transactionId`                                                                                                                                                                            | *String*                                                                                                                                                                                   | :heavy_check_mark:                                                                                                                                                                         | The unique identifier of the transaction to retrieve.                                                                                                                                      |                                                                                                                                                                                            |
| `xOrganizationId`                                                                                                                                                                          | *Optional\<String>*                                                                                                                                                                        | :heavy_check_mark:                                                                                                                                                                         | The unique identifier for the organization making the request                                                                                                                              | org_12345                                                                                                                                                                                  |

### Response

**[GetTransactionByIdV1TransactionsTransactionIdGetResponse](../../models/operations/GetTransactionByIdV1TransactionsTransactionIdGetResponse.md)**

### Errors

| Error Type                                                           | Status Code                                                          | Content Type                                                         |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| models/errors/ErrorResponse                                          | 401, 404                                                             | application/json                                                     |
| models/errors/BackendSrcTransactionsResponsesValidationErrorResponse | 422                                                                  | application/json                                                     |
| models/errors/ErrorResponse                                          | 500                                                                  | application/json                                                     |
| models/errors/APIException                                           | 4XX, 5XX                                                             | \*/\*                                                                |

## getByFilingId

Retrieve transactions by filing ID.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse res = sdk.transactions().getByFilingId()
                .security(GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .filingId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.response200GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                    | Type                                                                                                                                                                                                         | Required                                                                                                                                                                                                     | Description                                                                                                                                                                                                  | Example                                                                                                                                                                                                      |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                                                                   | [com.kintsugi.taxplatform.models.operations.GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetSecurity](../../models/operations/GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetSecurity.md) | :heavy_check_mark:                                                                                                                                                                                           | The security requirements to use for the request.                                                                                                                                                            |                                                                                                                                                                                                              |
| `filingId`                                                                                                                                                                                                   | *String*                                                                                                                                                                                                     | :heavy_check_mark:                                                                                                                                                                                           | The unique identifier of the filing<br/>        whose transactions you wish to retrieve.<br/>                                                                                                                |                                                                                                                                                                                                              |
| `xOrganizationId`                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                          | :heavy_check_mark:                                                                                                                                                                                           | The unique identifier for the organization making the request                                                                                                                                                | org_12345                                                                                                                                                                                                    |

### Response

**[GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse](../../models/operations/GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse.md)**

### Errors

| Error Type                                                           | Status Code                                                          | Content Type                                                         |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| models/errors/ErrorResponse                                          | 401                                                                  | application/json                                                     |
| models/errors/BackendSrcTransactionsResponsesValidationErrorResponse | 422                                                                  | application/json                                                     |
| models/errors/ErrorResponse                                          | 500                                                                  | application/json                                                     |
| models/errors/APIException                                           | 4XX, 5XX                                                             | \*/\*                                                                |

## createCreditNote

Create a new credit note for a specific transaction.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostResponse;
import com.kintsugi.taxplatform.models.operations.CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostSecurity;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
            .build();

        CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostResponse res = sdk.transactions().createCreditNote()
                .security(CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .originalTransactionId("<id>")
                .xOrganizationId("org_12345")
                .creditNoteCreate(CreditNoteCreate.builder()
                    .externalId("CN-12345")
                    .date(OffsetDateTime.parse("2024-10-27T14:30:00Z"))
                    .status(Status.PENDING)
                    .currency(CurrencyEnum.USD)
                    .transactionItems(List.of(
                        CreditNoteItemCreateUpdate.builder()
                            .externalId("ITEM-1")
                            .date(OffsetDateTime.parse("2024-10-27T14:30:00Z"))
                            .externalProductId("PROD-ABC")
                            .quantity(CreditNoteItemCreateUpdateQuantity.of(1d))
                            .amount(CreditNoteItemCreateUpdateAmount.of(50d))
                            .build()))
                    .description("Refund for damaged product")
                    .totalAmount(CreditNoteCreateTotalAmount.of(50d))
                    .build())
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                    | Type                                                                                                                                                                                                                                                         | Required                                                                                                                                                                                                                                                     | Description                                                                                                                                                                                                                                                  | Example                                                                                                                                                                                                                                                      |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                                                                                                                   | [com.kintsugi.taxplatform.models.operations.CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostSecurity](../../models/operations/CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostSecurity.md) | :heavy_check_mark:                                                                                                                                                                                                                                           | The security requirements to use for the request.                                                                                                                                                                                                            |                                                                                                                                                                                                                                                              |
| `originalTransactionId`                                                                                                                                                                                                                                      | *String*                                                                                                                                                                                                                                                     | :heavy_check_mark:                                                                                                                                                                                                                                           | N/A                                                                                                                                                                                                                                                          |                                                                                                                                                                                                                                                              |
| `xOrganizationId`                                                                                                                                                                                                                                            | *Optional\<String>*                                                                                                                                                                                                                                          | :heavy_check_mark:                                                                                                                                                                                                                                           | The unique identifier for the organization making the request                                                                                                                                                                                                | org_12345                                                                                                                                                                                                                                                    |
| `creditNoteCreate`                                                                                                                                                                                                                                           | [CreditNoteCreate](../../models/components/CreditNoteCreate.md)                                                                                                                                                                                              | :heavy_check_mark:                                                                                                                                                                                                                                           | N/A                                                                                                                                                                                                                                                          |                                                                                                                                                                                                                                                              |

### Response

**[CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostResponse](../../models/operations/CreateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesPostResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## updateCreditNote

Update an existing credit note for a specific transaction.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutResponse;
import com.kintsugi.taxplatform.models.operations.UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutSecurity;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
            .build();

        UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutResponse res = sdk.transactions().updateCreditNote()
                .security(UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .originalTransactionId("<id>")
                .creditNoteId("<id>")
                .xOrganizationId("org_12345")
                .creditNoteCreate(CreditNoteCreate.builder()
                    .externalId("<id>")
                    .date(OffsetDateTime.parse("2023-04-03T14:25:55.241Z"))
                    .status(Status.PENDING)
                    .currency(CurrencyEnum.JOD)
                    .transactionItems(List.of(
                        CreditNoteItemCreateUpdate.builder()
                            .externalId("<id>")
                            .date(OffsetDateTime.parse("2024-04-29T01:52:56.740Z"))
                            .externalProductId("<id>")
                            .build()))
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                          | Type                                                                                                                                                                                                                                                                               | Required                                                                                                                                                                                                                                                                           | Description                                                                                                                                                                                                                                                                        | Example                                                                                                                                                                                                                                                                            |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                                                                                                         | [com.kintsugi.taxplatform.models.operations.UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutSecurity](../../models/operations/UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutSecurity.md) | :heavy_check_mark:                                                                                                                                                                                                                                                                 | The security requirements to use for the request.                                                                                                                                                                                                                                  |                                                                                                                                                                                                                                                                                    |
| `originalTransactionId`                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                           | :heavy_check_mark:                                                                                                                                                                                                                                                                 | N/A                                                                                                                                                                                                                                                                                |                                                                                                                                                                                                                                                                                    |
| `creditNoteId`                                                                                                                                                                                                                                                                     | *String*                                                                                                                                                                                                                                                                           | :heavy_check_mark:                                                                                                                                                                                                                                                                 | N/A                                                                                                                                                                                                                                                                                |                                                                                                                                                                                                                                                                                    |
| `xOrganizationId`                                                                                                                                                                                                                                                                  | *Optional\<String>*                                                                                                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                                                                                                                 | The unique identifier for the organization making the request                                                                                                                                                                                                                      | org_12345                                                                                                                                                                                                                                                                          |
| `creditNoteCreate`                                                                                                                                                                                                                                                                 | [CreditNoteCreate](../../models/components/CreditNoteCreate.md)                                                                                                                                                                                                                    | :heavy_check_mark:                                                                                                                                                                                                                                                                 | N/A                                                                                                                                                                                                                                                                                |                                                                                                                                                                                                                                                                                    |

### Response

**[UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutResponse](../../models/operations/UpdateCreditNoteByTransactionIdV1TransactionsOriginalTransactionIdCreditNotesCreditNoteIdPutResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |