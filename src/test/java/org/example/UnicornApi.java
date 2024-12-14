package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornApi {
    @Test
    public void userShouldBeAbleCreateUnicorn(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); // Фильтра рест ашура для того что б в консоли видеть что кладется в запрос и ответ
        // given - when - then  BDD
        given()
                .body("{\n" +
                        "  \"name\": \"AppleJack\",\n" +
                        "  \"tailColor\": \"orange\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://crudcrud.com/api/d53814d6405b4b148603c1bf42e66af1/unicorn")
        .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"));

    }
    @Test
    public void userShouldBeAbleDeleteExistingUnicorn(){
        //Принципы разработки API тестов:
        //1) Атомарность
        //2) Тест сам себе готовит данные

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); // Фильтра рест ашура для того что б в консоли видеть что кладется в запрос и ответ
       // Шаг 1 Создание единорога
        String id = given()
                .body("{\n" +
                        "  \"name\": \"AppleJack\",\n" +
                        "  \"tailColor\": \"orange\"\n" +
                        "}")
                .contentType(ContentType.JSON)
        .when()
                .post("https://crudcrud.com/api/d53814d6405b4b148603c1bf42e66af1/unicorn")
        .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
        .extract()
                .path("_id");  // extract - вытаскивает значение из указанного поля

        //Шаг 2 Удаление единорога
        given()
                .delete("https://crudcrud.com/api/d53814d6405b4b148603c1bf42e66af1/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200);

        //Щаг 3 Проверка что единорог удалился
        given()
                .get("https://crudcrud.com/api/d53814d6405b4b148603c1bf42e66af1/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
