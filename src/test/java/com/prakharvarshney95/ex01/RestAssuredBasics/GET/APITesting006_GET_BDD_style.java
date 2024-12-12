package com.prakharvarshney95.ex01.RestAssuredBasics.GET;

import io.restassured.RestAssured;

public class APITesting006_GET_BDD_style {
    public static void main(String[] args) {

        String pincode = "110096";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);


        pincode = "-563";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }
}