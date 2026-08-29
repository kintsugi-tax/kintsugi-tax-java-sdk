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

Kintsugi Customer API: Publicly documented Kintsugi Customer API endpoints. The source (openapi/_source/openapi-master.json) is the platform spec filtered to the documented customer surface (openapi/customer-endpoints.json); scripts/build-specs.mjs re-applies that filter here. Do not edit by hand.
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
  * [Custom HTTP Client](#custom-http-client)
  * [Debugging](#debugging)
  * [Jackson Configuration](#jackson-configuration)
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
implementation 'com.trykintsugi:kintsugi-tax-java-sdk:0.16.0'
```

Maven:
```xml
<dependency>
    <groupId>com.trykintsugi</groupId>
    <artifactId>kintsugi-tax-java-sdk</artifactId>
    <version>0.16.0</version>
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
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
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
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            System.out.println(res.response200SearchV1AddressValidationSearchPost().get());
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
import com.kintsugi.taxplatform.models.operations.async.SearchV1AddressValidationSearchPostResponse;
import java.util.concurrent.CompletableFuture;

public class Application {

    public static void main(String[] args) {

        AsyncSDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
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
                .call();

        resFut.thenAccept(res -> {
            if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
                System.out.println(res.response200SearchV1AddressValidationSearchPost().get());
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html

#### Union Consumption Patterns

When a response field is a union model:

- Discriminated unions: branch on the discriminator (`switch`) and then narrow to the concrete type.
- Non-discriminated unions: use generated accessors (for example `string()`, `asLong()`, `simpleObject()`) to determine the active variant.

For full model-specific examples (including Java 11/16/21 variants), see each union model's **Supported Types** section in the generated model docs.
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

This SDK supports the following security scheme globally:

| Name           | Type   | Scheme  |
| -------------- | ------ | ------- |
| `apiKeyHeader` | apiKey | API key |

To authenticate with the API the `apiKeyHeader` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
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
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            System.out.println(res.response200SearchV1AddressValidationSearchPost().get());
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [AddressValidation](docs/sdks/addressvalidation/README.md)

* [search](docs/sdks/addressvalidation/README.md#search) - Search
* [suggest](docs/sdks/addressvalidation/README.md#suggest) - Suggestions

### [CustomerTaxRegistration](docs/sdks/customertaxregistration/README.md)

* [upsertCustomerTaxRegistrationV1CustomersCustomerIdTaxRegistrationsPost](docs/sdks/customertaxregistration/README.md#upsertcustomertaxregistrationv1customerscustomeridtaxregistrationspost) - Upsert customer tax registration

### [Customers](docs/sdks/customers/README.md)

* [get](docs/sdks/customers/README.md#get) - Get customers
* [create](docs/sdks/customers/README.md#create) - Create customer
* [getByExternalId](docs/sdks/customers/README.md#getbyexternalid) - Get customer by external id
* [getById](docs/sdks/customers/README.md#getbyid) - Get customer by id
* [update](docs/sdks/customers/README.md#update) - Update customer
* [createTransaction](docs/sdks/customers/README.md#createtransaction) - Create transaction by customer id

### [Customers.Transactions](docs/sdks/customerstransactions/README.md)

* [getByCustomerId](docs/sdks/customerstransactions/README.md#getbycustomerid) - Get transactions by customer id

### [Exemptions](docs/sdks/exemptions/README.md)

* [get](docs/sdks/exemptions/README.md#get) - Get exemptions
* [create](docs/sdks/exemptions/README.md#create) - Create exemption
* [getById](docs/sdks/exemptions/README.md#getbyid) - Get exemption by id
* [getAttachments](docs/sdks/exemptions/README.md#getattachments) - Get attachments for exemption
* [uploadCertificate](docs/sdks/exemptions/README.md#uploadcertificate) - Upload exemption certificate

### [Filings](docs/sdks/filings/README.md)

* [get](docs/sdks/filings/README.md#get) - Get filings
* [getByRegistrationId](docs/sdks/filings/README.md#getbyregistrationid) - Get filings by registration id
* [getById](docs/sdks/filings/README.md#getbyid) - Get filing by id
* [approveFilingV1FilingsFilingIdApprovePut](docs/sdks/filings/README.md#approvefilingv1filingsfilingidapproveput) - Approve filing

### [Nexus](docs/sdks/nexus/README.md)

* [get](docs/sdks/nexus/README.md#get) - Get nexus for org
* [getPhysical](docs/sdks/nexus/README.md#getphysical) - Get physical nexus
* [createPhysical](docs/sdks/nexus/README.md#createphysical) - Create physical nexus
* [getPhysicalNexusCategoriesV1NexusPhysicalNexusCategoriesGet](docs/sdks/nexus/README.md#getphysicalnexuscategoriesv1nexusphysicalnexuscategoriesget) - Get physical nexus categories
* [deletePhysical](docs/sdks/nexus/README.md#deletephysical) - Delete physical nexus
* [updatePhysical](docs/sdks/nexus/README.md#updatephysical) - Update physical nexus
* [getNexusDetailsForIdV1NexusNexusIdGet](docs/sdks/nexus/README.md#getnexusdetailsforidv1nexusnexusidget) - Get nexus details for id

### [Products](docs/sdks/products/README.md)

* [getProductsV1ProductsGet](docs/sdks/products/README.md#getproductsv1productsget) - Get products
* [createProductV1ProductsPost](docs/sdks/products/README.md#createproductv1productspost) - Create product
* [getProductCategoriesV1ProductsCategoriesGet](docs/sdks/products/README.md#getproductcategoriesv1productscategoriesget) - Get product categories
* [getById](docs/sdks/products/README.md#getbyid) - Get product by id
* [update](docs/sdks/products/README.md#update) - Update product

### [Registrations](docs/sdks/registrations/README.md)

* [get](docs/sdks/registrations/README.md#get) - Get registrations
* [create](docs/sdks/registrations/README.md#create) - Create registration
* [getJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGet](docs/sdks/registrations/README.md#getjurisdictionspecificfieldsv1registrationsjurisdictionspecificfieldsget) - Get jurisdiction specific fields
* [listRegistrationJurisdictionsV1RegistrationsJurisdictionsGet](docs/sdks/registrations/README.md#listregistrationjurisdictionsv1registrationsjurisdictionsget) - List registration jurisdictions
* [getById](docs/sdks/registrations/README.md#getbyid) - Get registration by id
* [update](docs/sdks/registrations/README.md#update) - Update registration
* [uploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost](docs/sdks/registrations/README.md#uploadregistrationattachmentv1registrationsregistrationidattachmentspost) - Upload registration attachment
* [deregister](docs/sdks/registrations/README.md#deregister) - Deregister registration
* [getOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGet](docs/sdks/registrations/README.md#getosscountriesforregistrationv1registrationsregistrationidosscountriesget) - Get oss countries for registration

### [TaxEstimation](docs/sdks/taxestimation/README.md)

* [estimate](docs/sdks/taxestimation/README.md#estimate) - Estimate tax

### [Transactions](docs/sdks/transactions/README.md)

* [get](docs/sdks/transactions/README.md#get) - Get transactions
* [create](docs/sdks/transactions/README.md#create) - Create transaction
* [archiveTransactionByIdV1TransactionsArchivePost](docs/sdks/transactions/README.md#archivetransactionbyidv1transactionsarchivepost) - Archive transaction by id
* [getByExternalId](docs/sdks/transactions/README.md#getbyexternalid) - Get transaction by external id
* [getByFilingId](docs/sdks/transactions/README.md#getbyfilingid) - Get transactions by filing id
* [updateCreditNote](docs/sdks/transactions/README.md#updatecreditnote) - Update credit note by transaction id
* [getById](docs/sdks/transactions/README.md#getbyid) - Get transaction by id
* [update](docs/sdks/transactions/README.md#update) - Update transaction

### [Transactions.CreditNotes](docs/sdks/creditnotes/README.md)

* [create](docs/sdks/creditnotes/README.md#create) - Create credit note by transaction id

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.


[`SDKError`](./src/main/java/models/errors/SDKError.java) is the base class for all HTTP error responses. It has the following properties:

| Method           | Type                        | Description                                                              |
| ---------------- | --------------------------- | ------------------------------------------------------------------------ |
| `message()`      | `String`                    | Error message                                                            |
| `code()`         | `int`                       | HTTP response status code eg `404`                                       |
| `headers`        | `Map<String, List<String>>` | HTTP response headers                                                    |
| `body()`         | `byte[]`                    | HTTP body as a byte array. Can be empty array if no body is returned.    |
| `bodyAsString()` | `String`                    | HTTP body as a UTF-8 string. Can be empty string if no body is returned. |
| `rawResponse()`  | `HttpResponse<?>`           | Raw HTTP response (body already read and not available for re-read)      |

### Example
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.AddressBase;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.errors.*;
import com.kintsugi.taxplatform.models.operations.SearchV1AddressValidationSearchPostResponse;
import java.io.UncheckedIOException;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();
        try {

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
                    .call();

            if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
                System.out.println(res.response200SearchV1AddressValidationSearchPost().get());
            }
        } catch (SDKError ex) { // all SDK exceptions inherit from SDKError

            // ex.ToString() provides a detailed error message including
            // HTTP status code, headers, and error payload (if any)
            System.out.println(ex);

            // Base exception fields
            var rawResponse = ex.rawResponse();
            var headers = ex.headers();
            var contentType = headers.first("Content-Type");
            int statusCode = ex.code();
            Optional<byte[]> responseBody = ex.body();

            // different error subclasses may be thrown 
            // depending on the service call
            if (ex instanceof ErrorResponse) {
                var e = (ErrorResponse) ex;
                // Check error data fields
                e.data().ifPresent(payload -> {
                      String detail = payload.detail();
                });
            }

            // An underlying cause may be provided. If the error payload 
            // cannot be deserialized then the deserialization exception 
            // will be set as the cause.
            if (ex.getCause() != null) {
                var cause = ex.getCause();
            }
        } catch (UncheckedIOException ex) {
            // handle IO error (connection, timeout, etc)
        }    }
}
```

### Error Classes
**Primary error:**
* [`SDKError`](./src/main/java/models/errors/SDKError.java): The base class for HTTP error responses.

<details><summary>Less common errors (17)</summary>

<br />

**Network errors:**
* `java.io.IOException` (always wrapped by `java.io.UncheckedIOException`). Commonly encountered subclasses of
`IOException` include `java.net.ConnectException`, `java.net.SocketTimeoutException`, `EOFException` (there are
many more subclasses in the JDK platform).

**Inherit from [`SDKError`](./src/main/java/models/errors/SDKError.java)**:
* [`com.kintsugi.taxplatform.models.errors.ErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.ErrorResponse.java): Applicable to 33 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.HTTPValidationError`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.HTTPValidationError.java): Validation Error. Status code `422`. Applicable to 17 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcExemptionsResponsesValidationErrorResponse.java): Validation issues, such as missing required fields or invalid field values. Status code `422`. Applicable to 5 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcProductsSchemasResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcProductsSchemasResponsesValidationErrorResponse.java): Validation error. Status code `422`. Applicable to 5 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse.java): Validation error. Status code `422`. Applicable to 5 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcTransactionsResponsesValidationErrorResponse.java): Status code `422`. Applicable to 5 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcNexusResponsesValidationErrorResponse.java): Validation error. Status code `422`. Applicable to 4 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcCustomersResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcCustomersResponsesValidationErrorResponse.java): Query parameters failed validation, such as an out-of-range page number. Status code `422`. Applicable to 3 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcFilingsResponsesValidationErrorResponse.java): Validation error. Status code `422`. Applicable to 3 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcAddressValidationResponsesValidationErrorResponse.java): Validation error - Address fields failed validation or are incomplete. Status code `422`. Applicable to 2 of 50 methods.*
* [`com.kintsugi.taxplatform.models.errors.BackendSrcTaxEstimationResponsesValidationErrorResponse`](./src/main/java/models/errors/com.kintsugi.taxplatform.models.errors.BackendSrcTaxEstimationResponsesValidationErrorResponse.java): Validation Error. Status code `422`. Applicable to 1 of 50 methods.*


</details>

\* Check [the method documentation](#available-resources-and-operations) to see if the error is applicable.
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
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcAddressValidationResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .serverURL("https://api.trykintsugi.com")
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
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
                .call();

        if (res.response200SearchV1AddressValidationSearchPost().isPresent()) {
            System.out.println(res.response200SearchV1AddressValidationSearchPost().get());
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Custom HTTP Client [http-client] -->
## Custom HTTP Client

The Java SDK makes API calls using an `HTTPClient` that wraps the native
[HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html). This
client provides the ability to attach hooks around the request lifecycle that can be used to modify the request or handle
errors and response.

The `HTTPClient` interface allows you to either use the default `SpeakeasyHTTPClient` that comes with the SDK,
or provide your own custom implementation with customized configuration such as custom executors, SSL context,
connection pools, and other HTTP client settings.

The interface provides synchronous (`send`) methods and asynchronous (`sendAsync`) methods. The `sendAsync` method
is used to power the async SDK methods and returns a `CompletableFuture<HttpResponse<Blob>>` for non-blocking operations.

The following example shows how to add a custom header and handle errors:

```java
import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.utils.HTTPClient;
import com.kintsugi.taxplatform.utils.SpeakeasyHTTPClient;
import com.kintsugi.taxplatform.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        // Create a custom HTTP client with hooks
        HTTPClient httpClient = new HTTPClient() {
            private final HTTPClient defaultClient = new SpeakeasyHTTPClient();
            
            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                // Add custom header and timeout using Utils.copy()
                HttpRequest modifiedRequest = Utils.copy(request)
                    .header("x-custom-header", "custom value")
                    .timeout(Duration.ofSeconds(30))
                    .build();
                    
                try {
                    HttpResponse<InputStream> response = defaultClient.send(modifiedRequest);
                    // Log successful response
                    System.out.println("Request successful: " + response.statusCode());
                    return response;
                } catch (Exception error) {
                    // Log error
                    System.err.println("Request failed: " + error.getMessage());
                    throw error;
                }
            }
        };

        SDK sdk = SDK.builder()
            .client(httpClient)
            .build();
    }
}
```

<details>
<summary>Custom HTTP Client Configuration</summary>

You can also provide a completely custom HTTP client with your own configuration:

```java
import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.utils.HTTPClient;
import com.kintsugi.taxplatform.utils.Blob;
import com.kintsugi.taxplatform.utils.ResponseWithBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        // Custom HTTP client with custom configuration
        HTTPClient customHttpClient = new HTTPClient() {
            private final HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newFixedThreadPool(10))
                .connectTimeout(Duration.ofSeconds(30))
                // .sslContext(customSslContext) // Add custom SSL context if needed
                .build();

            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            }

            @Override
            public CompletableFuture<HttpResponse<Blob>> sendAsync(HttpRequest request) {
                // Convert response to HttpResponse<Blob> for async operations
                return client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher())
                    .thenApply(resp -> new ResponseWithBody<>(resp, Blob::from));
            }
        };

        SDK sdk = SDK.builder()
            .client(customHttpClient)
            .build();
    }
}
```

</details>

You can also enable debug logging on the default `SpeakeasyHTTPClient`:

```java
import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.utils.SpeakeasyHTTPClient;

public class Application {
    public static void main(String[] args) {
        SpeakeasyHTTPClient httpClient = new SpeakeasyHTTPClient();
        httpClient.enableDebugLogging(true);

        SDK sdk = SDK.builder()
            .client(httpClient)
            .build();
    }
}
```
<!-- End Custom HTTP Client [http-client] -->

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
__WARNING__: This logging should only be used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.


Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Start Jackson Configuration [jackson] -->
## Jackson Configuration

The SDK ships with a pre-configured Jackson [`ObjectMapper`][jackson-databind] accessible via
`JSON.getMapper()`. It is set up with type modules, strict deserializers, and the feature flags
needed for full SDK compatibility (including ISO-8601 `OffsetDateTime` serialization):

```java
import com.kintsugi.taxplatform.utils.JSON;

String json = JSON.getMapper().writeValueAsString(response);
```

To compose with your own `ObjectMapper`, register the provided `KintsugiTaxJavaSDKJacksonModule`, which
bundles all the same modules and feature flags as a single plug-and-play module:

```java
import com.kintsugi.taxplatform.utils.KintsugiTaxJavaSDKJacksonModule;
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper myMapper = new ObjectMapper()
    .registerModule(new KintsugiTaxJavaSDKJacksonModule());

String json = myMapper.writeValueAsString(response);
```

[jackson-databind]: https://github.com/FasterXML/jackson-databind
[jackson-jsr310]: https://github.com/FasterXML/jackson-modules-java8/tree/master/datetime
<!-- End Jackson Configuration [jackson] -->

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
