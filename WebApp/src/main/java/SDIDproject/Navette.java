package SDIDproject;

public class Navette extends Train {
    private static int currentIndexN = 0;
    private NavetteID navetteID;
    private final static int nmbr_train_navette = 99 ; // sh7al d navette tberkelah

    public Navette() {
        super("Navette", 80, 400, 2, 5);
        this.navetteID = NavetteID.values()[currentIndexN];
        this.setTrainID(this.navetteID.getValue());
        currentIndexN = (currentIndexN + 1) % NavetteID.values().length;// hed l3eyba heya li katb9a te3ti kula mera les codes dyel train
    }
    public static int getCurrentIndexN() {
        return currentIndexN;
    }

    public static void setCurrentIndexN(int currentIndexN) {
        Navette.currentIndexN = currentIndexN;
    }

    public NavetteID getNavetteID() {
        return navetteID;
    }

    public void setNavetteID(NavetteID navetteID) {
        this.navetteID = navetteID;
    }

}
