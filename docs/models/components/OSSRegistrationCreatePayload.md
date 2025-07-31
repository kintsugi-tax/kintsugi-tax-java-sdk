# OSSRegistrationCreatePayload


## Fields

| Field                                                                    | Type                                                                     | Required                                                                 | Description                                                              |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| `registrationImportType`                                                 | *Optional\<String>*                                                      | :heavy_minus_sign:                                                       | Specifies this is an OSS registration import.                            |
| `passwordPlainText`                                                      | *Optional\<String>*                                                      | :heavy_minus_sign:                                                       | The plaintext password for accessing the tax registration account.       |
| `passwordMetadataPlainText`                                              | *Optional\<String>*                                                      | :heavy_minus_sign:                                                       | Metadata related to the password.                                        |
| `memberStateOfIdentificationCode`                                        | [Optional\<CountryCodeEnum>](../../models/components/CountryCodeEnum.md) | :heavy_minus_sign:                                                       | N/A                                                                      |
| `imported`                                                               | *Optional\<Boolean>*                                                     | :heavy_minus_sign:                                                       | Whether the registration was imported from another system.               |