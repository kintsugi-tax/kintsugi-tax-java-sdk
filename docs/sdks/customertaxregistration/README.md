# CustomerTaxRegistration

## Overview

### Available Operations

* [upsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPost](#upsertcustomertaxregistrationv1customerscustomeridtaxregistrationspost) - Upsert customer tax registration

## upsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPost

Creates or updates a customer tax registration record. If a registration already exists
    for this customer with the same tax type and country code, it will be updated.

### Example Usage

<!-- UsageSnippet language="java" operationID="upsert_customer_tax_registration_v1_customers__customer_id__tax_registrations_post" method="post" path="/v1/customers/{customer_id}/tax-registrations" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.CustomerTaxRegistrationCreateUpdate;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.UpsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        UpsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPostResponse res = sdk.customerTaxRegistration().upsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPost()
                .customerId("<id>")
                .xOrganizationId("org_12345")
                .customerTaxRegistrationCreateUpdate(CustomerTaxRegistrationCreateUpdate.builder()
                    .taxId("1234567890")
                    .build())
                .call();

        if (res.customerTaxRegistrationRead().isPresent()) {
            System.out.println(res.customerTaxRegistrationRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           | Example                                                                                               |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                          | *String*                                                                                              | :heavy_check_mark:                                                                                    | N/A                                                                                                   |                                                                                                       |
| `xOrganizationId`                                                                                     | *Optional\<String>*                                                                                   | :heavy_check_mark:                                                                                    | The unique identifier for the organization making the request                                         | org_12345                                                                                             |
| `customerTaxRegistrationCreateUpdate`                                                                 | [CustomerTaxRegistrationCreateUpdate](../../models/components/CustomerTaxRegistrationCreateUpdate.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |                                                                                                       |

### Response

**[UpsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPostResponse](../../models/operations/UpsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPostResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |