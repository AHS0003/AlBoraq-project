package SDIDproject;

public class Boraq extends Train {
    private static int currentIndexB = 0;
    private BoraqID boraqID;
    private final static int nmbr_train_boraq = 12; // sh7al mn train kin

    public Boraq() {
        super("Boraq", 80, 400, 2, 5);
        this.boraqID = BoraqID.values()[currentIndexB];
        this.setTrainID(this.boraqID.getValue());
        currentIndexB = (currentIndexB + 1) % BoraqID.values().length; // hed l3eyba heya li katb9a te3ti kula mera les codes dyel train
    }

    public static int getCurrentIndex() {
        return currentIndexB;
    }

    public static void setCurrentIndex(int currentIndex) {
        Boraq.currentIndexB = currentIndex;
    }

    public BoraqID getBoraqID() {
        return boraqID;
    }

    public void setBoraqID(BoraqID boraqID) {
        this.boraqID = boraqID;
    }
}
