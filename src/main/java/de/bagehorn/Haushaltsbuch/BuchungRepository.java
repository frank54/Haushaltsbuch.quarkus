package de.bagehorn.Haushaltsbuch;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BuchungRepository {
    @Inject
    EntityManager em;

    @ConfigProperty(name = "buchung.input-datum-format") //, defaultValue = "YYYY-mm-dd")
    String datumFormat;

    @Transactional
    public void persist(final Buchung buchung) {
        em.persist(buchung);
    }

    @Transactional
    public List<Buchung> findAll() {
        return em.createQuery("SELECT buchung from Buchung buchung", Buchung.class).getResultList();
    }

    @Transactional
    public Optional<Buchung> findById(Long id) {
        return Optional.ofNullable(em.find(Buchung.class, id));
    }
}
