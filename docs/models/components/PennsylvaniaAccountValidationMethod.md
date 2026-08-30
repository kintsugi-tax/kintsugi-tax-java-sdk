# PennsylvaniaAccountValidationMethod

Account validation methods offered by Pennsylvania myPATH third-party access.

The requester proves ownership with exactly one of these: a Letter ID, a Business
Registration Confirmation Code, a Payment Amount, or a Return Line Item.

## Example Usage

```java
import com.kintsugi.taxplatform.models.components.PennsylvaniaAccountValidationMethod;

PennsylvaniaAccountValidationMethod value = PennsylvaniaAccountValidationMethod.LETTER_ID;
```


## Values

| Name                                      | Value                                     |
| ----------------------------------------- | ----------------------------------------- |
| `LETTER_ID`                               | LETTER_ID                                 |
| `BUSINESS_REGISTRATION_CONFIRMATION_CODE` | BUSINESS_REGISTRATION_CONFIRMATION_CODE   |
| `PAYMENT_AMOUNT`                          | PAYMENT_AMOUNT                            |
| `RETURN_LINE_ITEM`                        | RETURN_LINE_ITEM                          |