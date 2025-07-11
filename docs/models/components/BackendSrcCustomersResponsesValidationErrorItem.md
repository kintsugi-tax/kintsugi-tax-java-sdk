# BackendSrcCustomersResponsesValidationErrorItem


## Fields

| Field                    | Type                     | Required                 | Description              |
| ------------------------ | ------------------------ | ------------------------ | ------------------------ |
| `type`                   | *String*                 | :heavy_check_mark:       | Type of validation error |
| `loc`                    | List\<*String*>          | :heavy_check_mark:       | Location of error        |
| `msg`                    | *String*                 | :heavy_check_mark:       | Error message            |
| `input`                  | *Object*                 | :heavy_check_mark:       | Invalid input value      |
| `ctx`                    | Map\<String, *Object*>   | :heavy_check_mark:       | Additional context       |