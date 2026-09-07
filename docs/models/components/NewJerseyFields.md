# NewJerseyFields

State-specific fields for New Jersey (Premier Business Services) registration import.

New Jersey requires no 2FA/MFA setup (mirroring Michigan MTO), so there is no
``mfa_completed`` field and no MFA/2FA help article in the metadata.


## Fields

| Field                                                                            | Type                                                                             | Required                                                                         | Description                                                                      |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `registrationType`                                                               | *String*                                                                         | :heavy_check_mark:                                                               | Registration type for this New Jersey import: sales and use tax.                 |
| `businessName`                                                                   | *String*                                                                         | :heavy_check_mark:                                                               | State-registered business name as shown in New Jersey Premier Business Services. |
| `njStateTaxId`                                                                   | *String*                                                                         | :heavy_check_mark:                                                               | New Jersey state-issued taxpayer identification number (NJ State Taxpayer ID).   |
| `thirdPartyAccessEnabled`                                                        | *Optional\<Boolean>*                                                             | :heavy_minus_sign:                                                               | Whether third-party access has been granted to Kintsugi in New Jersey.           |