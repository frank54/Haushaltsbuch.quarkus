package de.bagehorn.Haushaltsbuch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Kategorie extends PanacheEntity{
    public String name;
    public String beschreibung;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    public Typ typ;
}
