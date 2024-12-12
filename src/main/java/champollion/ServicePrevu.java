package champollion;

public class ServicePrevu {
    // TODO : implémenter cette classe
private int volumeCM;
private int volumeTD;
private int volumeTP;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void ajouterVolume(int volumeCM, int volumeTD, int volumeTP){
        this.volumeCM += volumeCM;
        this.volumeTD += volumeTD;
        this.volumeTP += volumeTP;
    }
}
