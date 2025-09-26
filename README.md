# tax-platform-sdk

Developer-friendly & type-safe Java SDK specifically catered to leverage *tax-platform-sdk* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=tax-platform-sdk&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>


<br /><br />

<!-- Start Summary [summary] -->
## Summary


<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [tax-platform-sdk](#tax-platform-sdk)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Asynchronous Support](#asynchronous-support)
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
implementation 'com.trykintsugi:kintsugi-tax-java-sdk:0.13.0'
```

Maven:
```xml
<dependency>
    <groupId>com.trykintsugi</groupId>
    <artifactId>kintsugi-tax-java-sdk</artifactId>
    <version>0.13.0</version>
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

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().search()
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
#### Asynchronous Call
An asynchronous SDK client is also available that returns a [`CompletableFuture<T>`][comp-fut]. See [Asynchronous Support](#asynchronous-support) for more details on async benefits and reactive library integration.
```java
package hello.world;

import com.kintsugi.taxplatform.AsyncSDK;
import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostSecurity;
import com.kintsugi.taxplatform.models.operations.async.SearchV1AddressValidationSearchPostResponse;
import java.util.concurrent.CompletableFuture;

public class Application {

    public static void main(String[] args) {

        AsyncSDK sdk = SDK.builder()
            .build()
            .async();

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

        CompletableFuture<SearchV1AddressValidationSearchPostResponse> resFut = sdk.addressValidation().search()
                .request(req)
                .security(SearchV1AddressValidationSearchPostSecurity.builder()
                    .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
                    .build())
                .call();

        resFut.thenAccept(res -> {
            if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            // handle response
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
<!-- End SDK Example Usage [usage] -->

<!-- Start Asynchronous Support [async-support] -->
## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

<details>
<summary>Supported Operations</summary>

Async support is available for:

- **[Server-sent Events](#server-sent-event-streaming)**: Stream real-time events with Reactive Streams `Publisher<T>`
- **[JSONL Streaming](#jsonl-streaming)**: Process streaming JSON lines asynchronously
- **[Pagination](#pagination)**: Iterate through paginated results using `callAsPublisher()` and `callAsPublisherUnwrapped()`
- **[File Uploads](#file-uploads)**: Upload files asynchronously with progress tracking
- **[File Downloads](#file-downloads)**: Download files asynchronously with streaming support
- **[Standard Operations](#example)**: All regular API calls return `CompletableFuture<T>` for async execution

</details>

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/
<!-- End Asynchronous Support [async-support] -->

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

        SuggestionsV1AddressValidationSuggestionsPostResponse res = sdk.addressValidation().suggest()
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

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().search()
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

* [search](docs/sdks/addressvalidation/README.md#search) - Search
* [suggest](docs/sdks/addressvalidation/README.md#suggest) - Suggestions

### [customers()](docs/sdks/customers/README.md)

* [get](docs/sdks/customers/README.md#get) - Get Customers
* [create](docs/sdks/customers/README.md#create) - Create Customer
* [getById](docs/sdks/customers/README.md#getbyid) - Get Customer By Id
* [update](docs/sdks/customers/README.md#update) - Update Customer
* [getByExternalId](docs/sdks/customers/README.md#getbyexternalid) - Get Customer By External Id
* [createTransaction](docs/sdks/customers/README.md#createtransaction) - Create Transaction By Customer Id

#### [customers().transactions()](docs/sdks/customerstransactions/README.md)

* [getByCustomerId](docs/sdks/customerstransactions/README.md#getbycustomerid) - Get Transactions By Customer Id

### [exemptions()](docs/sdks/exemptions/README.md)

* [get](docs/sdks/exemptions/README.md#get) - Get Exemptions
* [create](docs/sdks/exemptions/README.md#create) - Create Exemption
* [getById](docs/sdks/exemptions/README.md#getbyid) - Get Exemption By Id
* [uploadCertificate](docs/sdks/exemptions/README.md#uploadcertificate) - Upload Exemption Certificate
* [getAttachments](docs/sdks/exemptions/README.md#getattachments) - Get Attachments For Exemption

### [filings()](docs/sdks/filings/README.md)

* [get](docs/sdks/filings/README.md#get) - Get Filings
* [getById](docs/sdks/filings/README.md#getbyid) - Get Filing By Id
* [getByRegistrationId](docs/sdks/filings/README.md#getbyregistrationid) - Get Filings By Registration Id

### [nexus()](docs/sdks/nexus/README.md)

* [getPhysical](docs/sdks/nexus/README.md#getphysical) - Get Physical Nexus
* [createPhysical](docs/sdks/nexus/README.md#createphysical) - Create Physical Nexus
* [updatePhysical](docs/sdks/nexus/README.md#updatephysical) - Update Physical Nexus
* [deletePhysical](docs/sdks/nexus/README.md#deletephysical) - Delete Physical Nexus
* [get](docs/sdks/nexus/README.md#get) - Get Nexus For Org

### [products()](docs/sdks/products/README.md)

* [get](docs/sdks/products/README.md#get) - Get Products
* [create](docs/sdks/products/README.md#create) - Create Product
* [getById](docs/sdks/products/README.md#getbyid) - Get Product By Id
* [update](docs/sdks/products/README.md#update) - Update Product
* [getCategories](docs/sdks/products/README.md#getcategories) - Get Product Categories

### [registrations()](docs/sdks/registrations/README.md)

* [get](docs/sdks/registrations/README.md#get) - Get Registrations
* [create](docs/sdks/registrations/README.md#create) - Create Registration
* [getById](docs/sdks/registrations/README.md#getbyid) - Get Registration By Id
* [update](docs/sdks/registrations/README.md#update) - Update Registration
* [deregister](docs/sdks/registrations/README.md#deregister) - Deregister Registration


### [taxEstimation()](docs/sdks/taxestimation/README.md)

* [estimate](docs/sdks/taxestimation/README.md#estimate) - Estimate Tax

### [transactions()](docs/sdks/transactions/README.md)

* [get](docs/sdks/transactions/README.md#get) - Get Transactions
* [create](docs/sdks/transactions/README.md#create) - Create Transaction
* [getByExternalId](docs/sdks/transactions/README.md#getbyexternalid) - Get Transaction By External Id
* [update](docs/sdks/transactions/README.md#update) - Update Transaction
* [getById](docs/sdks/transactions/README.md#getbyid) - Get Transaction By Id
* [getByFilingId](docs/sdks/transactions/README.md#getbyfilingid) - Get Transactions By Filing Id
* [updateCreditNote](docs/sdks/transactions/README.md#updatecreditnote) - Update Credit Note By Transaction Id

#### [transactions().creditNotes()](docs/sdks/creditnotes/README.md)

* [create](docs/sdks/creditnotes/README.md#create) - Create Credit Note By Transaction Id

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `search` method throws the following exceptions:

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

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().search()
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

        SearchV1AddressValidationSearchPostResponse res = sdk.addressValidation().search()
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
