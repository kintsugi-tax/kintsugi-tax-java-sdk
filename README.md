# tax-platform-sdk

Developer-friendly & type-safe Java SDK specifically catered to leverage *tax-platform-sdk* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=tax-platform-sdk&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>


<br /><br />
> [!IMPORTANT]
> This SDK is not yet ready for production use. To complete setup please follow the steps outlined in your [workspace](https://app.speakeasy.com/org/kintsugi-ai/tax-platform). Delete this section before > publishing to a package manager.

<!-- Start Summary [summary] -->
## Summary


<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [tax-platform-sdk](#tax-platform-sdk)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Debugging](#debugging)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)
* [Force publish test](#force-publish-test)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.trykintsugi:kintsugi-tax-java-sdk:0.8.0'
```

Maven:
```xml
<dependency>
    <groupId>com.trykintsugi</groupId>
    <artifactId>kintsugi-tax-java-sdk</artifactId>
    <version>0.8.0</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        AddressBase req = AddressBase.builder()
                .phone("555-123-4567")
                .street1("1600 Amphitheatre Parkway")
                .street2("Building 40")
                .city("Mountain View")
                .county("Santa Clara")
                .state("CA")
                .postalCode("94043")
                .country(CountryCodeEnum.US)
                .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                .build();

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().searchV1AddressValidationSearchPost()
                .request(req)
                .security(SearchV1AddressValidationSearchPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security schemes globally:

| Name           | Type   | Scheme  |
| -------------- | ------ | ------- |
| `apiKeyHeader` | apiKey | API key |
| `customHeader` | apiKey | API key |

You can set the security parameters through the `security` builder method when initializing the SDK client instance. The selected scheme will be used by default to authenticate with the API for all operations that support it. For example:
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.Security;
import com.kintsugi.taxplatform.models.components.ValidationAddress;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SuggestionsV1AddressValidationSuggestionsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .security(Security.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .customHeader(System.getenv().getOrDefault("CUSTOM_HEADER", ""))
                    .build())
            .build();

        ValidationAddress req = ValidationAddress.builder()
                .line1("1600 Amphitheatre Parkway")
                .line2("")
                .line3("")
                .city("Mountain View")
                .state("CA")
                .postalCode("94043")
                .id(215L)
                .county("")
                .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                .build();

        SuggestionsV1AddressValidationSuggestionsPostResponse res = sdk.addressValidation().suggestionsV1AddressValidationSuggestionsPost()
                .request(req)
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Per-Operation Security Schemes

Some operations in this SDK require the security scheme to be specified at the request level. For example:
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        AddressBase req = AddressBase.builder()
                .phone("555-123-4567")
                .street1("1600 Amphitheatre Parkway")
                .street2("Building 40")
                .city("Mountain View")
                .county("Santa Clara")
                .state("CA")
                .postalCode("94043")
                .country(CountryCodeEnum.US)
                .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                .build();

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().searchV1AddressValidationSearchPost()
                .request(req)
                .security(SearchV1AddressValidationSearchPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [addressValidation()](docs/sdks/addressvalidation/README.md)

* [searchV1AddressValidationSearchPost](docs/sdks/addressvalidation/README.md#searchv1addressvalidationsearchpost) - Search
* [suggestionsV1AddressValidationSuggestionsPost](docs/sdks/addressvalidation/README.md#suggestionsv1addressvalidationsuggestionspost) - Suggestions

### [customers()](docs/sdks/customers/README.md)

* [getCustomersV1](docs/sdks/customers/README.md#getcustomersv1) - Get Customers
* [createCustomerV1CustomersPost](docs/sdks/customers/README.md#createcustomerv1customerspost) - Create Customer
* [getCustomerByIdV1CustomersCustomerIdGet](docs/sdks/customers/README.md#getcustomerbyidv1customerscustomeridget) - Get Customer By Id
* [updateCustomerV1CustomersCustomerIdPut](docs/sdks/customers/README.md#updatecustomerv1customerscustomeridput) - Update Customer
* [getCustomerByExternalIdV1CustomersExternalExternalIdGet](docs/sdks/customers/README.md#getcustomerbyexternalidv1customersexternalexternalidget) - Get Customer By External Id
* [getTransactionsByCustomerIdV1CustomersCustomerIdTransactionsGet](docs/sdks/customers/README.md#gettransactionsbycustomeridv1customerscustomeridtransactionsget) - Get Transactions By Customer Id
* [createTransactionByCustomerIdV1CustomersCustomerIdTransactionsPost](docs/sdks/customers/README.md#createtransactionbycustomeridv1customerscustomeridtransactionspost) - Create Transaction By Customer Id

### [exemptions()](docs/sdks/exemptions/README.md)

* [getExemptionsV1ExemptionsGet](docs/sdks/exemptions/README.md#getexemptionsv1exemptionsget) - Get Exemptions
* [createExemptionV1ExemptionsPost](docs/sdks/exemptions/README.md#createexemptionv1exemptionspost) - Create Exemption
* [getExemptionByIdV1ExemptionsExemptionIdGet](docs/sdks/exemptions/README.md#getexemptionbyidv1exemptionsexemptionidget) - Get Exemption By Id
* [uploadExemptionCertificateV1ExemptionsExemptionIdAttachmentsPost](docs/sdks/exemptions/README.md#uploadexemptioncertificatev1exemptionsexemptionidattachmentspost) - Upload Exemption Certificate
* [getAttachmentsForExemptionV1ExemptionsExemptionIdAttachmentsGet](docs/sdks/exemptions/README.md#getattachmentsforexemptionv1exemptionsexemptionidattachmentsget) - Get Attachments For Exemption

### [filings()](docs/sdks/filings/README.md)

* [getFilingsV1FilingsGet](docs/sdks/filings/README.md#getfilingsv1filingsget) - Get Filings
* [getFilingByIdV1FilingsFilingIdGet](docs/sdks/filings/README.md#getfilingbyidv1filingsfilingidget) - Get Filing By Id
* [getFilingsByRegistrationIdV1FilingsRegistrationRegistrationIdGet](docs/sdks/filings/README.md#getfilingsbyregistrationidv1filingsregistrationregistrationidget) - Get Filings By Registration Id

### [nexus()](docs/sdks/nexus/README.md)

* [getPhysicalNexusV1NexusPhysicalNexusGet](docs/sdks/nexus/README.md#getphysicalnexusv1nexusphysicalnexusget) - Get Physical Nexus
* [createPhysicalNexusV1NexusPhysicalNexusPost](docs/sdks/nexus/README.md#createphysicalnexusv1nexusphysicalnexuspost) - Create Physical Nexus
* [updatePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdPut](docs/sdks/nexus/README.md#updatephysicalnexusv1nexusphysicalnexusphysicalnexusidput) - Update Physical Nexus
* [deletePhysicalNexusV1NexusPhysicalNexusPhysicalNexusIdDelete](docs/sdks/nexus/README.md#deletephysicalnexusv1nexusphysicalnexusphysicalnexusiddelete) - Delete Physical Nexus
* [getNexusForOrgV1NexusGet](docs/sdks/nexus/README.md#getnexusfororgv1nexusget) - Get Nexus For Org

### [products()](docs/sdks/products/README.md)

* [getProductsV1ProductsGet](docs/sdks/products/README.md#getproductsv1productsget) - Get Products
* [createProductV1ProductsPost](docs/sdks/products/README.md#createproductv1productspost) - Create Product
* [getProductByIdV1ProductsProductIdGet](docs/sdks/products/README.md#getproductbyidv1productsproductidget) - Get Product By Id
* [updateProductV1ProductsProductIdPut](docs/sdks/products/README.md#updateproductv1productsproductidput) - Update Product
* [getProductCategoriesV1ProductsCategoriesGet](docs/sdks/products/README.md#getproductcategoriesv1productscategoriesget) - Get Product Categories

### [registrations()](docs/sdks/registrations/README.md)

* [getRegistrationsV1RegistrationsGet](docs/sdks/registrations/README.md#getregistrationsv1registrationsget) - Get Registrations
* [createRegistrationV1RegistrationsPost](docs/sdks/registrations/README.md#createregistrationv1registrationspost) - Create Registration
* [getRegistrationByIdV1RegistrationsRegistrationIdGet](docs/sdks/registrations/README.md#getregistrationbyidv1registrationsregistrationidget) - Get Registration By Id
* [updateRegistrationV1RegistrationsRegistrationIdPut](docs/sdks/registrations/README.md#updateregistrationv1registrationsregistrationidput) - Update Registration
* [deregisterRegistrationV1RegistrationsRegistrationIdDeregisterPost](docs/sdks/registrations/README.md#deregisterregistrationv1registrationsregistrationidderegisterpost) - Deregister Registration


### [taxEstimation()](docs/sdks/taxestimation/README.md)

* [estimateTaxV1TaxEstimatePost](docs/sdks/taxestimation/README.md#estimatetaxv1taxestimatepost) - Estimate Tax

### [transactions()](docs/sdks/transactions/README.md)

* [getTransactionsV1TransactionsGet](docs/sdks/transactions/README.md#gettransactionsv1transactionsget) - Get Transactions
* [createTransactionV1TransactionsPost](docs/sdks/transactions/README.md#createtransactionv1transactionspost) - Create Transaction
* [getTransactionByExternalIdV1TransactionsExternalExternalIdGet](docs/sdks/transactions/README.md#gettransactionbyexternalidv1transactionsexternalexternalidget) - Get Transaction By External Id
* [updateTransactionV1TransactionsTransactionIdPut](docs/sdks/transactions/README.md#updatetransactionv1transactionstransactionidput) - Update Transaction
* [getTransactionByIdV1TransactionsTransactionIdGet](docs/sdks/transactions/README.md#gettransactionbyidv1transactionstransactionidget) - Get Transaction By Id
* [getTransactionsByFilingIdV1TransactionsFilingsFilingIdGet](docs/sdks/transactions/README.md#gettransactionsbyfilingidv1transactionsfilingsfilingidget) - Get Transactions By Filing Id
* [postCreateCreditNoteByTransactionId](docs/sdks/transactions/README.md#postcreatecreditnotebytransactionid) - Create Credit Note By Transaction Id
* [putUpdateCreditNoteByTransactionId](docs/sdks/transactions/README.md#putupdatecreditnotebytransactionid) - Update Credit Note By Transaction Id

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `searchV1AddressValidationSearchPost` method throws the following exceptions:

| Error Type                                                                | Status Code | Content Type     |
| ------------------------------------------------------------------------- | ----------- | ---------------- |
| models/errors/ErrorResponse                                               | 401         | application/json |
| models/errors/BackendSrcAddressValidationResponsesValidationErrorResponse | 422         | application/json |
| models/errors/ErrorResponse                                               | 500         | application/json |
| models/errors/APIException                                                | 4XX, 5XX    | \*/\*            |

### Example

```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
            .build();

        AddressBase req = AddressBase.builder()
                .phone("555-123-4567")
                .street1("1600 Amphitheatre Parkway")
                .street2("Building 40")
                .city("Mountain View")
                .county("Santa Clara")
                .state("CA")
                .postalCode("94043")
                .country(CountryCodeEnum.US)
                .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                .build();

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().searchV1AddressValidationSearchPost()
                .request(req)
                .security(SearchV1AddressValidationSearchPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, ErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .serverURL("https://api.trykintsugi.com")
            .build();

        AddressBase req = AddressBase.builder()
                .phone("555-123-4567")
                .street1("1600 Amphitheatre Parkway")
                .street2("Building 40")
                .city("Mountain View")
                .county("Santa Clara")
                .state("CA")
                .postalCode("94043")
                .country(CountryCodeEnum.US)
                .fullAddress("1600 Amphitheatre Parkway, Mountain View, CA 94043")
                .build();

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().searchV1AddressValidationSearchPost()
                .request(req)
                .security(SearchV1AddressValidationSearchPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Debugging [debug] -->
## Debugging

### Debug
You can setup your SDK to emit debug logs for SDK requests and responses.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=tax-platform-sdk&utm_campaign=java)
# Force publish test
