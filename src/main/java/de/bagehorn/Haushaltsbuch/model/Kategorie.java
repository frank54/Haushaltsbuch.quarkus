package de.bagehorn.Haushaltsbuch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;
import java.util.Optional;

@Entity
public class Kategorie extends PanacheEntity{
    public String name;
    public String beschreibung;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    public Typ typ;

    public static List<Kategorie> listByTyp(String typName) {
        return list("typ = ?1", typName.toUpperCase());
    }

    public static Optional<Kategorie> findByName(String kategorieName) {
        return find("name", kategorieName).firstResultOptional();
    }
}
