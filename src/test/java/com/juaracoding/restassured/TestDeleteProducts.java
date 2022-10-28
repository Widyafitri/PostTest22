package com.juaracoding.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TestDeleteProducts {
    @Test
    public void testDelete() {

        when()
                .delete("https://mern-backend-8881.herokuapp.com/products/62e20a17f0e24546b900e037")
                .then()
                .statusCode(200)
                .log().all();
    }
}
