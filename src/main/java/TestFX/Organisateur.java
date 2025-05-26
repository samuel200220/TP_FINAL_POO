package TestFX;
import java.util.ArrayList;
import java.util.List;

public class Organisateur extends Participant{
    public Organisateur(String id, String nom, String email) {
        super(id, nom, email);
    }
    List<Evenement> evenementsOrganises = new ArrayList<>();
}
