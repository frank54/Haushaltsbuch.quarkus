package de.bagehorn.Haushaltsbuch;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Buchung {
    public int id;
    public String beschreibung;
    public double betrag;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    public Date datum;

    public Buchung(int id, String beschreibung, double betrag, Date datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.betrag = betrag;
        this.datum = datum;
    }
}
