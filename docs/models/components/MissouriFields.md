# MissouriFields

State-specific fields for Missouri portal registration import (MyTax Missouri).


## Fields

| Field                                                                           | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `registrationType`                                                              | [MissouriRegistrationType](../../models/components/MissouriRegistrationType.md) | :heavy_check_mark:                                                              | N/A                                                                             |
| `businessName`                                                                  | *String*                                                                        | :heavy_check_mark:                                                              | State-registered business name as shown in MyTax Missouri.                      |
| `moStateTaxId`                                                                  | *String*                                                                        | :heavy_check_mark:                                                              | Missouri state-issued tax identification number (MO State Tax ID).              |
| `thirdPartyAccessEnabled`                                                       | *Optional\<Boolean>*                                                            | :heavy_minus_sign:                                                              | Whether third-party access has been granted to Kintsugi in MyTax Missouri.      |