package de.bagehorn.Haushaltsbuch;

import jakarta.enterprise.context.ApplicationScoped;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BuchungRepository {
    public List<Buchung> getBuchungen() {
        try {
            return List.of(
                    new Buchung(1, "Coop", 150.0, new SimpleDateFormat("yyyy-MM-dd").parse("2025-03-31")),
                    new Buchung(2, "Strom", 230.0, new SimpleDateFormat("yyyy-MM-dd").parse("2025-03-25"))
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Buchung> getBuchung(int id) {
        return getBuchungen().stream().filter(buchung -> buchung.getId() == id).findFirst();
    }
}
