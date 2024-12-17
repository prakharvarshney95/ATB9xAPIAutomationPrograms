package com.prakharvarshney95.ex01.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_Non_BDD_Style {

    //PUT

    //token, booking ID - A

//    public void get_token(){}
//    public void get_booking_id(){}

    @Description("Verify the PUT req for Restful booker APIs")
    @Test
    public void test_PUT_Non_BDD_Style() {

        String token = "9b0b9a6c949a3bf";
        String bookingid = "1990";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Alex\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 1654,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.log().all().body(payloadPUT);

        Response response = requestSpecification.when().log().all().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
}
