# GetProductsV1ProductsGetRequest


## Fields

| Field                                                    | Type                                                     | Required                                                 | Description                                              |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| `query`                                                  | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Search term to filter products by name or other details. |
| `statusIn`                                               | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Filter products by status (comma-separated)              |
| `productCategoryIn`                                      | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Filter products by category (comma-separated)            |
| `productSubcategoryIn`                                   | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Filter products by subcategory (comma-separated)         |
| `sourceIn`                                               | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Filter products by source (comma-separated)              |
| `orderBy`                                                | *Optional\<String>*                                      | :heavy_minus_sign:                                       | Order results by specified fields (comma-separated)      |
| `page`                                                   | *Optional\<Long>*                                        | :heavy_minus_sign:                                       | Page number                                              |
| `size`                                                   | *Optional\<Long>*                                        | :heavy_minus_sign:                                       | Page size                                                |