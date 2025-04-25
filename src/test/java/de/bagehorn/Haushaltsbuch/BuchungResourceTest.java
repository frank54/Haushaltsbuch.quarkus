package de.bagehorn.Haushaltsbuch;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BuchungResourceTest {

    @Test
    public void shouldGetAlleBuchungen() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
        when()
                .get("/api/v1/buchung").
        then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    public void shouldCountAlleBuchungen() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
                when()
                .get("/api/v1/buchung/count").
                then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    public void shouldGetBuchung() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1).
                when()
                .get("/api/v1/buchung/{id}").
                then()
                .statusCode(200)
                .body("beschreibung", is("Coop"))
                .body("betrag", is("150.00 SFr"))
                .body("buchungsdatum", is("2025-03-31"));
    }

}
