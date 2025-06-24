package de.bagehorn.Haushaltsbuch.resource;

import de.bagehorn.Haushaltsbuch.repository.BuchungRepository;
import de.bagehorn.Haushaltsbuch.model.Buchung;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/v1/buchung")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class BuchungResource {

    @Inject
    BuchungRepository repository;
    @Inject
    Logger logger;

    @Transactional(Transactional.TxType.REQUIRED)
    @POST
    public Response addBuchung(Buchung buchung, @Context UriInfo uriInfo) {
        logger.info("Neue Buchung " + buchung.getBeschreibung());
        repository.persist(buchung);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(buchung.getId()));
        return Response.created(builder.build()).build();
    }

    @GET
    public List<Buchung> getBuchungen() {
        logger.info("Alle Buchungen...");
        return repository.listAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Long countBuchungen() {
        logger.info("Anzahl der Buchungen...");
        return repository.count();
    }

    @GET
    @Path("{id}")
    public Buchung getBuchung(@PathParam("id") Long id) {
        logger.info("Buchung Nr." + id);
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("kategorie/{kategorieName}")
    public List<Buchung> getBuchungByKategorie(@PathParam("kategorieName") String kategorie) {
        logger.info("Buchungen für Kategorie " + kategorie);
        return repository.listByKategorie(kategorie);
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public void deleteBuchung(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}
