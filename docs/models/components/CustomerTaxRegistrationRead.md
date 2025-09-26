# CustomerTaxRegistrationRead


## Fields

| Field                                                                 | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `id`                                                                  | *String*                                                              | :heavy_check_mark:                                                    | N/A                                                                   |
| `customerId`                                                          | *String*                                                              | :heavy_check_mark:                                                    | N/A                                                                   |
| `countryCode`                                                         | [CountryCodeEnum](../../models/components/CountryCodeEnum.md)         | :heavy_check_mark:                                                    | N/A                                                                   |
| `taxType`                                                             | [CustomerTaxTypeEnum](../../models/components/CustomerTaxTypeEnum.md) | :heavy_check_mark:                                                    | Enum for customer tax registration types.                             |
| `taxId`                                                               | *String*                                                              | :heavy_check_mark:                                                    | N/A                                                                   |
| `isValid`                                                             | *boolean*                                                             | :heavy_check_mark:                                                    | N/A                                                                   |