# ArizonaFields

State-specific fields for Arizona TPT registration import.


## Fields

| Field                                                                              | Type                                                                               | Required                                                                           | Description                                                                        |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `registrationType`                                                                 | [ArizonaRegistrationType](../../models/components/ArizonaRegistrationType.md)      | :heavy_check_mark:                                                                 | N/A                                                                                |
| `mfaCompleted`                                                                     | *Optional\<Boolean>*                                                               | :heavy_minus_sign:                                                                 | Whether the customer has completed MFA setup in their Arizona AZTaxes.gov account. |
| `businessName`                                                                     | *String*                                                                           | :heavy_check_mark:                                                                 | Business name as registered with the state of Arizona.                             |
| `salesTaxId`                                                                       | *String*                                                                           | :heavy_check_mark:                                                                 | Arizona state-issued sales tax number (AZ State Tax ID).                           |
| `locationId`                                                                       | *String*                                                                           | :heavy_check_mark:                                                                 | Business location ID as shown in AZTaxes.gov.                                      |