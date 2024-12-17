package com.prakharvarshney95.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.request;

import  org.hamcrest.Matchers;

public class APITesting024_RestAssured_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingid;
    
@Test
    public void test_POST() {

    String payload_POST = "{\n" +
            "        \"firstname\": \"Jim\",\n" +
            "        \"lastname\": \"Brown\",\n" +
            "        \"totalprice\": 111,\n" +
            "        \"depositpaid\": true,\n" +
            "        \"bookingdates\": {\n" +
            "            \"checkin\": \"2018-01-01\",\n" +
            "            \"checkout\": \"2019-01-01\"\n" +
            "        },\n" +
            "        \"additionalneeds\": \"Breakfast\"\n" +
            "    }";

    requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking");
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.body(payload_POST).log().all();

    Response response = requestSpecification.when().post();

    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);

    // Rest Assured :- import  org.hamcrest.Matchers;
    // Matcher.equalto()

    validatableResponse.body("booking.firstname", Matchers.equalTo("Jim"));
    validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
    validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
    validatableResponse.body("bookingid", Matchers.notNullValue());
}


}

