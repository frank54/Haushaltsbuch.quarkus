-- Kategorien
INSERT INTO Kategorie (id, name, beschreibung, typ) VALUES
(1, 'Frank', 'Franks Salär inklusive Bonus und anderer Sonderzahlungen', 'EINNAHMEN'),
(2, 'Martina', 'Martinas Salär inklusive Bonus und anderer Sonderzahlungen', 'EINNAHMEN'),
(3, 'Sondereinnahmen', 'Einnahmen, die keine Saläre sind, wie z.B. Steuerrückzahlungen oder Geschenke', 'EINNAHMEN'),
(4, 'Steuer', 'Rückstellungen für Steuerzahlungen', 'AUSGABEN'),
(5, 'Vorsorge', 'Jährliche gebundene (Säule 3a) und ungebundene (Säule 3b) Vorsorge', 'AUSGABEN'),
(6, 'Wohnen / Haus / Garten', 'Hypothekarzinsen, Unterhaltskosten z.B. Strom, Aufwendungen für den Garten', 'AUSGABEN'),
(7, 'Haushalt', 'Aufwendungen für nicht-Lebensmittel, z.B. Reinigungsmittel, Möbel, Lampen', 'AUSGABEN'),
(8, 'Nahrung / Genuss', 'Lebensmittel und Waren des täglichen Bedarfs', 'AUSGABEN'),
(9, 'Kind', 'Kinderbetreuung, Kinderkleidung und andere Kind-bezogene Ausgaben', 'AUSGABEN'),
(10, 'Versicherung', 'Versicherungen (ohne Krankenkasse)', 'AUSGABEN'),
(11, 'Apanage', 'Monatliche Summe für den persönlichen Bedarf', 'AUSGABEN'),
(12, 'Mobilität', 'Benzin, Autowartung, Parkgebühren, Bahntickets, andere Kosten für Mobilität', 'AUSGABEN'),
(13, 'Gesundheit', 'Arztrechnungen, Medikamente, Krankenkassen', 'AUSGABEN'),
(14, 'Kommunikation', 'Telefon, Internet, TV', 'AUSGABEN'),
(15, 'Unterhaltung / Erholung / Kultur', 'Reisen, Ausflüge, Restaurantbesuche, Zeitungen', 'AUSGABEN'),
(16, 'Ausbildung / Beruf', 'Kurskosten, Lehrbücher, berufsbezogene Ausgaben', 'AUSGABEN'),
(17, 'Barbezug', 'Barbezüge am Automaten', 'AUSGABEN'),
(18, 'Sparen', 'Überweisungen auf die Sparkonti, Negativbeträge sind Überweisungen vom Sparkonto', 'AUSGABEN'),
(19, 'Spenden', 'Zuwendungen an gemeinnützige Institutionen und Vereine', 'AUSGABEN'),
(20, 'Bauen', 'Ausgaben im Rahmen des Hausbaus und Folgekosten', 'AUSGABEN'),
(21, 'Anderes', 'Andere Ausgaben, z.B. Geschenke', 'AUSGABEN');
-- Buchungen
INSERT INTO Buchung (id, beschreibung, betrag, datum, kategorie_fk) VALUES
(1, 'Coop', 150.0, '2025-03-31', 8),
(2, 'Hypothek', 500.0, '2025-02-01', 6),
(3, 'Hypothek', 500.0, '2025-03-01', 6);
