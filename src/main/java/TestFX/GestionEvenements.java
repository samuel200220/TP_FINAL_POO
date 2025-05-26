package TestFX;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GestionEvenements {

    private static GestionEvenements instance;

    private Map<String, Evenement> evenements;

    private GestionEvenements() {
        evenements = new HashMap<>();
    }

    public static synchronized GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }

    public void ajouterEvenement(Evenement e) throws EvenementDejaExistantException {
        if (evenements.containsKey(e.id)) {
            throw new EvenementDejaExistantException("Événement déjà existant !");
        }
        evenements.put(e.id, e);
    }

    public void supprimerEvenement(String id) {
        evenements.remove(id);
    }

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }
}

