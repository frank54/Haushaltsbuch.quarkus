package de.bagehorn.Haushaltsbuch.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuchungResourceTest {

    @Test
    @TestTransaction
    void shouldGetAlleBuchungen() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
        when()
                .get("/api/v1/buchung").
        then()
                .statusCode(200)
                .body("size()", is(3));
    }

    @Test
    @TestTransaction
    void shouldCountAlleBuchungen() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
                when()
                .get("/api/v1/buchung/count").
                then()
                .statusCode(200)
                .body(is("3"));
    }

    @Test
    @TestTransaction
    void shouldGetBuchung() {
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

    @Test
    @TestTransaction
    void shouldGetBuchungByKategorie() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("kategorieName","Nahrung / Genuss").
                when()
                .get("/api/v1/buchung/kategorie/{kategorieName}").
                then()
                .statusCode(200)
                .body("size()", is(1));
    }
}
