package org.example.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String createUnicorn(String body){
        // given - when - then  BDD
        return given()
                .body(body)
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
        .extract()
                .path("_id");  // extract - вытаскивает значение из указанного поля
    }

    public static void deleteUnicorn(String id){
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static void changeTailColor(String id, String body){
        given()
                .body(body)
                .contentType(ContentType.JSON)
        .when()
                .put("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200);
    }
}
