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

<!-- UsageSnippet language="java" operationID="get_products_v1_products__get" method="get" path="/v1/products/" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetProductsV1ProductsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetProductsV1ProductsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetProductsV1ProductsGetRequest req = GetProductsV1ProductsGetRequest.builder()
                .build();

        GetProductsV1ProductsGetResponse res = sdk.products().list()
                .request(req)
                .call();

        if (res.pageProductRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [GetProductsV1ProductsGetRequest](../../models/operations/GetProductsV1ProductsGetRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

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

<!-- UsageSnippet language="java" operationID="create_product_v1_products__post" method="post" path="/v1/products/" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateProductV1ProductsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        ProductCreateManual req = ProductCreateManual.builder()
                .externalId("prod_001")
                .name("Sample Product")
                .productCategory(ProductCategoryEnum.PHYSICAL)
                .productSubcategory(ProductSubCategoryEnum.GENERAL_CLOTHING)
                .taxExempt(false)
                .description("A description of the product")
                .status(ProductStatusEnum.APPROVED)
                .source(SourceEnum.BIGCOMMERCE)
                .build();

        CreateProductV1ProductsPostResponse res = sdk.products().create()
                .request(req)
                .call();

        if (res.productRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [ProductCreateManual](../../models/shared/ProductCreateManual.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

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

<!-- UsageSnippet language="java" operationID="get_product_by_id_v1_products__product_id__get" method="get" path="/v1/products/{product_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetProductByIdV1ProductsProductIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetProductByIdV1ProductsProductIdGetResponse res = sdk.products().get()
                .productId("<id>")
                .call();

        if (res.productRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `productId`                                                 | *String*                                                    | :heavy_check_mark:                                          | The unique identifier for the product you want to retrieve. |

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

<!-- UsageSnippet language="java" operationID="update_product_v1_products__product_id__put" method="put" path="/v1/products/{product_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcProductsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UpdateProductV1ProductsProductIdPutResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcProductsResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        UpdateProductV1ProductsProductIdPutResponse res = sdk.products().update()
                .productId("<id>")
                .productUpdate(ProductUpdate.builder()
                    .name("Updated Product Name")
                    .productCategory(ProductCategoryEnum.PHYSICAL)
                    .productSubcategory(ProductSubCategoryEnum.GENERAL_CLOTHING)
                    .taxExempt(false)
                    .externalId("prod_001")
                    .description("An updated description for the product")
                    .status(ProductStatusEnum.APPROVED)
                    .build())
                .call();

        if (res.productRead().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `productId`                                               | *String*                                                  | :heavy_check_mark:                                        | Unique identifier of the product to be updated.           |
| `productUpdate`                                           | [ProductUpdate](../../models/components/ProductUpdate.md) | :heavy_check_mark:                                        | N/A                                                       |

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

<!-- UsageSnippet language="java" operationID="get_product_categories_v1_products_categories__get" method="get" path="/v1/products/categories/" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetProductCategoriesV1ProductsCategoriesGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        GetProductCategoriesV1ProductsCategoriesGetResponse res = sdk.products().listCategories()
                .call();

        if (res.responseGetProductCategoriesV1ProductsCategoriesGet().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetProductCategoriesV1ProductsCategoriesGetResponse](../../models/operations/GetProductCategoriesV1ProductsCategoriesGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |