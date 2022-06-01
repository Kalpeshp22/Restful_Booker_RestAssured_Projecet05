package com.restful_booker_heorkuapp;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullBookerHerokuappPostTest extends TestBase {

    @Test
    public void createBookingTest() {

        Map<String, String> bookingdates = new HashMap<>(); // creating map variable which is key and value
        bookingdates.put("checkin", "2021-01-01");
        bookingdates.put("checkout", "2021-02-01");

        RestFullPojo restFulPojo = new RestFullPojo();
        restFulPojo.setFirstname("Diya");
        restFulPojo.setLastname("Patel");
        restFulPojo.setTotalprice(151);
        restFulPojo.setDepositpaid(true);
        restFulPojo.setBookingdates(bookingdates);
        restFulPojo.setAdditionalneeds("Vegetrian Dinner");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(restFulPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
