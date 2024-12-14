package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornApi {
    @BeforeAll
    public static void setUpTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); // Фильтра рест ашура для того что б в консоли видеть что кладется в запрос и ответ
        RestAssured.baseURI = "https://crudcrud.com/api/d53814d6405b4b148603c1bf42e66af1"; // Базовый урл. Он автоматически подставляется в методах post, get итд
        // Принцип программирования DRY Do Not Repeat Yourself: Если пишешь один и тот же код дважды, он должен быть вынесен в метод
    }

    @Test
    public void userShouldBeAbleCreateUnicorn(){
         UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"AppleJack\",\n" +
                "  \"tailColor\": \"orange\"\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleChangeTailColor(){
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"AppleJack\",\n" +
                "  \"tailColor\": \"orange\"\n" +
                "}");
        UnicornRequests.changeTailColor(id, "{\n" +
                "  \"name\": \"AppleJack\",\n" +
                "  \"tailColor\": \"blue\"\n" +
                "}");

    }


    @Test
    public void userShouldBeAbleDeleteExistingUnicorn(){
        //Принципы разработки API тестов:
        //1) Атомарность
        //2) Тест сам себе готовит данные

       // Шаг 1 Создание единорога
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"AppleJack\",\n" +
                "  \"tailColor\": \"orange\"\n" +
                "}");

        //Шаг 2 Удаление единорога
        UnicornRequests.deleteUnicorn(id);

        //Щаг 3 Проверка что единорог удалился
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
