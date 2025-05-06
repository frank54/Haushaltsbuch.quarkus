package de.bagehorn.Haushaltsbuch;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BuchungRepository {
    @ConfigProperty(name = "buchung.input-datum-format") //, defaultValue = "YYYY-mm-dd")
    String datumFormat;

    public List<Buchung> getBuchungen() {
        try {
            return List.of(
                    new Buchung(1, "Coop", new BigDecimal("150.00"), new SimpleDateFormat(datumFormat).parse("31.3.2025")),
                    new Buchung(2, "Strom", new BigDecimal("230.00"), new SimpleDateFormat(datumFormat).parse("25.3.2025"))
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Buchung> getBuchung(int id) {
        return getBuchungen().stream().filter(buchung -> buchung.getId() == id).findFirst();
    }
}
