# Products
(*products()*)

## Overview

### Available Operations

* [list](#list) - Get Products
* [create](#create) - Create Product
* [get](#get) - Get Product By Id
* [update](#update) - Update Product
* [listCategories](#listcategories) - Get Product Categories

## list

Retrieve a paginated list of products based on filters and search query.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetProductsV1ProductsGetRequest req = GetProductsV1ProductsGetRequest.builder()
                .xOrganizationId("org_12345")
                .build();

        GetProductsV1ProductsGetResponse res = sdk.products().list()
                .request(req)
                .security(GetProductsV1ProductsGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.pageProductRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                  | Type                                                                                                                                       | Required                                                                                                                                   | Description                                                                                                                                |
| ------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------ |
| `request`                                                                                                                                  | [GetProductsV1ProductsGetRequest](../../models/operations/GetProductsV1ProductsGetRequest.md)                                              | :heavy_check_mark:                                                                                                                         | The request object to use for the request.                                                                                                 |
| `security`                                                                                                                                 | [com.kintsugi.taxplatform.models.operations.GetProductsV1ProductsGetSecurity](../../models/operations/GetProductsV1ProductsGetSecurity.md) | :heavy_check_mark:                                                                                                                         | The security requirements to use for the request.                                                                                          |

### Response

**[GetProductsV1ProductsGetResponse](../../models/operations/GetProductsV1ProductsGetResponse.md)**

### Errors

| Error Type                                                       | Status Code                                                      | Content Type                                                     |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| models/errors/ErrorResponse                                      | 401, 404                                                         | application/json                                                 |
| models/errors/BackendSrcProductsResponsesValidationErrorResponse | 422                                                              | application/json                                                 |
| models/errors/ErrorResponse                                      | 500                                                              | application/json                                                 |
| models/errors/APIException                                       | 4XX, 5XX                                                         | \*/\*                                                            |

## create

The Create Product API allows users to manually create a new product
    in the system. This includes specifying product details such as category,
    subcategory, and tax exemption status, etc.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateProductV1ProductsPostResponse;
import com.kintsugi.taxplatform.models.operations.CreateProductV1ProductsPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        CreateProductV1ProductsPostResponse res = sdk.products().create()
                .security(CreateProductV1ProductsPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .xOrganizationId("org_12345")
                .productCreateManual(ProductCreateManual.builder()
                    .externalId("prod_001")
                    .name("Sample Product")
                    .productCategory(ProductCreateManualProductCategory.of(ProductCategoryEnum.PHYSICAL))
                    .productSubcategory(ProductCreateManualProductSubcategory.of(ProductSubCategoryEnum.GENERAL_CLOTHING))
                    .taxExempt(false)
                    .description("A description of the product")
                    .status(ProductStatusEnum.APPROVED)
                    .source(SourceEnum.BIGCOMMERCE)
                    .build())
                .call();

        if (res.productRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                        | Type                                                                                                                                             | Required                                                                                                                                         | Description                                                                                                                                      | Example                                                                                                                                          |
| ------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                       | [com.kintsugi.taxplatform.models.operations.CreateProductV1ProductsPostSecurity](../../models/operations/CreateProductV1ProductsPostSecurity.md) | :heavy_check_mark:                                                                                                                               | The security requirements to use for the request.                                                                                                |                                                                                                                                                  |
| `xOrganizationId`                                                                                                                                | *Optional\<String>*                                                                                                                              | :heavy_check_mark:                                                                                                                               | The unique identifier for the organization making the request                                                                                    | org_12345                                                                                                                                        |
| `productCreateManual`                                                                                                                            | [ProductCreateManual](../../models/components/ProductCreateManual.md)                                                                            | :heavy_check_mark:                                                                                                                               | N/A                                                                                                                                              |                                                                                                                                                  |

### Response

**[CreateProductV1ProductsPostResponse](../../models/operations/CreateProductV1ProductsPostResponse.md)**

### Errors

| Error Type                                                       | Status Code                                                      | Content Type                                                     |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| models/errors/ErrorResponse                                      | 401                                                              | application/json                                                 |
| models/errors/BackendSrcProductsResponsesValidationErrorResponse | 422                                                              | application/json                                                 |
| models/errors/ErrorResponse                                      | 500                                                              | application/json                                                 |
| models/errors/APIException                                       | 4XX, 5XX                                                         | \*/\*                                                            |

## get

The Get Product By ID API retrieves detailed information about
    a single product by its unique ID. This API helps in viewing the specific details
    of a product, including its attributes, status, and categorization.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetProductByIdV1ProductsProductIdGetResponse;
import com.kintsugi.taxplatform.models.operations.GetProductByIdV1ProductsProductIdGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetProductByIdV1ProductsProductIdGetResponse res = sdk.products().get()
                .security(GetProductByIdV1ProductsProductIdGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .productId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.productRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                          | Type                                                                                                                                                               | Required                                                                                                                                                           | Description                                                                                                                                                        | Example                                                                                                                                                            |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `security`                                                                                                                                                         | [com.kintsugi.taxplatform.models.operations.GetProductByIdV1ProductsProductIdGetSecurity](../../models/operations/GetProductByIdV1ProductsProductIdGetSecurity.md) | :heavy_check_mark:                                                                                                                                                 | The security requirements to use for the request.                                                                                                                  |                                                                                                                                                                    |
| `productId`                                                                                                                                                        | *String*                                                                                                                                                           | :heavy_check_mark:                                                                                                                                                 | The unique identifier for the product you want to retrieve.                                                                                                        |                                                                                                                                                                    |
| `xOrganizationId`                                                                                                                                                  | *Optional\<String>*                                                                                                                                                | :heavy_check_mark:                                                                                                                                                 | The unique identifier for the organization making the request                                                                                                      | org_12345                                                                                                                                                          |

### Response

**[GetProductByIdV1ProductsProductIdGetResponse](../../models/operations/GetProductByIdV1ProductsProductIdGetResponse.md)**

### Errors

| Error Type                                                       | Status Code                                                      | Content Type                                                     |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| models/errors/ErrorResponse                                      | 401                                                              | application/json                                                 |
| models/errors/BackendSrcProductsResponsesValidationErrorResponse | 422                                                              | application/json                                                 |
| models/errors/ErrorResponse                                      | 500                                                              | application/json                                                 |
| models/errors/APIException                                       | 4XX, 5XX                                                         | \*/\*                                                            |

## update

The Update Product API allows users to modify the details of
    an existing product identified by its unique product_id

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.ProductStatusEnum;
import com.kintsugi.taxplatform.models.components.ProductUpdateV2;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        UpdateProductV1ProductsProductIdPutResponse res = sdk.products().update()
                .security(UpdateProductV1ProductsProductIdPutSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .productId("<id>")
                .xOrganizationId("org_12345")
                .requestBody(Product.of(ProductUpdateV2.builder()
                    .name("Updated Product Name")
                    .status(ProductStatusEnum.APPROVED)
                    .productCategory("PHYSICAL")
                    .productSubcategory("GENERAL_CLOTHING")
                    .taxExempt(false)
                    .externalId("prod_001")
                    .description("An updated description for the product")
                    .classificationFailed(false)
                    .build()))
                .call();

        if (res.productRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                        | Type                                                                                                                                                             | Required                                                                                                                                                         | Description                                                                                                                                                      | Example                                                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                       | [com.kintsugi.taxplatform.models.operations.UpdateProductV1ProductsProductIdPutSecurity](../../models/operations/UpdateProductV1ProductsProductIdPutSecurity.md) | :heavy_check_mark:                                                                                                                                               | The security requirements to use for the request.                                                                                                                |                                                                                                                                                                  |
| `productId`                                                                                                                                                      | *String*                                                                                                                                                         | :heavy_check_mark:                                                                                                                                               | Unique identifier of the product to be updated.                                                                                                                  |                                                                                                                                                                  |
| `xOrganizationId`                                                                                                                                                | *Optional\<String>*                                                                                                                                              | :heavy_check_mark:                                                                                                                                               | The unique identifier for the organization making the request                                                                                                    | org_12345                                                                                                                                                        |
| `requestBody`                                                                                                                                                    | [Product](../../models/operations/Product.md)                                                                                                                    | :heavy_check_mark:                                                                                                                                               | N/A                                                                                                                                                              |                                                                                                                                                                  |

### Response

**[UpdateProductV1ProductsProductIdPutResponse](../../models/operations/UpdateProductV1ProductsProductIdPutResponse.md)**

### Errors

| Error Type                                                       | Status Code                                                      | Content Type                                                     |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| models/errors/ErrorResponse                                      | 401                                                              | application/json                                                 |
| models/errors/BackendSrcProductsResponsesValidationErrorResponse | 422                                                              | application/json                                                 |
| models/errors/ErrorResponse                                      | 500                                                              | application/json                                                 |
| models/errors/APIException                                       | 4XX, 5XX                                                         | \*/\*                                                            |

## listCategories

The Get Product Categories API retrieves all
    product categories.  This endpoint helps users understand and select the
    appropriate categories for their products.

### Example Usage

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetProductCategoriesV1ProductsCategoriesGetResponse;
import com.kintsugi.taxplatform.models.operations.GetProductCategoriesV1ProductsCategoriesGetSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
            .build();

        GetProductCategoriesV1ProductsCategoriesGetResponse res = sdk.products().listCategories()
                .security(GetProductCategoriesV1ProductsCategoriesGetSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .xOrganizationId("org_12345")
                .call();

        if (res.responseGetProductCategoriesV1ProductsCategoriesGet().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                        | Type                                                                                                                                                                             | Required                                                                                                                                                                         | Description                                                                                                                                                                      | Example                                                                                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                       | [com.kintsugi.taxplatform.models.operations.GetProductCategoriesV1ProductsCategoriesGetSecurity](../../models/operations/GetProductCategoriesV1ProductsCategoriesGetSecurity.md) | :heavy_check_mark:                                                                                                                                                               | The security requirements to use for the request.                                                                                                                                |                                                                                                                                                                                  |
| `xOrganizationId`                                                                                                                                                                | *Optional\<String>*                                                                                                                                                              | :heavy_check_mark:                                                                                                                                                               | The unique identifier for the organization making the request                                                                                                                    | org_12345                                                                                                                                                                        |

### Response

**[GetProductCategoriesV1ProductsCategoriesGetResponse](../../models/operations/GetProductCategoriesV1ProductsCategoriesGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |