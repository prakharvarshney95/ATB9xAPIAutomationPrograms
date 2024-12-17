package com.prakharvarshney95.ex01_RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_DELETE_Non_BDD_Style {

    //PUT

    //token, booking ID - A

//    public void get_token(){}
//    public void get_booking_id(){}

    @Description("Verify the DELETE req for Restful booker APIs")
    @Test
    public void test_DELETE_Non_BDD_Style() {

        String token = "4d7ee64ac89f985";
        String bookingid = "736";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.log().all();

        Response response = requestSpecification.when().log().all().delete();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(201);

    }
}
