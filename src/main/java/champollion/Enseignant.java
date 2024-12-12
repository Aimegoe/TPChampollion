package champollion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static champollion.TypeIntervention.*;

/**
 * Un enseignant est caractérisé par les informations suivantes : son nom, son adresse email, et son service prévu,
 * et son emploi du temps.
 */
public class Enseignant extends Personne {
    HashMap<UE, ServicePrevu> listeDesServices = new HashMap<>();
    List<Intervention> listeDesInterventions = new ArrayList<>();
    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        double resultat = 0;
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        for (ServicePrevu unServicePrevu : listeDesServices.values()) {
            int somme = 0;
            somme += unServicePrevu.getVolumeCM();
            somme += unServicePrevu.getVolumeTP();
            somme += unServicePrevu.getVolumeTD();
            resultat += somme;
        }
        return (int)Math.round(resultat);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        double resultat = 0;
        String intitule = ue.getIntitule();

        // TODO: Implémenter cette méthode
        ServicePrevu unServicePrevu = listeDesServices.get(ue);
        if (unServicePrevu != null) {
            int somme = 0;
            somme += unServicePrevu.getVolumeCM();
            somme += unServicePrevu.getVolumeTP();
            somme += unServicePrevu.getVolumeTD();
            resultat += somme;
        } else {
            resultat = 0;
        }

        return (int)Math.round(resultat);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magistral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        if (listeDesServices.containsKey(ue)){
            ServicePrevu leService = listeDesServices.get(ue);
            leService.ajouterVolume(volumeCM, volumeTD, volumeTP);

        } else {
        ServicePrevu servicePrevu = new ServicePrevu(volumeCM, volumeTD, volumeTP);
        listeDesServices.put(ue, servicePrevu);
        }
    }

    public void ajouteIntervention(Intervention inter){
        for (Intervention uneIntervention: listeDesInterventions){
            if (uneIntervention != inter){
                listeDesInterventions.add(inter);
            }
        }


    }

    public boolean enSousService(){
        boolean resultat = false;
        if (this.heuresPrevues()<= 192){
        resultat = true;
        }
        return resultat;
    }

    public <typeIntervention> int resteAPlanifier(UE ue, typeIntervention typeIntervention){
        int resultat = 0;
        int volume = 0;
        if (listeDesServices.containsKey(ue)){
            switch (typeIntervention) {
                case CM:
                    volume = listeDesServices.get(ue).getVolumeCM();
                    break;
                case TD:
                    volume = listeDesServices.get(ue).getVolumeTD();
                    break;
                case TP:
                    volume = listeDesServices.get(ue).getVolumeTP();
                    break;
                default:
                    break;
            }


        } else { resultat = 0; }
            return resultat;
    }

}
