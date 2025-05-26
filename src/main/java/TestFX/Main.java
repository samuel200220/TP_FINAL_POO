package TestFX;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Participant p1 = new Participant("P01", "Alice", "alice@email.com");
        Participant p2 = new Participant("P02", "Bob", "bob@email.com");

        // Créer le concert
        Conference conf = new Conference();
        conf.id = "C1";
        conf.nom = "IA 2025";
        conf.date = LocalDateTime.now();
        conf.lieu = "Yaoundé";
        conf.capaciteMax = 100;
        conf.setTheme("Intelligence Artificielle");
        conf.intervenants = Arrays.asList(p1, p2);

        Concert concert = new Concert();
        concert.id = "M1";
        concert.nom = "Rock Night";
        concert.date = LocalDateTime.now().plusDays(5);
        concert.lieu = "Douala";
        concert.capaciteMax = 500;
        concert.genreMusical="Rock DevOps";
        concert.artiste="Les DevCodeurs";

        List<Evenement> liste = List.of(concert, conf);
        Map<String, Evenement> evenements = new HashMap<>();

        evenements.put(conf.id, conf);
        evenements.put(concert.id, concert);


        // Sauvegarde
        Serialisation.sauvegarderJSON(evenements, "evenements.json");
        System.out.println("✅ Sauvegarde terminée.");

        // Chargement
        Map<String, Evenement> reloaded = Serialisation.chargerJSON("evenements.json");
//        for (Evenement e : reloaded) {
//            System.out.println("📄 Rechargé : " + e.nom + " à " + e.lieu);
//        }
        for (Map.Entry<String, Evenement> entry : reloaded.entrySet()) {
            String id = entry.getKey();
            Evenement e = entry.getValue();

            System.out.println("📌 ID : " + id);
            System.out.println("📄 Nom : " + e.nom);
            System.out.println("📍 Lieu : " + e.lieu);
            System.out.println("📆 Date : " + e.date);
            System.out.println("🎭 Type : " + e.getClass().getSimpleName());
            System.out.println("---------------------------");
        }

    }
}
