# CaMayPrepaymentDisplay

Display-only CDTFA Option 2 amount for CA May quarterly prepayment filings.

Populated for CA ``QUARTERLY_PREPAYMENT`` ``PREPAYMENT`` filings whose period
starts in May. Does not change any stored amount on the filing. See KA-1240.


## Fields

| Field                                                          | Type                                                           | Required                                                       | Description                                                    |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| `baseTaxLiability`                                             | *String*                                                       | :heavy_check_mark:                                             | The filing's stored May total_tax_liability (100%).            |
| `prepaymentAmount`                                             | *String*                                                       | :heavy_check_mark:                                             | CDTFA Option 2 prepayment: base_tax_liability × 1.35.          |
| `note`                                                         | *String*                                                       | :heavy_check_mark:                                             | Explanatory note that the amount is 135% of May tax liability. |