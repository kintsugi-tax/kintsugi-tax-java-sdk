# Customers.Transactions

## Overview

### Available Operations

* [getByCustomerId](#getbycustomerid) - Get transactions by customer id

## getByCustomerId

Get a list of transactions for a customer by their unique ID. When pagination params are provided, this endpoint returns a paginated response. When omitted, it returns the legacy list response format (deprecated).

### Example Usage

<!-- UsageSnippet language="java" operationID="get_transactions_by_customer_id_v1_customers__customer_id__transactions_get" method="get" path="/v1/customers/{customer_id}/transactions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.PageTransactionRead;
import com.kintsugi.taxplatform.models.components.TransactionRead;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse;
import com.kintsugi.taxplatform.models.operations.ResponseGetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGet;
import java.lang.Exception;
import java.lang.Object;
import java.util.List;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse res = sdk.customers().transactions().getByCustomerId()
                .customerId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.responseGetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGet().isPresent()) {
            ResponseGetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGet unionValue = res.responseGetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGet().get();
            Object raw = unionValue.value();
            if (raw instanceof List) {
                List<TransactionRead> arrayOfTransactionReadValue = (List<TransactionRead>) raw;
                // Handle arrayOfTransactionRead variant
            } else if (raw instanceof PageTransactionRead) {
                PageTransactionRead pageTransactionReadValue = (PageTransactionRead) raw;
                // Handle pageTransactionRead variant
            } else {
                // Unknown or unsupported variant
            }
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `customerId`                                                  | *String*                                                      | :heavy_check_mark:                                            | N/A                                                           |                                                               |
| `page`                                                        | *JsonNullable\<Long>*                                         | :heavy_minus_sign:                                            | N/A                                                           |                                                               |
| `size`                                                        | *JsonNullable\<Long>*                                         | :heavy_minus_sign:                                            | N/A                                                           |                                                               |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse](../../models/operations/GetTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |