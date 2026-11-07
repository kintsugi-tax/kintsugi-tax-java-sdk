# FeeTypeEnum

Label for ``Filing.amount_fees`` — penalty vs interest vs other.

Nullable on the row: existing fees predate the label and stay blank until
Tax Ops classifies them. Does not change arithmetic.

## Example Usage

```java
import com.kintsugi.taxplatform.models.components.FeeTypeEnum;

FeeTypeEnum value = FeeTypeEnum.PENALTY;
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `PENALTY`  | PENALTY    |
| `INTEREST` | INTEREST   |
| `OTHER`    | OTHER      |