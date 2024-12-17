package com.prakharvarshney95.ex01_RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_Non_BDD_Style {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description ("Verify the Get req positive : 110096 Input")
    @Test
    public void test_GET_Non_BDD_Style() {

        String pincode = "110096";
        r = RestAssured.given();
                r.baseUri("https://api.zippopotam.us");
                r.basePath("/IN/" + pincode);
               response =  r.when().log().all().get();
                vr = response.then().log().all().statusCode(200);
    }

    @Description ("Verify the Get req Negative : -475 Input")
    @Test
    public void test_Non_BDD_style_GET_negative() {

        String pincode = "-475";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);
    }

      @Description ("Verify the Get req Negative : -w4**^&5 Input")
      @Test
        public void test_Non_BDD_style_GET_negative2() {

            String pincode = "-w4**^&5";
            r = RestAssured.given();
            r.baseUri("https://api.zippopotam.us");
            r.basePath("/IN/" + pincode);
            response =  r.when().log().all().get();
            vr = response.then().log().all().statusCode(404);

    }
}
