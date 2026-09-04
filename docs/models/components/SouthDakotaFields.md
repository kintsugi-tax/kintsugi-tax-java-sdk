# SouthDakotaFields

State-specific fields for South Dakota (EPath) registration import.

South Dakota EPath requires no 2FA/MFA setup, so there is no ``mfa_completed``
field, and it grants no customer-facing third-party access step, so there is no
``third_party_access_enabled`` field either — unlike every other portal state.


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `registrationType`                                                 | *String*                                                           | :heavy_check_mark:                                                 | Registration type for this South Dakota import: sales and use tax. |
| `businessName`                                                     | *String*                                                           | :heavy_check_mark:                                                 | State-registered business name as shown in South Dakota EPath.     |
| `sdStateTaxId`                                                     | *String*                                                           | :heavy_check_mark:                                                 | South Dakota state-issued tax license number (SD State Tax ID).    |