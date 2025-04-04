package de.bagehorn.Haushaltsbuch;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Path("/api/v1/buchung")
public class BuchungResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Buchung> getBuchungen() {
        try {
            return List.of(
                new Buchung(1, "Coop", 150.0, new SimpleDateFormat("yyyy-MM-dd").parse("2025-03-31")),
                new Buchung(2, "Strom", 230.0, new SimpleDateFormat("yyyy-MM-dd").parse("2025-03-25"))
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBuchungen() {
        return getBuchungen().size();
    }

    @GET
    @Path("{id}")
    public Optional<Buchung> getBuchung(@PathParam("id") int id) {
        return getBuchungen().stream().filter(buchung -> buchung.id == id).findFirst();
    }
}
