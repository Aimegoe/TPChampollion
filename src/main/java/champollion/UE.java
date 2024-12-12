package champollion;

public class UE {
    private int heureCM;
    private int heureTD;
    private int heureTP;
    private final String myIntitule;

    public UE(String intitule) {
        myIntitule = intitule;
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeureCM() {
        return heureCM;
    }

    public int getHeureTD() {
        return heureTD;
    }

    public int getHeureTP() {
        return heureTP;
    }
}
