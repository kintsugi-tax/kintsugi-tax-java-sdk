# QuarterlyPrepayBalanceDisplay

Display-only balance-due breakdown for CA Quarterly Prepayment reconciliation.

Populated only when the org has ``enable_ca_qp_tax_liability_display`` on and the
filing is a CA ``QUARTERLY_PREPAYMENT`` ``REGULAR`` reconciliation with prepayment
siblings. Does not change any stored amount on the filing.


## Fields

| Field                                                                                  | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `grossTaxLiability`                                                                    | *String*                                                                               | :heavy_check_mark:                                                                     | The filing's stored full-quarter total_tax_liability.                                  |
| `balanceDue`                                                                           | *String*                                                                               | :heavy_check_mark:                                                                     | gross_tax_liability minus the sum of prepayment deductions.                            |
| `prepaymentDeductions`                                                                 | List\<[QuarterlyPrepayDeduction](../../models/components/QuarterlyPrepayDeduction.md)> | :heavy_minus_sign:                                                                     | The monthly prepayments netted out, ordered by period.                                 |