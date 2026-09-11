# POSTCreateCreditNoteByTransactionIdRequest


## Fields

| Field                                                           | Type                                                            | Required                                                        | Description                                                     | Example                                                         |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `originalTransactionId`                                         | *String*                                                        | :heavy_check_mark:                                              | N/A                                                             |                                                                 |
| `xOrganizationId`                                               | *Optional\<String>*                                             | :heavy_check_mark:                                              | The unique identifier for the organization making the request   | org_12345                                                       |
| `creditNoteCreate`                                              | [CreditNoteCreate](../../models/components/CreditNoteCreate.md) | :heavy_check_mark:                                              | N/A                                                             |                                                                 |