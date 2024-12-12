package com.prakharvarshney95.ex01.RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDD_style {

        @Test
    public void test_GET_req_Positive(){
            String pincode = "110096";

            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                    .when().log().all().get()
                    .then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_req_Negative(){
        String pincode = "_1";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }

    }

