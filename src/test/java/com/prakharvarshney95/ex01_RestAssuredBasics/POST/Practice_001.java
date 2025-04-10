package com.prakharvarshney95.ex01_RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Practice_001 {

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
