# CustomersTransactions
(*customers().transactions()*)

## Overview

### Available Operations

* [getByCustomerId](#getbycustomerid) - Get Transactions By Customer Id

## getByCustomerId

Get a list of transactions for a customer by their unique ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_transactions_by_customer_id_v1_customers__customer_id__transactions_get" method="get" path="/v1/customers/{customer_id}/transactions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse res = sdk.customers().transactions().getByCustomerId()
                .customerId("<id>")
                .call();

        if (res.responseGetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter          | Type               | Required           | Description        |
| ------------------ | ------------------ | ------------------ | ------------------ |
| `customerId`       | *String*           | :heavy_check_mark: | N/A                |

### Response

**[GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse](../../models/operations/GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |