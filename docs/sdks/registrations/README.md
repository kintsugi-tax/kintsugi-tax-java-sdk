# Registrations

## Overview

### Available Operations

* [get](#get) - Get registrations
* [create](#create) - Create registration
* [getJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGet](#getjurisdictionspecificfieldsv1registrationsjurisdictionspecificfieldsget) - Get jurisdiction specific fields
* [listRegistrationJurisdictionsV1RegistrationsJurisdictionsGet](#listregistrationjurisdictionsv1registrationsjurisdictionsget) - List registration jurisdictions
* [getById](#getbyid) - Get registration by id
* [update](#update) - Update registration
* [uploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost](#uploadregistrationattachmentv1registrationsregistrationidattachmentspost) - Upload registration attachment
* [deregister](#deregister) - Deregister registration
* [getOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGet](#getosscountriesforregistrationv1registrationsregistrationidosscountriesget) - Get oss countries for registration

## get

The Get Registrations API retrieves a
    paginated list of registrations.
    This API helps in tracking and managing registrations efficiently across multiple
    jurisdictions.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_registrations_v1_registrations_get" method="get" path="/v1/registrations" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetRegistrationsV1RegistrationsGetRequest;
import com.kintsugi.taxplatform.models.operations.GetRegistrationsV1RegistrationsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetRegistrationsV1RegistrationsGetRequest req = GetRegistrationsV1RegistrationsGetRequest.builder()
                .xOrganizationId("org_12345")
                .build();

        GetRegistrationsV1RegistrationsGetResponse res = sdk.registrations().get()
                .request(req)
                .call();

        if (res.pageRegistrationReadWithPassword().isPresent()) {
            System.out.println(res.pageRegistrationReadWithPassword().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                         | Type                                                                                                              | Required                                                                                                          | Description                                                                                                       |
| ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                         | [GetRegistrationsV1RegistrationsGetRequest](../../models/operations/GetRegistrationsV1RegistrationsGetRequest.md) | :heavy_check_mark:                                                                                                | The request object to use for the request.                                                                        |

### Response

**[GetRegistrationsV1RegistrationsGetResponse](../../models/operations/GetRegistrationsV1RegistrationsGetResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401, 404                                                              | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## create

The Create Registration API allows users to create a new registration
    for tracking and managing tax filings efficiently across multiple jurisdictions.

### Example Usage: oss

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="oss" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.CountryCodeEnum;
import com.kintsugi.taxplatform.models.components.OSSRegistrationCreatePayload;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(OSSRegistrationCreatePayload.builder()
                    .passwordPlainText("oss_pass_fr")
                    .passwordMetadataPlainText("{\"q\":\"a\"}")
                    .memberStateOfIdentificationCode(CountryCodeEnum.FR)
                    .imported(true)
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_alabama

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_alabama" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(AlabamaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("AL")
                    .stateName("Alabama")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(AlabamaFields.builder()
                        .registrationType(AlabamaRegistrationType.SALES_TAX)
                        .businessName("Acme Corp")
                        .signOnId("acme_sign_on")
                        .accessCode("abc123")
                        .thirdPartyPassword("tp_pass")
                        .salesTaxId("ST-AL-EXAMPLE")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("alabama_user")
                    .amountFees(AlabamaRegistrationPayloadAmountFees.of(100d))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_arizona

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_arizona" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId(Optional.empty())
                .requestBody(CreateRegistration.of(MississippiRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.TD)
                    .stateCode("<value>")
                    .stateName("<value>")
                    .filingFrequency(FilingFrequencyEnum.FOUR_MONTHLY)
                    .jurisdictionSpecificFields(MississippiFields.builder()
                        .registrationType(MississippiRegistrationType.SALES_AND_USE_TAX)
                        .businessName("<value>")
                        .msStateTaxId("<id>")
                        .msAccountType(MississippiAccountType.USE_TAX_LICENSE)
                        .letterId("<id>")
                        .build())
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_arkansas

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_arkansas" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(ArkansasRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("AR")
                    .stateName("Arkansas")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(ArkansasFields.builder()
                        .registrationType(ArkansasRegistrationType.REMOTE_SELLER)
                        .businessName("Acme Corp")
                        .arAccountId("AR-123456789")
                        .zipCode("72201")
                        .lastPaymentToState("0.00")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("atap_user")
                    .amountFees(ArkansasRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("atap_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_california

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_california" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(CaliforniaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("CA")
                    .stateName("California")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(CaliforniaFields.builder()
                        .registrationType(CaliforniaRegistrationType.REMOTE_SELLER)
                        .businessName("Acme Corp")
                        .salesTaxId("CA-1234567890")
                        .mfaCompleted(true)
                        .cdtfaThirdPartyAccessSecurityCode("sec-code-example")
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("cdtfa_user")
                    .amountFees(CaliforniaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("cdtfa_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_connecticut

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_connecticut" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(ConnecticutRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("CT")
                    .stateName("Connecticut")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(ConnecticutFields.builder()
                        .registrationType(ConnecticutRegistrationType.SALES_TAX)
                        .businessName("Test Connecticut Biz")
                        .ctTaxRegistrationNumber("CT-REG-999")
                        .lastPaymentToState("0.00")
                        .registrationId("REG-123456")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("ct_user")
                    .amountFees(ConnecticutRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("ct_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_district_of_columbia

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_district_of_columbia" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(DistrictOfColumbiaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("DC")
                    .stateName("District of Columbia")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(DistrictOfColumbiaFields.builder()
                        .registrationType(DistrictOfColumbiaRegistrationType.SALES_AND_USE_TAX)
                        .businessName("Acme Corp District of Columbia")
                        .dcStateTaxId("123456789012")
                        .mfaCompleted(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("mytax_dc_user")
                    .amountFees(DistrictOfColumbiaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("mytax_dc_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_florida

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_florida" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("FL")
                    .stateName("Florida")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("florida_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("florida_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_TAX"),
                        Map.entry("business_name", "Acme Corp Florida"),
                        Map.entry("fl_certificate_number", "78-8012345678-9"),
                        Map.entry("business_partner_number", "0001234567")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_georgia

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_georgia" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(GeorgiaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("GA")
                    .stateName("Georgia")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(GeorgiaFields.builder()
                        .registrationType(GeorgiaRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Georgia")
                        .salesTaxId("GA-ST-12345")
                        .zipCode("30301")
                        .lastPaymentToState("0.00")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("gtc_user")
                    .amountFees(GeorgiaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("gtc_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_hawaii

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_hawaii" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("HI")
                    .stateName("Hawaii")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("hawaii_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("hawaii_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "GENERAL_EXCISE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Hawaii"),
                        Map.entry("sales_tax_id", "HI-GE-12345"),
                        Map.entry("letter_id", "LTR-HI-001"),
                        Map.entry("last_payment_to_state", "0.00"),
                        Map.entry("third_party_access_enabled", true)))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_idaho

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_idaho" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(IdahoRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("ID")
                    .stateName("Idaho")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(IdahoFields.builder()
                        .registrationType(IdahoRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Idaho")
                        .salesTaxId("ID-ST-12345")
                        .mfaCompleted(true)
                        .accessCode("tap-code-example")
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("idaho_user")
                    .amountFees(IdahoRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("idaho_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_illinois

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_illinois" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(IllinoisRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("IL")
                    .stateName("Illinois")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(IllinoisFields.builder()
                        .registrationType(IllinoisRegistrationType.SALES_AND_USE_TAX)
                        .businessName("Acme Corp Illinois")
                        .illinoisAccountId("IL-9876543210")
                        .lastPaymentToState("0.00")
                        .firstName("Jane")
                        .lastName("Smith")
                        .businessPhone("217-555-9876")
                        .mfaCompleted(true)
                        .st2Activated(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("illinois_user")
                    .amountFees(IllinoisRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("illinois_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_indiana

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_indiana" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(IndianaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("IN")
                    .stateName("Indiana")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(IndianaFields.builder()
                        .businessName("Acme Corp Indiana")
                        .inStateTaxId("1234567890")
                        .locationId("LOC-IND-01")
                        .salesTaxAccountNumber("RST-0123456789")
                        .mfaCompleted(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("indiana_user")
                    .amountFees(IndianaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("indiana_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_iowa

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_iowa" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(IowaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("IA")
                    .stateName("Iowa")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(IowaFields.builder()
                        .registrationType(IowaRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Iowa")
                        .iaAccountType(IowaAccountType.SALES_TAX_LICENSE)
                        .iaStateTaxPermitNumber("IA-PERMIT-123")
                        .idrNumber("1234567890")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("iowa_user")
                    .amountFees(IowaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("iowa_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_kansas

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_kansas" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(KansasRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("KS")
                    .stateName("Kansas")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(KansasFields.builder()
                        .registrationType(KansasRegistrationType.RETAILERS_SALES_TAX)
                        .businessName("Acme Corp Kansas")
                        .ksStateTaxId("KS-TAX-001")
                        .accessCode("ks-access-secret")
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("kansas_user")
                    .amountFees(KansasRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("kansas_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_kentucky

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_kentucky" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("KY")
                    .stateName("Kentucky")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("kentucky_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("kentucky_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Kentucky"),
                        Map.entry("ky_state_tax_id", "KY-12345678"),
                        Map.entry("registered_via_sst", false),
                        Map.entry("third_party_access_enabled", true)))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_legacy

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_legacy" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("TX")
                    .stateName("Texas")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .comment("Registering for monthly sales tax filings")
                    .initialSync(false)
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_louisiana

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_louisiana" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("LA")
                    .stateName("Louisiana")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("louisiana_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("louisiana_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Louisiana"),
                        Map.entry("la_state_tax_id", "1234567890"),
                        Map.entry("license_type", "DIRECT_MARKETER"),
                        Map.entry("naics_code", "454110"),
                        Map.entry("registered_email_address", "louisiana@domain.com"),
                        Map.entry("last_payment_to_state", "0"),
                        Map.entry("zip_code", "70802")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_maine

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_maine" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(MaineRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("ME")
                    .stateName("Maine")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(MaineFields.builder()
                        .businessName("Acme Corp Maine")
                        .meStateTaxId("12345678")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("maine_user")
                    .amountFees(MaineRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("maine_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_maryland

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_maryland" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("MD")
                    .stateName("Maryland")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("maryland_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("maryland_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Maryland"),
                        Map.entry("md_state_tax_id", "MD-12345678"),
                        Map.entry("marketplace_facilitator", false)))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_massachusetts

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_massachusetts" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(MassachusettsRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("MA")
                    .stateName("Massachusetts")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(MassachusettsFields.builder()
                        .registrationType(MassachusettsRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Massachusetts")
                        .maStateAccountId("MA-ACCT-001")
                        .mfaCompleted(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("massachusetts_user")
                    .amountFees(MassachusettsRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("massachusetts_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_michigan

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_michigan" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId(Optional.empty())
                .requestBody(CreateRegistration.of(MichiganRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("MI")
                    .stateName("Michigan")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(MichiganFields.builder()
                        .registrationType(MichiganRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Michigan")
                        .miStateTaxId("MI-ACCT-001")
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("michigan_user")
                    .amountFees(MichiganRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("michigan_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_minnesota

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_minnesota" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(MinnesotaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("MN")
                    .stateName("Minnesota")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(MinnesotaFields.builder()
                        .businessName("Acme Corp Minnesota")
                        .mnStateTaxId("1234567")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("minnesota_user")
                    .amountFees(MinnesotaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("minnesota_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_mississippi

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_mississippi" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(MississippiRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("MS")
                    .stateName("Mississippi")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(MississippiFields.builder()
                        .registrationType(MississippiRegistrationType.SALES_AND_USE_TAX)
                        .businessName("Acme Corp Mississippi")
                        .msStateTaxId("12345678")
                        .msAccountType(MississippiAccountType.SALES_TAX_LICENSE)
                        .letterId("LTR-MS-001")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("mississippi_user")
                    .amountFees(MississippiRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("mississippi_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_missouri

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_missouri" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(MissouriRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("MO")
                    .stateName("Missouri")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(MissouriFields.builder()
                        .registrationType(MissouriRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Missouri")
                        .moStateTaxId("MO-ACCT-001")
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("missouri_user")
                    .amountFees(MissouriRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("missouri_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_nebraska

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_nebraska" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId(Optional.empty())
                .requestBody(CreateRegistration.of(NebraskaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("NE")
                    .stateName("Nebraska")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(NebraskaFields.builder()
                        .registrationType(NebraskaRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Nebraska")
                        .neUserId("12345678")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("nebraska_user")
                    .amountFees(NebraskaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("nebraska_password")
                    .pinPlainText("12345")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_nevada

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_nevada" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("NV")
                    .stateName("Nevada")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("nevada_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("nevada_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Nevada"),
                        Map.entry("nv_state_tax_id", "12345678")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_new

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_new" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId(Optional.empty())
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("TX")
                    .stateName("Texas")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .comment("Registering for monthly sales tax filings")
                    .initialSync(false)
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_new_jersey

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_new_jersey" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(TennesseeRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.SZ)
                    .stateCode("<value>")
                    .stateName("<value>")
                    .filingFrequency(FilingFrequencyEnum.SEMI_MONTHLY)
                    .jurisdictionSpecificFields(TennesseeFields.builder()
                        .registrationType(TennesseeRegistrationType.USE_TAX)
                        .businessName("<value>")
                        .tnStateTaxId("<id>")
                        .zipCode("43158-4492")
                        .letterId("<id>")
                        .build())
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_new_mexico

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_new_mexico" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("NM")
                    .stateName("New Mexico")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("new_mexico_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("new_mexico_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "GROSS_RECEIPTS_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp New Mexico"),
                        Map.entry("nm_state_tax_id", "03-123456-001")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_new_york

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_new_york" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("NY")
                    .stateName("New York")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("new_york_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("new_york_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("business_name", "Acme Corp New York"),
                        Map.entry("ny_state_tax_id", "123456789")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_north_carolina

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_north_carolina" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("NC")
                    .stateName("North Carolina")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("north_carolina_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("north_carolina_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("business_name", "Acme Corp North Carolina"),
                        Map.entry("nc_state_tax_id", "NC-ACCT-001"),
                        Map.entry("contact_name", "Jane Smith"),
                        Map.entry("contact_email", "jane.smith@example.com"),
                        Map.entry("contact_phone", "919-555-0100")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_north_dakota

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_north_dakota" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("ND")
                    .stateName("North Dakota")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("north_dakota_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("north_dakota_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp North Dakota"),
                        Map.entry("nd_state_tax_id", "ND-123456"),
                        Map.entry("letter_id", "L9999999999")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_ohio

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_ohio" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("OH")
                    .stateName("Ohio")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("ohio_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("ohio_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Ohio"),
                        Map.entry("oh_state_tax_id", "99-123456"),
                        Map.entry("third_party_access_enabled", true)))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_oklahoma

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_oklahoma" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("OK")
                    .stateName("Oklahoma")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("oklahoma_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("oklahoma_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Oklahoma"),
                        Map.entry("ok_state_tax_id", "1234567890"),
                        Map.entry("zip_code", "73102")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_pennsylvania

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_pennsylvania" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("PA")
                    .stateName("Pennsylvania")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("pennsylvania_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("pennsylvania_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Pennsylvania"),
                        Map.entry("pa_state_tax_id", "12345678"),
                        Map.entry("account_type", "ACCOUNT_ID"),
                        Map.entry("account_id", "1234567890"),
                        Map.entry("identification_type", "FEIN"),
                        Map.entry("identification_number", "12-3456789"),
                        Map.entry("account_validation_method", "LETTER_ID"),
                        Map.entry("account_validation_value", "L1234567890"),
                        Map.entry("sales_and_use_account_id", "12345678901")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_rhode_island

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_rhode_island" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("RI")
                    .stateName("Rhode Island")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("rhode_island_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("rhode_island_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp Rhode Island"),
                        Map.entry("ri_state_tax_id", "RI-123456"),
                        Map.entry("ri_sales_filing_id", "123456789"),
                        Map.entry("third_party_access_enabled", true)))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_south_carolina

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_south_carolina" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("SC")
                    .stateName("South Carolina")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("south_carolina_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("south_carolina_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "RETAIL_SALES_TAX"),
                        Map.entry("mfa_completed", true),
                        Map.entry("business_name", "Acme Corp South Carolina"),
                        Map.entry("sc_state_tax_id", "12345678"),
                        Map.entry("sc_sid", "87654321"),
                        Map.entry("letter_id", "L9999999999")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_south_dakota

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_south_dakota" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(RegistrationCreatePayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("SD")
                    .stateName("South Dakota")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("south_dakota_user")
                    .amountFees(RegistrationCreatePayloadAmountFees.of(100d))
                    .passwordPlainText("south_dakota_password")
                    .jurisdictionSpecificFields(Map.ofEntries(
                        Map.entry("registration_type", "SALES_AND_USE_TAX"),
                        Map.entry("business_name", "Acme Corp South Dakota"),
                        Map.entry("sd_state_tax_id", "1234-5678-ST")))
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_tennessee

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_tennessee" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(TennesseeRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("TN")
                    .stateName("Tennessee")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(TennesseeFields.builder()
                        .registrationType(TennesseeRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Tennessee")
                        .tnStateTaxId("TN-ACCT-001")
                        .zipCode("37201")
                        .letterId("L1234567890")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("tennessee_user")
                    .amountFees(TennesseeRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("tennessee_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_texas

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_texas" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(TexasRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("TX")
                    .stateName("Texas")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(TexasFields.builder()
                        .registrationType(TexasRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Texas")
                        .texasTaxpayerNumber("12345678901")
                        .webfileNumber("RT888777")
                        .mfaCompleted(true)
                        .registeredLocationNumber("LOC-9")
                        .registeredAddress("400 W Commerce St, Dallas TX 75208")
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("texas_user")
                    .amountFees(TexasRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("texas_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_utah

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_utah" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId(Optional.empty())
                .requestBody(CreateRegistration.of(UtahRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("UT")
                    .stateName("Utah")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(UtahFields.builder()
                        .registrationType(UtahRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Utah")
                        .utStateTaxId("UT-9876543210")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("utah_user")
                    .amountFees(UtahRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("utah_password")
                    .pinPlainText("654321")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_vermont

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_vermont" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(VermontRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("VT")
                    .stateName("Vermont")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(VermontFields.builder()
                        .registrationType(VermontRegistrationType.SALES_TAX)
                        .businessName("Acme Corp Vermont")
                        .vtStateTaxId("SUT-12345678")
                        .mfaCompleted(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("vermont_user")
                    .amountFees(VermontRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("vermont_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_virginia

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_virginia" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(VirginiaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("VA")
                    .stateName("Virginia")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(VirginiaFields.builder()
                        .registrationType(VirginiaRegistrationType.RETAIL_SALES_TAX)
                        .businessName("Acme Corp Virginia")
                        .vaStateTaxId("54-9876543")
                        .mfaCompleted(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("virginia_user")
                    .amountFees(VirginiaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("virginia_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_washington

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_washington" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(WashingtonRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("WA")
                    .stateName("Washington")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(WashingtonFields.builder()
                        .businessName("Acme Corp Washington")
                        .waStateTaxId("600123456")
                        .mfaCompleted(true)
                        .exciseAccountLinked(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("washington_user")
                    .amountFees(WashingtonRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("washington_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_west_virginia

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_west_virginia" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(WestVirginiaRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("WV")
                    .stateName("West Virginia")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(WestVirginiaFields.builder()
                        .registrationType(WestVirginiaRegistrationType.SALES_AND_USE_TAX)
                        .businessName("Acme Corp West Virginia")
                        .wvStateTaxId("WV-12345678")
                        .mfaCompleted(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("west_virginia_user")
                    .amountFees(WestVirginiaRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("west_virginia_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_wisconsin

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_wisconsin" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(WisconsinRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("WI")
                    .stateName("Wisconsin")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(WisconsinFields.builder()
                        .registrationType(WisconsinRegistrationType.SALES_AND_USE_TAX)
                        .businessName("Acme Corp Wisconsin")
                        .wiStateTaxId("WI-12345678")
                        .mfaCompleted(true)
                        .thirdPartyAccessEnabled(true)
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("wisconsin_user")
                    .amountFees(WisconsinRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("wisconsin_password")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: regular_wyoming

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="regular_wyoming" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(WyomingRegistrationPayload.builder()
                    .countryCode(CountryCodeEnum.US)
                    .stateCode("WY")
                    .stateName("Wyoming")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .jurisdictionSpecificFields(WyomingFields.builder()
                        .businessName("Acme Corp Wyoming")
                        .wyStateTaxId("WY-ACCT-001")
                        .build())
                    .registrationDate(LocalDate.parse("2025-02-01"))
                    .registrationEmail("example@domain.com")
                    .autoRegistered(true)
                    .username("wyoming_user")
                    .amountFees(WyomingRegistrationPayloadAmountFees.of(100d))
                    .passwordPlainText("wyoming_password")
                    .pinPlainText("wy-pin-1234")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```
### Example Usage: sst

<!-- UsageSnippet language="java" operationID="create_registration_v1_registrations_post" method="post" path="/v1/registrations" example="sst" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.SSTRegistrationCreatePayload;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.CreateRegistration;
import com.kintsugi.taxplatform.models.operations.CreateRegistrationV1RegistrationsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        CreateRegistrationV1RegistrationsPostResponse res = sdk.registrations().create()
                .xOrganizationId("<id>")
                .requestBody(CreateRegistration.of(SSTRegistrationCreatePayload.builder()
                    .passwordPlainText("sst_pass")
                    .passwordMetadataPlainText("{\"q\":\"a\"}")
                    .username("sst_user")
                    .build()))
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `xOrganizationId`                                                   | *Optional\<String>*                                                 | :heavy_check_mark:                                                  | N/A                                                                 |
| `requestBody`                                                       | [CreateRegistration](../../models/operations/CreateRegistration.md) | :heavy_check_mark:                                                  | N/A                                                                 |

### Response

**[CreateRegistrationV1RegistrationsPostResponse](../../models/operations/CreateRegistrationV1RegistrationsPostResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401, 409                                                              | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## getJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGet

Returns the JSON Schema and UI metadata for a state-specific registration form

### Example Usage

<!-- UsageSnippet language="java" operationID="get_jurisdiction_specific_fields_v1_registrations_jurisdiction_specific_fields_get" method="get" path="/v1/registrations/jurisdiction-specific-fields" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGetResponse res = sdk.registrations().getJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGet()
                .countryCode("MH")
                .stateCode("<value>")
                .xOrganizationId("org_12345")
                .call();

        if (res.jurisdictionSpecificFieldsResponse().isPresent()) {
            System.out.println(res.jurisdictionSpecificFieldsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `countryCode`                                                 | *String*                                                      | :heavy_check_mark:                                            | ISO 3166-1 alpha-2 country code (e.g., US).                   |                                                               |
| `stateCode`                                                   | *String*                                                      | :heavy_check_mark:                                            | State/province code (e.g., AL, LA).                           |                                                               |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGetResponse](../../models/operations/GetJurisdictionSpecificFieldsV1RegistrationsJurisdictionSpecificFieldsGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## listRegistrationJurisdictionsV1RegistrationsJurisdictionsGet

Distinct registration jurisdictions (country + state) for filter dropdowns. Non-SST only. Default status__in matches GET /registrations (all statuses).

### Example Usage

<!-- UsageSnippet language="java" operationID="list_registration_jurisdictions_v1_registrations_jurisdictions_get" method="get" path="/v1/registrations/jurisdictions" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.ListRegistrationJurisdictionsV1RegistrationsJurisdictionsGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        ListRegistrationJurisdictionsV1RegistrationsJurisdictionsGetResponse res = sdk.registrations().listRegistrationJurisdictionsV1RegistrationsJurisdictionsGet()
                .statusIn("REGISTERED,PROCESSING,UNREGISTERED,DEREGISTERING,DEREGISTERED,CANCELLED,VALIDATING,AWAITING_CLARIFICATION,SELF_MANAGED")
                .xOrganizationId("org_12345")
                .call();

        if (res.responseListRegistrationJurisdictionsV1RegistrationsJurisdictionsGet().isPresent()) {
            System.out.println(res.responseListRegistrationJurisdictionsV1RegistrationsJurisdictionsGet().get());
        }
    }
}
```

### Parameters

| Parameter                                                                    | Type                                                                         | Required                                                                     | Description                                                                  | Example                                                                      |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `statusIn`                                                                   | *Optional\<String>*                                                          | :heavy_minus_sign:                                                           | Filter by registration status (comma-separated); same as GET /registrations. |                                                                              |
| `xOrganizationId`                                                            | *Optional\<String>*                                                          | :heavy_check_mark:                                                           | The unique identifier for the organization making the request                | org_12345                                                                    |

### Response

**[ListRegistrationJurisdictionsV1RegistrationsJurisdictionsGetResponse](../../models/operations/ListRegistrationJurisdictionsV1RegistrationsJurisdictionsGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## getById

The Get Registration By ID API retrieves a single registration record
    based on its unique identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_registration_by_id_v1_registrations__registration_id__get" method="get" path="/v1/registrations/{registration_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse res = sdk.registrations().getById()
                .registrationId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `registrationId`                                                                       | *String*                                                                               | :heavy_check_mark:                                                                     | The unique identifier of the<br/>                                registration to retrieve. |                                                                                        |
| `reveal`                                                                               | *JsonNullable\<String>*                                                                | :heavy_minus_sign:                                                                     | Name of field to reveal                                                                |                                                                                        |
| `xOrganizationId`                                                                      | *Optional\<String>*                                                                    | :heavy_check_mark:                                                                     | The unique identifier for the organization making the request                          | org_12345                                                                              |

### Response

**[GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse](../../models/operations/GetRegistrationByIdV1RegistrationsRegistrationIdGetResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## update

The Update Registration API allows you to modify
    an existing registration using its unique registration_id.

### Example Usage

<!-- UsageSnippet language="java" operationID="update_registration_v1_registrations__registration_id__put" method="put" path="/v1/registrations/{registration_id}" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.*;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.UpdateRegistrationV1RegistrationsRegistrationIdPutResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        UpdateRegistrationV1RegistrationsRegistrationIdPutResponse res = sdk.registrations().update()
                .registrationId("<id>")
                .xOrganizationId("org_12345")
                .registrationUpdateAPI(RegistrationUpdateAPI.builder()
                    .registrationDate(LocalDate.parse("2025-03-01"))
                    .registrationEmail("example@domain.com")
                    .registrationRequested(OffsetDateTime.parse("2025-02-18T19:43:32.684802"))
                    .autoRegistered(true)
                    .registrationsRegime(RegistrationsRegimeEnum.STANDARD)
                    .changeRegimeStatus(ChangeRegimeStatusEnum.REQUESTED)
                    .username("User Name")
                    .filingFrequency(FilingFrequencyEnum.MONTHLY)
                    .createFilingsFrom(LocalDate.parse("2025-03-01"))
                    .isApproaching(false)
                    .comment("Updated registration for compliance")
                    .vda(false)
                    .build())
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               | Example                                                                   |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `registrationId`                                                          | *String*                                                                  | :heavy_check_mark:                                                        | The unique identifier of the registration to be updated.                  |                                                                           |
| `xOrganizationId`                                                         | *Optional\<String>*                                                       | :heavy_check_mark:                                                        | The unique identifier for the organization making the request             | org_12345                                                                 |
| `registrationUpdateAPI`                                                   | [RegistrationUpdateAPI](../../models/components/RegistrationUpdateAPI.md) | :heavy_check_mark:                                                        | N/A                                                                       |                                                                           |

### Response

**[UpdateRegistrationV1RegistrationsRegistrationIdPutResponse](../../models/operations/UpdateRegistrationV1RegistrationsRegistrationIdPutResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## uploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost

Upload an attachment for a specific registration.

### Example Usage

<!-- UsageSnippet language="java" operationID="upload_registration_attachment_v1_registrations__registration_id__attachments_post" method="post" path="/v1/registrations/{registration_id}/attachments" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.components.BodyUploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.UploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        UploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPostResponse res = sdk.registrations().uploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost()
                .registrationId("<id>")
                .xOrganizationId("org_12345")
                .bodyUploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost(BodyUploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost.builder()
                    .file("<value>")
                    .build())
                .call();

        if (res.attachment().isPresent()) {
            System.out.println(res.attachment().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `registrationId`                                                                                                                                                                        | *String*                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |
| `xOrganizationId`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_check_mark:                                                                                                                                                                      | The unique identifier for the organization making the request                                                                                                                           | org_12345                                                                                                                                                                               |
| `bodyUploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost`                                                                                                          | [BodyUploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost](../../models/components/BodyUploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPost.md) | :heavy_check_mark:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |

### Response

**[UploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPostResponse](../../models/operations/UploadRegistrationAttachmentV1RegistrationsRegistrationIdAttachmentsPostResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |

## deregister

Deregister an existing registration.

### Example Usage

<!-- UsageSnippet language="java" operationID="deregister_registration_v1_registrations__registration_id__deregister_post" method="post" path="/v1/registrations/{registration_id}/deregister" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.BackendSrcRegistrationsResponsesValidationErrorResponse;
import com.kintsugi.taxplatform.models.errors.ErrorResponse;
import com.kintsugi.taxplatform.models.operations.DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, BackendSrcRegistrationsResponsesValidationErrorResponse, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse res = sdk.registrations().deregister()
                .registrationId("regs_123456")
                .xOrganizationId("org_12345")
                .call();

        if (res.registrationRead().isPresent()) {
            System.out.println(res.registrationRead().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `registrationId`                                              | *String*                                                      | :heavy_check_mark:                                            | The unique identifier of the registration to deregister.      | regs_123456                                                   |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse](../../models/operations/DeregisterRegistrationV1RegistrationsRegistrationIdDeregisterPostResponse.md)**

### Errors

| Error Type                                                            | Status Code                                                           | Content Type                                                          |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| models/errors/ErrorResponse                                           | 401                                                                   | application/json                                                      |
| models/errors/BackendSrcRegistrationsResponsesValidationErrorResponse | 422                                                                   | application/json                                                      |
| models/errors/ErrorResponse                                           | 500                                                                   | application/json                                                      |
| models/errors/APIException                                            | 4XX, 5XX                                                              | \*/\*                                                                 |

## getOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGet

Get all OSS countries for a specific registration. This endpoint returns
    a list of EU countries that are covered by the OSS registration.

### Example Usage

<!-- UsageSnippet language="java" operationID="get_oss_countries_for_registration_v1_registrations__registration_id__oss_countries_get" method="get" path="/v1/registrations/{registration_id}/oss-countries" -->
```java
package hello.world;

import com.kintsugi.taxplatform.SDK;
import com.kintsugi.taxplatform.models.errors.HTTPValidationError;
import com.kintsugi.taxplatform.models.operations.GetOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGetResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws HTTPValidationError, Exception {

        SDK sdk = SDK.builder()
                .apiKeyHeader(System.getenv().getOrDefault("API_KEY_HEADER", ""))
            .build();

        GetOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGetResponse res = sdk.registrations().getOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGet()
                .registrationId("<id>")
                .xOrganizationId("org_12345")
                .call();

        if (res.responseGetOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGet().isPresent()) {
            System.out.println(res.responseGetOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGet().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   | Example                                                       |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `registrationId`                                              | *String*                                                      | :heavy_check_mark:                                            | The unique identifier of the registration.                    |                                                               |
| `xOrganizationId`                                             | *Optional\<String>*                                           | :heavy_check_mark:                                            | The unique identifier for the organization making the request | org_12345                                                     |

### Response

**[GetOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGetResponse](../../models/operations/GetOssCountriesForRegistrationV1RegistrationsRegistrationIdOssCountriesGetResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/HTTPValidationError | 422                               | application/json                  |
| models/errors/APIException        | 4XX, 5XX                          | \*/\*                             |