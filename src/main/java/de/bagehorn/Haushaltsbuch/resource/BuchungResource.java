package de.bagehorn.Haushaltsbuch.resource;

import de.bagehorn.Haushaltsbuch.repository.BuchungRepository;
import de.bagehorn.Haushaltsbuch.model.Buchung;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/v1/buchung")
@Produces(MediaType.APPLICATION_JSON)
public class BuchungResource {

    @Inject
    BuchungRepository repository;
    @Inject
    Logger logger;

    @GET
    public List<Buchung> getBuchungen() {
        logger.info("Alle Buchungen...");
        return repository.findAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBuchungen() {
        logger.info("Anzahl der Buchungen...");
        return repository.findAll().size();
    }

    @GET
    @Path("{id}")
    public Optional<Buchung> getBuchung(@PathParam("id") Long id) {
        logger.info("Buchung Nr." + id);
        return repository.findById(id);
    }
}
