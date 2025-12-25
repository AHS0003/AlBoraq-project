package SDIDproject;

public class Atlas extends Train{
    private static int currentIndexA = 0;
    private AtlasID atlasID;
    private final static int nmbr_train_atlas = 39 ; // nefss blan sh7al mn train
    public Atlas() {
        super("Atlas", 80, 400, 2, 5 );
        this.atlasID = AtlasID.values()[currentIndexA];
        this.setTrainID(this.atlasID.getValue());
        currentIndexA = (currentIndexA + 1) % AtlasID.values().length; // hed l3eyba heya li katb9a te3ti kula mera les codes dyel train
    }

    public static int getCurrentIndexA() {
        return currentIndexA;
    }

    public static void setCurrentIndexA(int currentIndexA) {
        Atlas.currentIndexA = currentIndexA;
    }

    public AtlasID getAtlasID() {
        return atlasID;
    }

    public void setAtlasID(AtlasID atlasID) {
        this.atlasID = atlasID;
    }
}
