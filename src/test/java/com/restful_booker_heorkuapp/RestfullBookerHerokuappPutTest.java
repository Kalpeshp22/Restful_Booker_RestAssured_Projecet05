package com.restful_booker_heorkuapp;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullBookerHerokuappPutTest extends TestBase {

    @Test
    public void updateBookingWithPut() {
         CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();

        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        RestFullPojo restFulPojo = new RestFullPojo();

        restFulPojo.setFirstname("Dia");
        restFulPojo.setLastname("Patel");
        restFulPojo.setTotalprice(501);
        restFulPojo.setDepositpaid(true);
        restFulPojo.setBookingdates(bookingdates);
        restFulPojo.setAdditionalneeds("Vegetrian Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token =" + token)
                .basePath("/booking")
                .pathParam("id", 842 )
                .body(restFulPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
        System.out.println(response.statusCode());

    }
}
