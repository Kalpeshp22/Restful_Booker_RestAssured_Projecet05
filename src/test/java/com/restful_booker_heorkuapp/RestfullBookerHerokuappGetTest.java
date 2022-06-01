package com.restful_booker_heorkuapp;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;

public class RestfullBookerHerokuappGetTest extends TestBase {

    @Test
    public void getAllBookingInfo() {
        Response response = given()
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
        System.out.println(response.statusCode());
    }

    @Test
    public void getSingleBookingInfo() {
        Response response = given()
                .basePath("/booking")
                .pathParam("id", 780)
                .when()
                .get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
