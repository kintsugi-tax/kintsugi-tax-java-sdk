# WyomingFields

State-specific fields for Wyoming (WYPath) registration import.

Wyoming (WYIFS / WYPath) does not use or require 2FA/MFA, so there is no
``mfa_completed`` field. There is also no dedicated third-party master account
for sales and use tax, so there is no ``third_party_access_enabled`` field.
The State PIN is collected via the optional top-level ``pin_plain_text`` field
(encrypted into ``pin_encrypted``), not JSF — same pattern as Arizona.


## Fields

| Field                                                         | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `registrationType`                                            | *String*                                                      | :heavy_check_mark:                                            | Registration type for this Wyoming import: sales and use tax. |
| `businessName`                                                | *String*                                                      | :heavy_check_mark:                                            | State-registered business name as shown in Wyoming WYPath.    |
| `wyStateTaxId`                                                | *String*                                                      | :heavy_check_mark:                                            | Wyoming state-issued tax ID (Wyoming State Tax ID).           |