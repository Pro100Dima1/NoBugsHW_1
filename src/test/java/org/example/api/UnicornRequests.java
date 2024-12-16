package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.api.models.Unicorn;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    public static Unicorn createUnicorn(Unicorn unicorn){
        // given - when - then  BDD
        // Если объект создан не в классе, а в методе и класс не хранит состояния объекта, то можно делать методы static
        // тем самым выхывая методы класса без создания объекта, просто через точку
        String unicornJson = null;
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn); // Объект Маппер Джексона.
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
        .extract()
                .as(Unicorn.class, ObjectMapperType.GSON);
                  // extract - вытаскивает значение из указанного поля
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
