# TaxEstimation
(*taxEstimation()*)

## Overview

### Available Operations

* [estimateTaxV1TaxEstimatePost](#estimatetaxv1taxestimatepost) - Estimate Tax

## estimateTaxV1TaxEstimatePost

The Estimate Tax API calculates the estimated tax for a specific
    transaction based on the provided details, including organization nexus,
    transaction details, customer details, and addresses. Optionally simulates nexus being met for tax calculation purposes. The `simulate_nexus_met` parameter is deprecated and will be removed in future releases.

### Example Usage

<!-- UsageSnippet language="java" operationID="estimate_tax_v1_tax_estimate_post" method="post" path="/v1/tax/estimate" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcTaxEstimationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.EstimateTaxV1TaxEstimatePostResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTaxEstimationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        EstimateTaxV1TaxEstimatePostResponse res = sdk.taxEstimation().estimateTaxV1TaxEstimatePost()
                .transactionEstimatePublicRequest(TransactionEstimatePublicRequest.builder()
                    .date(OffsetDateTime.parse("2025-01-23T13:01:29.949Z"))
                    .externalId("txn_12345")
                    .currency(CurrencyEnum.USD)
                    .transactionItems(List.of(
                        TransactionItemEstimateBase.builder()
                            .date(OffsetDateTime.parse("2024-10-28T10:00:00Z"))
                            .amount(100d)
                            .externalId("item_A")
                            .externalProductId("prod_abc")
                            .quantity(2d)
                            .build(),
                        TransactionItemEstimateBase.builder()
                            .date(OffsetDateTime.parse("2024-10-28T10:00:00Z"))
                            .amount(75.5)
                            .externalId("item_B")
                            .externalProductId("prod_xyz")
                            .quantity(1d)
                            .build()))
                    .addresses(List.of(
                        TransactionEstimatePublicRequestAddress.builder()
                            .type(TransactionEstimatePublicRequestType.SHIP_TO)
                            .state("TX")
                            .postalCode("78701")
                            .country("US")
                            .street1("789 Pine St")
                            .city("Austin")
                            .build()))
                    .build())
                .call();

        if (res.pageTransactionEstimateResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                | Type                                                                                                                                                                                                     | Required                                                                                                                                                                                                 | Description                                                                                                                                                                                              |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `simulateNexusMet`                                                                                                                                                                                       | *Optional\<Boolean>*                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                       | : warning: ** DEPRECATED **: This will be removed in a future release, please migrate away from it as soon as possible.<br/><br/>**Deprecated:** Use `simulate_active_registration` in the request body instead. |
| `transactionEstimatePublicRequest`                                                                                                                                                                       | [TransactionEstimatePublicRequest](../../models/components/TransactionEstimatePublicRequest.md)                                                                                                          | :heavy_check_mark:                                                                                                                                                                                       | N/A                                                                                                                                                                                                      |

### Response

**[EstimateTaxV1TaxEstimatePostResponse](../../models/operations/EstimateTaxV1TaxEstimatePostResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcTaxEstimationResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |