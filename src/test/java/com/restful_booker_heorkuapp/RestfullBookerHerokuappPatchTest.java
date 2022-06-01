package com.restful_booker_heorkuapp;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;

public class RestfullBookerHerokuappPatchTest extends TestBase {

    @Test
    public void patchTest() {
        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(" Jiya");
        bookingPojo.setLastname("patel");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token =" + token)
                .basePath("/booking")
                .pathParam("id",  842)
                .body(bookingPojo)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
        System.out.println(response.statusCode());
    }

}
