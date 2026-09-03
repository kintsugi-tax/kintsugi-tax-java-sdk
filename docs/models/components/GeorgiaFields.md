# GeorgiaFields

State-specific fields for Georgia GTC registration import.


## Fields

| Field                                                                         | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `registrationType`                                                            | [GeorgiaRegistrationType](../../models/components/GeorgiaRegistrationType.md) | :heavy_check_mark:                                                            | N/A                                                                           |
| `mfaCompleted`                                                                | *Optional\<Boolean>*                                                          | :heavy_minus_sign:                                                            | Whether the customer has completed MFA setup in their Georgia GTC account.    |
| `businessName`                                                                | *String*                                                                      | :heavy_check_mark:                                                            | Business name as registered with the state of Georgia.                        |
| `salesTaxId`                                                                  | *String*                                                                      | :heavy_check_mark:                                                            | Georgia State Tax ID.                                                         |
| `zipCode`                                                                     | *String*                                                                      | :heavy_check_mark:                                                            | Georgia ZIP code on file with the Georgia Department of Revenue.              |
| `lastPaymentToState`                                                          | *String*                                                                      | :heavy_check_mark:                                                            | Last payment amount made to the state ('0.00' if no payments made).           |