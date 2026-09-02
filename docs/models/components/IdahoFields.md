# IdahoFields

State-specific fields for Idaho TAP portal registration import.


## Fields

| Field                                                                     | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `registrationType`                                                        | [IdahoRegistrationType](../../models/components/IdahoRegistrationType.md) | :heavy_check_mark:                                                        | N/A                                                                       |
| `mfaCompleted`                                                            | *Optional\<Boolean>*                                                      | :heavy_minus_sign:                                                        | Whether the customer has completed MFA setup in their Idaho tax account.  |
| `businessName`                                                            | *String*                                                                  | :heavy_check_mark:                                                        | Business name as registered with the Idaho State Tax Commission.          |
| `salesTaxId`                                                              | *String*                                                                  | :heavy_check_mark:                                                        | Idaho State Tax ID.                                                       |
| `accessCode`                                                              | *JsonNullable\<String>*                                                   | :heavy_minus_sign:                                                        | Customers add this in registration credentials after the Idaho            |