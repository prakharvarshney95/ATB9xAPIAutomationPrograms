package com.prakharvarshney95.ex01.RestAssuredBasics.POST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class API_Automation_assignment {

        @Test
        public void API_Automation_assignment_devnagri() {

            RestAssured.baseURI = "https://proxy.devnagri.dev";

            String requestBody = "{\n" +
                    "    \"api_key\": \"devnagri_6b93ffe4d92111edb416022fa85a4b46\",\n" +
                    "    \"domain\": \"https://mygov.devnagri.live\"\n" +
                    "}";

            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "insomnia/9.3.3")
                    .body(requestBody)
                    .when()
                    .post("/api/proxy/clear-all-cache");

            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Time: " + response.getTime() + " ms");
            System.out.println("Response Body:\n" + response.getBody().asPrettyString());
        }
    }
