package com.prakharvarshney95.ex01_RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_Non_BDD_Style {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description ("Verify the POST req positive")
    @Test
    public void test_POST_Non_BDD_Style() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON);
                r.log().all().body(payload);

                Response response1 = r.when().log().all().post();

                ValidatableResponse vr = response1.then().log().all().statusCode(200);
    }
}
