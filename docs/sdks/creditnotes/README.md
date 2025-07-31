# CreditNotes
(*transactions().creditNotes()*)

## Overview

### Available Operations

* [create](#create) - Create Credit Note By Transaction Id

## create

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

        POSTCreateCreditNoteByTransactionIdResponse res = sdk.transactions().creditNotes().create()
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