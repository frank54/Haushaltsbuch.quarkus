package de.bagehorn.Haushaltsbuch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Buchung {
    private final int id;
    private String beschreibung;
    private double betrag;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    @JsonProperty("buchungsdatum")
    private Date datum;

    public Buchung(int id, String beschreibung, double betrag, Date datum) {
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

    @JsonGetter("betrag")
    public String getBetrag() {
        return betrag + " SFr";
    }

    @JsonGetter("buchungsdatum")
    public Date getDatum() {
        return datum;
    }
}
