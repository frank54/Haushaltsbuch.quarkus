package de.bagehorn.Haushaltsbuch.repository;

import java.util.List;
import java.util.Optional;

import de.bagehorn.Haushaltsbuch.model.Buchung;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BuchungRepository implements PanacheRepository<Buchung> {
    public List<Buchung> listByKategorie(String kategorieName) {
        return list("kategorie.name = ?1", Sort.descending("datum"), kategorieName);
    }
}
