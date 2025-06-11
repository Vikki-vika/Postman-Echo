package ru.netology.test;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldReturnSentData() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные
                // Выполняемые действия
                .when().log().all()
                .post("/post")
                // Проверки
                .then()
                .log().all()
                .statusCode(200)
                .body("incorrect data", equalTo("some data")) // проверка что данные вернулись в поле "data"
        ;
    }
}
