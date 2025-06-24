package de.bagehorn.Haushaltsbuch.resource;

import de.bagehorn.Haushaltsbuch.model.Buchung;
import de.bagehorn.Haushaltsbuch.repository.BuchungRepository;
import io.quarkus.panache.common.Sort;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/page/v1/buchung")
@Produces(MediaType.TEXT_HTML)
public class BuchungPage {

    @Inject
    BuchungRepository repository;
    @Inject
    Logger logger;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance buchung(Buchung buchung);
        public static native TemplateInstance buchungen(List<Buchung> buchungen);
    }

    @GET
    @Path("{id}")
    public TemplateInstance showBuchungById(@PathParam("id") Long id) {
        logger.info("HTML Buchung #" + id);
        return Templates.buchung(repository.findById(id));
    }

    @GET
    public TemplateInstance showBuchungen() {
        logger.info("HTML alle Buchungen");
        return Templates.buchungen(repository.listAll(Sort.descending("datum")));
    }
}
