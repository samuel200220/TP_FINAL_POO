package TestFX;

import java.util.ArrayList;
import java.util.List;

public class Concert extends Evenement implements EvenementObservable{
    public String artiste;
    public String genreMusical;
    public List<ParticipantObserver> observateurs = new ArrayList<>();

    public Concert(){}
//    public Concert(String artiste, String genreMusical) {
//        this.artiste = artiste;
//        this.genreMusical = genreMusical;
//    }

    @Override
    public void ajouterObservateur(ParticipantObserver p) {
        observateurs.add(p);
    }

    @Override
    public void retirerObservateur(ParticipantObserver p) {
        observateurs.remove(p);
    }

    @Override
    public void notifierObservateurs(String message) {
        for (ParticipantObserver p : observateurs) {
            p.recevoirNotification(message);
        }
    }
    public void modifier(String nouveauLieu) {
        this.lieu = nouveauLieu;
        System.out.println("ℹ️ Le concert '" + nom + "' est déplacé à " + lieu);
        notifierObservateurs("📢 Le concert '" + nom + "' a été déplacé à : " + lieu);
    }


    @Override
    public void ajouterParticipant(Participant p) throws CapaciteMaxAtteinteException {
        observateurs.add(p);
    }

    public void annuler() {
        System.out.println("❌ Le concert '" + nom + "' est annulé.");
        notifierObservateurs("📢 Le concert '" + nom + "' a été annulé.");
    }

    @Override
    public void afficherDetails() {

    }
}
