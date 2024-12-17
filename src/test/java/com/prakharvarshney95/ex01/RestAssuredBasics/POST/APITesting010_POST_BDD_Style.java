package com.prakharvarshney95.ex01.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_BDD_Style {

    @Description ("Verify the POST req positive")
    @Test
    public void test_POST_BDD_Style() {

        //https://restful-booker.herokuapp.com/auth

        //{
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        // Content-Type : application/json


        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all().body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }
}
