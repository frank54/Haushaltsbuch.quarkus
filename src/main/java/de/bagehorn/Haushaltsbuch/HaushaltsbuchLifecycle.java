package de.bagehorn.Haushaltsbuch;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.logging.Logger;

@ApplicationScoped
public class HaushaltsbuchLifecycle {
    public static final Logger LOGGER = Logger.getLogger("Haushaltsbuch");

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("""
                 /$$   /$$                               /$$                 /$$   /$$              /$$                           /$$
                | $$  | $$                              | $$                | $$  | $$             | $$                          | $$
                | $$  | $$  /$$$$$$  /$$   /$$  /$$$$$$$| $$$$$$$   /$$$$$$ | $$ /$$$$$$   /$$$$$$$| $$$$$$$  /$$   /$$  /$$$$$$$| $$$$$$$
                | $$$$$$$$ |____  $$| $$  | $$ /$$_____/| $$__  $$ |____  $$| $$|_  $$_/  /$$_____/| $$__  $$| $$  | $$ /$$_____/| $$__  $$
                | $$__  $$  /$$$$$$$| $$  | $$|  $$$$$$ | $$  \\ $$  /$$$$$$$| $$  | $$   |  $$$$$$ | $$  \\ $$| $$  | $$| $$      | $$  \\ $$
                | $$  | $$ /$$__  $$| $$  | $$ \\____  $$| $$  | $$ /$$__  $$| $$  | $$ /$$\\____  $$| $$  | $$| $$  | $$| $$      | $$  | $$
                | $$  | $$|  $$$$$$$|  $$$$$$/ /$$$$$$$/| $$  | $$|  $$$$$$$| $$  |  $$$$//$$$$$$$/| $$$$$$$/|  $$$$$$/|  $$$$$$$| $$  | $$
                |__/  |__/ \\_______/ \\______/ |_______/ |__/  |__/ \\_______/|__/   \\___/ |_______/ |_______/  \\______/  \\_______/|__/  |__/""");
    }

    void onStop(@Observes ShutdownEvent event) {
        LOGGER.info("Haushaltsbuch wird beendet.");
    }
}
