package TestFX;
import java.util.ArrayList;
import java.util.List;

public class Conference extends Evenement implements EvenementObservable{
    private String theme;
    List<Participant> intervenants = new ArrayList<>();

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public Conference(){}


    @Override
    public void ajouterParticipant(Participant p) throws CapaciteMaxAtteinteException {
        intervenants.add(p);
    }

    @Override
    public void annuler() {
        System.out.println("❌ Le concert '" + nom + "' est annulé.");
        notifierObservateurs("📢 Le concert '" + nom + "' a été annulé.");
    }

    @Override
    public void afficherDetails() {

    }

    @Override
    public void ajouterObservateur(ParticipantObserver p) {

    }

    @Override
    public void retirerObservateur(ParticipantObserver p) {

    }

    @Override
    public void notifierObservateurs(String message) {

    }
}
