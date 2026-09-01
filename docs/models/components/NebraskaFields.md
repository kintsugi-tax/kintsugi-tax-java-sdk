# NebraskaFields

State-specific fields for a Nebraska registration import.


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `registrationType`                                                              | [NebraskaRegistrationType](../../models/components/NebraskaRegistrationType.md) | :heavy_check_mark:                                                              | N/A                                                                             |
| `mfaCompleted`                                                                  | *Optional\<Boolean>*                                                            | :heavy_minus_sign:                                                              | Whether the customer completed Kintsugi MFA setup on the Nebraska tax account.  |
| `businessName`                                                                  | *String*                                                                        | :heavy_check_mark:                                                              | State-registered business name shown on the Nebraska tax account.               |
| `neUserId`                                                                      | *String*                                                                        | :heavy_check_mark:                                                              | Nebraska User ID shown on Form 10 from the Nebraska Department of Revenue.      |