package com.prakharvarshney95.ex05_payload_management;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting026_payload_Map {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {

//        String payload_POST = "{\n" +
//                "        \"firstname\": \"Jim\",\n" +
//                "        \"lastname\": \"Brown\",\n" +
//                "        \"totalprice\": 111,\n" +
//                "        \"depositpaid\": true,\n" +
//                "        \"bookingdates\": {\n" +
//                "            \"checkin\": \"2018-01-01\",\n" +
//                "            \"checkout\": \"2019-01-01\"\n" +
//                "        },\n" +
//                "        \"additionalneeds\": \"Breakfast\"\n" +
//                "    }";

        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname","Jim");
        jsonBodyUsingMap.put("lastname","Brown");
        jsonBodyUsingMap.put("depositpaid",true);
        jsonBodyUsingMap.put("totalprice","111");

        Map<String,Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("booking.firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        //TestNG Assertion

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "Jim");
        Assert.assertEquals(lastname, "Brown");

        //AssertJ (3rd - Lib to assertion)

        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Jim").isNotNull().isNotEmpty().isAlphanumeric().isNotBlank();

//            String s = ""; //Empty
//            String s2 = " "; //blank


    }


}
