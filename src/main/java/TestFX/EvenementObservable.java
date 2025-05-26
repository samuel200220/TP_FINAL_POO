package TestFX;

import java.util.List;

public interface EvenementObservable {
    void ajouterObservateur(ParticipantObserver p);
    void retirerObservateur(ParticipantObserver p);
    void notifierObservateurs(String message);
}
