package org.vermilionturtle.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .formParam("title", "Quarkus")
                .formParam("author", "Oguzhan")
                .formParam("year", 2021)
                .formParam("genre", "Science")
            .when()
                .post("/api/books")
            .then()
                .statusCode(201)
                .body("ISBN_13", startsWith("13-"))
                .body("Title", startsWith("Quarkus"))
                .body("Author", startsWith("Oguzhan"))
                .body("Year_Of_Publication", is(2021))
                .body("Genre", is("Science"))
                .body("Creation_Date", startsWith("20"));
    }

}