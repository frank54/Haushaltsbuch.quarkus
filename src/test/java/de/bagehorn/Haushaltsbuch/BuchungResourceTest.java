package de.bagehorn.Haushaltsbuch;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BuchungResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/api/v1/buchung").then().statusCode(200).body(is("Hello RESTEasy"));
    }
}
