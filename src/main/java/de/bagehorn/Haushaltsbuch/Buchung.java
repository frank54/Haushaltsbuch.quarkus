package de.bagehorn.Haushaltsbuch;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

public class Buchung {
    private final int id;
    private String beschreibung;
    private BigDecimal betrag;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    @JsonProperty("buchungsdatum")
    private Date datum;

    public Buchung(int id, String beschreibung, BigDecimal betrag, Date datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.betrag = betrag;
        this.datum = datum;
    }

    @JsonGetter("id")
    public int getId() {
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
        return betrag.toPlainString() + " SFr";
    }

    @JsonGetter("buchungsdatum")
    public Date getDatum() {
        return datum;
    }

    @JsonSetter("beschreibung")
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @JsonSetter("betrag")
    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    @JsonSetter("buchungsdatum")
    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
