package champollion;

import java.util.Date;

public class Intervention {
    private Date date;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;
    private TypeIntervention typeIntervention;
    private UE ue;

    public Intervention(Date date, int duree, boolean annulee, int heureDebut, TypeIntervention typeIntervention, UE ue) {
        this.date = date;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.typeIntervention = typeIntervention;
        this.ue = ue;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getTypeIntervention() {
        return typeIntervention;
    }
}
