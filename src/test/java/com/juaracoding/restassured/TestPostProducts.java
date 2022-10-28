package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPostProducts {

    @Test
    public void testPost() {
        JSONObject request = new JSONObject();
        request.put("_id", "62e20d24f0e24546b900e01717");
        request.put("name", "Apple");
        request.put("category", "Fruit");
        request.put("price", "30000");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(200)
                .log().all();
    }
}
