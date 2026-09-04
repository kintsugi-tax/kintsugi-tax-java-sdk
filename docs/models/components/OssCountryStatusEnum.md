# OssCountryStatusEnum

Status of a country within an OSS registration.

Keep the members in sync with ``PublicOssCountryStatusEnum``: the tenanted API
projects this onto that public enum by value (``_to_public_oss_country`` in
``registrations/routers/latest.py``), so a member added here without a matching
public member raises ``ValueError`` and 500s the tenanted read for any row carrying
the new status. Add it to both, or map it deliberately at the projection.

## Example Usage

```java
import com.kintsugi.taxplatform.models.components.OssCountryStatusEnum;

OssCountryStatusEnum value = OssCountryStatusEnum.ACTIVE;
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ACTIVE`  | ACTIVE    |
| `REMOVED` | REMOVED   |