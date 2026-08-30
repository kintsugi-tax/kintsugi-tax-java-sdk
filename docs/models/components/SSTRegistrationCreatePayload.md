# SSTRegistrationCreatePayload


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `registrationImportType`                                           | *Optional\<String>*                                                | :heavy_minus_sign:                                                 | Specifies this is an SST registration import.                      |
| `passwordPlainText`                                                | *JsonNullable\<String>*                                            | :heavy_minus_sign:                                                 | The plaintext password for accessing the tax registration account. |
| `passwordMetadataPlainText`                                        | *JsonNullable\<String>*                                            | :heavy_minus_sign:                                                 | Metadata related to the password.                                  |
| `username`                                                         | *JsonNullable\<String>*                                            | :heavy_minus_sign:                                                 | Username for accessing the tax registration account.               |