# PennsylvaniaIdentificationType

Identification types accepted by Pennsylvania myPATH third-party access requests.

myPATH validates the requester against a federal/state identifier: an FEIN, ITIN,
Revenue ID, or SSN.

## Example Usage

```java
import com.kintsugi.taxplatform.models.components.PennsylvaniaIdentificationType;

PennsylvaniaIdentificationType value = PennsylvaniaIdentificationType.FEIN;
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `FEIN`       | FEIN         |
| `ITIN`       | ITIN         |
| `REVENUE_ID` | REVENUE_ID   |
| `SSN`        | SSN          |