package SDIDproject;

import java.util.ArrayList;
import java.util.Iterator;

public class Station {
    private int stationID;
    // Lfer9 mabin Station name u Vile station heya tqder f mdina we7da ykunu bzf dyel station b7al Casa , feha port voyageur oasis ain sebaa ....
    private String stationName;
    private String VilleStation;
    private ArrayList<Train> trains; // elash dert liste dyel les train ? 7it fl gare makikunsh a train wa7ad kinin li kijiw f nefss lweqt dekshi la gare ikuu feh bzaf dyel les train li ghaden nkhebiwhum f list
    // Constructeur kicree lena la gare dyelna shnu smitu ina mdina feha u lcode unique dyelu li hena an3tiwh leha fl creation , tqder ta heya der leha static (ela StationID) mais rah les gares mhdudin 3endum limite  mashe b7al voyageur illimitee
    public Station(int stationID, String stationName, String VilleStation) {
        this.stationID = stationID;
        this.stationName = stationName;
        this.VilleStation =VilleStation;
        this.trains = new ArrayList<>();
    }
    // Hadu getters u setters
    public int getStationID() {
        return stationID;
    }
    public void setStationID(int stationID) {
        this.stationID = stationID;
    }
    public String getStationName() {
        return stationName;
    }
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    public String getVilleStation() {
        return VilleStation;
    }
    public void setVilleStation(String villeStation) {
        VilleStation = villeStation;
    }
    public ArrayList<Train> getTrains() {
        return trains;
    }
    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }
    // henaya kanzidu train f station fesh kidkhel leha
    public void addTrain(Train train) {
        if (!trains.contains(train)) { // henaya  f hed if chefna wesh train kin wla la , ila makansh rah anziduh makansh ayduz l else
            trains.add(train);
        } else {
            System.out.println("Le train numero : " + train.getTrainID() + "est deja dans la station : " + stationName);
        }
    }
    // henaya kanm7iw train mli kikhroj mn la gare nefss principe li ankhedmu b7all addTrain , ila kan train anm7iwh makansh rah baqe mawsselsh wela msha
    public void deleteTrain(Train train) {
        if (trains.contains(train)) {
            trains.remove(train);
            System.out.println("Le train numero : " + train.getTrainID() + " a quitte le station de  : " + stationName);
        } else {
            System.out.println("Le train numero : " + train.getTrainID() + " n'a pas encore arriver a cette station : " + stationName);
        }
    }
    // Henaya shi wa7ad yqder bgha yshuf les train li kinin f station kitel3u leh bles details dyelu
    public void afficherTrains() {
        if (trains.isEmpty()) {
            System.out.println("Aucun train dans le station de  : " + stationName);
        } else {
            Iterator<Train> it = trains.iterator();
            while (it.hasNext()) {
                Train train = it.next();
                System.out.println(train.toString());
            }
        }
    }
    // toString bassla kat3tik bref presentation ela La gare
    @Override
    public String toString() {
        return "Station : " +
                "stationID = " + stationID +
                ", stationName = " + stationName + '\'' +
                ", VilleStation = " + VilleStation;
    }
}
