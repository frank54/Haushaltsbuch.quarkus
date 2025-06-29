package de.bagehorn.Haushaltsbuch.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.eclipse.microprofile.config.ConfigProvider;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Buchung {
    @Id
    @GeneratedValue
    private Long id;
    private String beschreibung;
    private BigDecimal betrag;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    @JsonProperty("buchungsdatum")
    private Date datum;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kategorie_fk", nullable = false)
    @JsonProperty("kategorie")
    private Kategorie kategorie;

    public Buchung() {}

    public Buchung(final String beschreibung, final BigDecimal betrag, final Date datum, final Kategorie kategorie) {
        this.beschreibung = beschreibung;
        this.betrag = betrag;
        this.datum = datum;
        this.kategorie = kategorie;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("beschreibung")
    public String getBeschreibung() {
        return beschreibung;
    }

    @JsonIgnore
    public BigDecimal getBetrag() {
        return betrag;
    }

    @JsonGetter("betrag")
    public String getBetragStr() {
        String waehrung = ConfigProvider.getConfig().getValue("buchung.waehrung", String.class);
        return betrag.toPlainString() + " " + waehrung;
    }

    @JsonGetter("buchungsdatum")
    public Date getDatum() {
        return datum;
    }

    @JsonSetter("beschreibung")
    public void setBeschreibung(final String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @JsonSetter("betrag")
    public void setBetrag(final BigDecimal betrag) {
        this.betrag = betrag;
    }

    @JsonSetter("buchungsdatum")
    public void setDatum(final Date datum) {
        this.datum = datum;
    }

    @JsonGetter("kategorie")
    public String getKategorie() { return kategorie.name; }
}
