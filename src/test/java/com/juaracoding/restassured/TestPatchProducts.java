package com.juaracoding.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPatchProducts {

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("_id", "62e20d24f0e24546b900e043");
        request.put("name", "Bootcamp Juli 2022");
        request.put("category", "SQA");
        request.put("price", "25000");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/62e20d24f0e24546b900e043")
                .then()
                .statusCode(200)
                .log().all();
    }
}
