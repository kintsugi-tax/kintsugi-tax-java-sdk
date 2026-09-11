# MichiganFields

State-specific fields for Michigan registration import (Michigan Treasury Online / MTO).


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `registrationType`                                                                         | [MichiganRegistrationType](../../models/components/MichiganRegistrationType.md)            | :heavy_check_mark:                                                                         | N/A                                                                                        |
| `businessName`                                                                             | *String*                                                                                   | :heavy_check_mark:                                                                         | State-registered business name as shown in Michigan Treasury Online (MTO).                 |
| `miStateTaxId`                                                                             | *String*                                                                                   | :heavy_check_mark:                                                                         | Michigan state-issued tax identification number (MI State Tax ID).                         |
| `thirdPartyAccessEnabled`                                                                  | *Optional\<Boolean>*                                                                       | :heavy_minus_sign:                                                                         | Whether third-party access has been granted to Kintsugi in Michigan Treasury Online (MTO). |