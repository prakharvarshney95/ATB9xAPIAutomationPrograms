package com.prakharvarshney95.ex01_RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Dummy_POST_API {

  
      public static void main(String[] args) {
            // Set the base URI
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

            // ========== POST Request ==========
            System.out.println("Sending POST request...");
            String requestBody = "{\n" +
                    "  \"title\": \"foo\",\n" +
                    "  \"body\": \"bar\",\n" +
                    "  \"userId\": 1\n" +
                    "}";

            Response postResponse = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/posts")
                    .then()
                    .statusCode(201)
                    .body("title", equalTo("foo"))
                    .body("body", equalTo("bar"))
                    .body("userId", equalTo(1))
                    .extract().response();

            int postId = postResponse.jsonPath().getInt("id");
            System.out.println("Post created with ID: " + postId);

            // ========== GET Request ==========
            System.out.println("Sending GET request...");
            given()
                    .pathParam("id", postId)
                    .when()
                    .get("/posts/{id}")
                    .then()
                    .statusCode(200)
                    .body("id", equalTo(postId));
        }
    }

