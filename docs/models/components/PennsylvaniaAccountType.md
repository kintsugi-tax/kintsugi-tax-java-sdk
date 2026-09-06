# PennsylvaniaAccountType

Account ID types accepted when requesting third-party access on Pennsylvania myPATH.

myPATH identifies the account by one of these: a Business Use ID, an Account ID,
or a Sales License ID.

## Example Usage

```java
import com.kintsugi.taxplatform.models.components.PennsylvaniaAccountType;

PennsylvaniaAccountType value = PennsylvaniaAccountType.BUSINESS_USE_ID;
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `BUSINESS_USE_ID`  | BUSINESS_USE_ID    |
| `ACCOUNT_ID`       | ACCOUNT_ID         |
| `SALES_LICENSE_ID` | SALES_LICENSE_ID   |