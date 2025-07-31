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

<!-- UsageSnippet language="java" operationID="get_transactions_v1_transactions_get" method="get" path="/v1/transactions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionsV1TransactionsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetTransactionsV1TransactionsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetTransactionsV1TransactionsGetRequest req = GetTransactionsV1TransactionsGetRequest.builder()
                .build();

        GetTransactionsV1TransactionsGetResponse res = sdk.transactions().list()
                .request(req)
                .call();

        if (res.pageTransactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                     | [GetTransactionsV1TransactionsGetRequest](../../models/operations/GetTransactionsV1TransactionsGetRequest.md) | :heavy_check_mark:                                                                                            | The request object to use for the request.                                                                    |

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

<!-- UsageSnippet language="java" operationID="create_transaction_v1_transactions_post" method="post" path="/v1/transactions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateTransactionV1TransactionsPostResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        TransactionPublicRequest req = TransactionPublicRequest.builder()
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
                        .quantity(2d)
                        .amount(50d)
                        .build()))
                .customer(CustomerBaseBase.builder()
                    .organizationId("orgn_YourOrgIdHere")
                    .name("John Doe")
                    .externalId("Cust456")
                    .build())
                .type(TransactionTypeEnum.SALE)
                .currency(CurrencyEnum.USD)
                .source(SourceEnum.API)
                .build();

        CreateTransactionV1TransactionsPostResponse res = sdk.transactions().create()
                .request(req)
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [TransactionPublicRequest](../../models/shared/TransactionPublicRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

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

<!-- UsageSnippet language="java" operationID="get_transaction_by_external_id_v1_transactions_external__external_id__get" method="get" path="/v1/transactions/external/{external_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionByExternalIdV1TransactionsExternalExternalIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetTransactionByExternalIdV1TransactionsExternalExternalIdGetResponse res = sdk.transactions().getByExternalId()
                .externalId("<id>")
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `externalId`                                       | *String*                                           | :heavy_check_mark:                                 | The unique external identifier of the transaction. |

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

<!-- UsageSnippet language="java" operationID="update_transaction_v1_transactions__transaction_id__put" method="put" path="/v1/transactions/{transaction_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.UpdateTransactionV1TransactionsTransactionIdPutResponse;
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

        UpdateTransactionV1TransactionsTransactionIdPutResponse res = sdk.transactions().update()
                .transactionId("<id>")
                .transactionUpdate(TransactionUpdate.builder()
                    .organizationId("orgn_argaLQwMy2fJc")
                    .externalId("EXT12345")
                    .date(OffsetDateTime.parse("2025-04-02T17:36:59.814Z"))
                    .addresses(List.of(
                        TransactionAddressBuilder.builder()
                            .type(AddressType.BILL_TO)
                            .build()))
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

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `transactionId`                                                   | *String*                                                          | :heavy_check_mark:                                                | N/A                                                               |
| `transactionUpdate`                                               | [TransactionUpdate](../../models/components/TransactionUpdate.md) | :heavy_check_mark:                                                | N/A                                                               |

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

<!-- UsageSnippet language="java" operationID="get_transaction_by_id_v1_transactions__transaction_id__get" method="get" path="/v1/transactions/{transaction_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionByIdV1TransactionsTransactionIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetTransactionByIdV1TransactionsTransactionIdGetResponse res = sdk.transactions().getById()
                .transactionId("<id>")
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `transactionId`                                       | *String*                                              | :heavy_check_mark:                                    | The unique identifier of the transaction to retrieve. |

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

<!-- UsageSnippet language="java" operationID="get_transactions_by_filing_id_v1_transactions_filings__filing_id__get" method="get" path="/v1/transactions/filings/{filing_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTransactionsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGetResponse res = sdk.transactions().getByFilingId()
                .filingId("<id>")
                .call();

        if (res.response200GetTransactionsByFilingIdV1TransactionsFilingsFilingIdGet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `filingId`                                                                                    | *String*                                                                                      | :heavy_check_mark:                                                                            | The unique identifier of the filing<br/>        whose transactions you wish to retrieve.<br/>         |

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

<!-- UsageSnippet language="java" operationID="POST_create_credit_note_by_transaction_id" method="post" path="/v1/transactions/{original_transaction_id}/credit_notes" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.POSTCreateCreditNoteByTransactionIdResponse;
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

        POSTCreateCreditNoteByTransactionIdResponse res = sdk.transactions().createCreditNote()
                .originalTransactionId("<id>")
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
                            .quantity(1d)
                            .amount(50d)
                            .build()))
                    .description("Refund for damaged product")
                    .totalAmount(50d)
                    .build())
                .call();

        if (res.transactionRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `originalTransactionId`                                         | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |
| `creditNoteCreate`                                              | [CreditNoteCreate](../../models/components/CreditNoteCreate.md) | :heavy_check_mark:                                              | N/A                                                             |

### Response

**[POSTCreateCreditNoteByTransactionIdResponse](../../models/operations/POSTCreateCreditNoteByTransactionIdResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## updateCreditNote

Update an existing credit note for a specific transaction.

### Example Usage

<!-- UsageSnippet language="java" operationID="PUT_update_credit_note_by_transaction_id" method="put" path="/v1/transactions/{original_transaction_id}/credit_notes/{credit_note_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.PUTUpdateCreditNoteByTransactionIdResponse;
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

        PUTUpdateCreditNoteByTransactionIdResponse res = sdk.transactions().updateCreditNote()
                .originalTransactionId("<id>")
                .creditNoteId("<id>")
                .creditNoteCreate(CreditNoteCreate.builder()
                    .externalId("<id>")
                    .date(OffsetDateTime.parse("2023-07-25T11:01:44.924Z"))
                    .status(Status.CANCELLED)
                    .currency(CurrencyEnum.SPL)
                    .transactionItems(List.of(
                        CreditNoteItemCreateUpdate.builder()
                            .externalId("<id>")
                            .date(OffsetDateTime.parse("2024-09-15T23:01:02.880Z"))
                            .externalProductId("<id>")
                            .quantity(1d)
                            .amount(0d)
                            .build()))
                    .totalAmount(0d)
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `originalTransactionId`                                         | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |
| `creditNoteId`                                                  | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |
| `creditNoteCreate`                                              | [CreditNoteCreate](../../models/components/CreditNoteCreate.md) | :heavy_check_mark:                                              | N/A                                                             |

### Response

**[PUTUpdateCreditNoteByTransactionIdResponse](../../models/operations/PUTUpdateCreditNoteByTransactionIdResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |