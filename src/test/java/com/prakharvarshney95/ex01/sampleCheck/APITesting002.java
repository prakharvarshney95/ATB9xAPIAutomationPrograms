package com.prakharvarshney95.ex01.sampleCheck;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {

        // full URL :- https://api.zippopotam.us/IN/110096
        // base URI :- https://api.zippopotam.us
        // path :- /IN/110096

        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/110096")
                .when()
                     .get()
                .then().log().all().statusCode(200);
    }
}
