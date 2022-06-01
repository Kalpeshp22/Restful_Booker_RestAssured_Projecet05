package com.restful_booker_heorkuapp;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;

public class RestfullBookerHerokuappDeleteTest  extends TestBase {

    @Test
    public void deleteAllBookingInfo() {

        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token = " + token)
                .basePath("/booking")
                .pathParam("id", 827)
                .when()
                .delete("/{id}");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
