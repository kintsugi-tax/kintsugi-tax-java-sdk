# TaxEstimation
(*taxEstimation()*)

## Overview

### Available Operations

* [estimateTax](#estimatetax) - Estimate Tax

## estimateTax

The Estimate Tax API calculates the estimated tax for a specific
    transaction based on the provided details, including organization nexus,
    transaction details, customer details, and addresses. Optionally simulates nexus being met for tax calculation purposes. The `simulate_nexus_met` parameter is deprecated and will be removed in future releases.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcTaxEstimationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.EstimateTaxV1TaxEstimatePostResponse;
import com.kintsugi.taxplatform.models.operations.EstimateTaxV1TaxEstimatePostSecurity;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcTaxEstimationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        EstimateTaxV1TaxEstimatePostResponse res = sdk.taxEstimation().estimateTax()
                .security(EstimateTaxV1TaxEstimatePostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .xOrganizationId("org_12345")
                .transactionEstimateRequest(TransactionEstimateRequest.builder()
                    .date(OffsetDateTime.parse("2025-01-23T13:01:29.949Z"))
                    .externalId("txn_12345")
                    .currency(CurrencyEnum.USD)
                    .addresses(List.of(
                        TransactionEstimateRequestAddress.builder()
                            .type(TransactionEstimateRequestType.SHIP_TO)
                            .state("TX")
                            .postalCode("78701")
                            .country("US")
                            .street1("789 Pine St")
                            .city("Austin")
                            .build()))
                    .transactionItems(List.of(
                        TransactionItemEstimateBase.builder()
                            .date(OffsetDateTime.parse("2024-10-28T10:00:00Z"))
                            .amount(TotalAmountOfThisTransactionItemAfterDiscounts.of(100d))
                            .externalId("item_A")
                            .externalProductId("prod_abc")
                            .quantity(QuantityOfTheProduct.of(2d))
                            .build(),
                        TransactionItemEstimateBase.builder()
                            .date(OffsetDateTime.parse("2024-10-28T10:00:00Z"))
                            .amount(TotalAmountOfThisTransactionItemAfterDiscounts.of(75.5))
                            .externalId("item_B")
                            .externalProductId("prod_xyz")
                            .quantity(QuantityOfTheProduct.of(1d))
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

| Parameter                                                                                                                                                                                                | Type                                                                                                                                                                                                     | Required                                                                                                                                                                                                 | Description                                                                                                                                                                                              | Example                                                                                                                                                                                                  |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                               | [com.kintsugi.taxplatform.models.operations.EstimateTaxV1TaxEstimatePostSecurity](../../models/operations/EstimateTaxV1TaxEstimatePostSecurity.md)                                                       | :heavy_check_mark:                                                                                                                                                                                       | The security requirements to use for the request.                                                                                                                                                        |                                                                                                                                                                                                          |
| `simulateNexusMet`                                                                                                                                                                                       | *Optional\<Boolean>*                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                       | : warning: ** DEPRECATED **: This will be removed in a future release, please migrate away from it as soon as possible.<br/><br/>**Deprecated:** Use `simulate_active_registration` in the request body instead. |                                                                                                                                                                                                          |
| `xOrganizationId`                                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                                      | :heavy_check_mark:                                                                                                                                                                                       | The unique identifier for the organization making the request                                                                                                                                            | org_12345                                                                                                                                                                                                |
| `transactionEstimateRequest`                                                                                                                                                                             | [TransactionEstimateRequest](../../models/components/TransactionEstimateRequest.md)                                                                                                                      | :heavy_check_mark:                                                                                                                                                                                       | N/A                                                                                                                                                                                                      |                                                                                                                                                                                                          |

### Response

**[EstimateTaxV1TaxEstimatePostResponse](../../models/operations/EstimateTaxV1TaxEstimatePostResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcTaxEstimationResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |