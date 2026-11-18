# CustomerJurisdictionSpecificFieldsResponse

Customer import fields, including the tax types that jurisdiction allows.

The partner and public jurisdiction-fields routes stay on the base response.
Allowed tax types depend on the organization, and those contracts do not.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `countryCode`                                                                              | *String*                                                                                   | :heavy_check_mark:                                                                         | N/A                                                                                        |
| `stateCode`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | N/A                                                                                        |
| `defaultForm`                                                                              | *boolean*                                                                                  | :heavy_check_mark:                                                                         | True when no state-specific schema exists and the generic form should be used.             |
| `jurisdictionFieldsJsonSchema`                                                             | Map\<String, *Object*>                                                                     | :heavy_check_mark:                                                                         | JSON Schema for the jurisdiction-specific fields, or empty dict when default_form is True. |
| `metadata`                                                                                 | Map\<String, *Object*>                                                                     | :heavy_check_mark:                                                                         | UI metadata (help articles, portal URL, filing frequencies, etc.).                         |
| `taxTypes`                                                                                 | List\<[TaxTypeEnum](../../models/components/TaxTypeEnum.md)>                               | :heavy_check_mark:                                                                         | Tax types that can be imported for this jurisdiction.                                      |