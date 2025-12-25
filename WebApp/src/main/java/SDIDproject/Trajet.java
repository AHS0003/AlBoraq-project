package SDIDproject;

import java.util.Iterator;
import java.util.LinkedList;
// hed lclass heya trajet li kidir train mnin yduz u kulshi
public class Trajet {
    private int id_trajet;
    private Station stationDepartT; // Station Depart
    private Station stationArriveT; // Station arrivee
    private Train train;
    private LinkedList<Station> stations; // Liste dyel les station li ayduz elihum + elash dert linkedlistu mashe arraylist (Linkedlist feha des methode li kidiwk nishan lewel u lekher dyel list blama tqeleb b7al lined list , shuf lconstructeur besh tfham)
    // Constructeur li ghade ncreeyew beh Trajet dyelna
    public Trajet(int id_trajet, Station stationDepartT, Station stationArriveT, Train train) {
        this.id_trajet = id_trajet;
        this.train = train;
        this.stations=new LinkedList<>(); // henaya derna creation liste
        stations.addFirst(stationDepartT); // ha heya henaya atban lek l utulite dyel linked liste datna nishan lbedya dyel list li 7etina feha la gare de depart
        stations.addLast(stationArriveT);// ha heya tane mera khera lash dert linkedlist 7it katdek nishan lekher dyel la list fen ghaden n7atu la gare lekher
    }
    // getters u setters
    public int getId_trajet() {
        return id_trajet;
    }
    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }
    public Station getStationDepartT() {
        return stationDepartT;
    }
    public void setStationDepartT(Station stationDepartT) {
        this.stationDepartT = stationDepartT;
    }
    public Station getStationArriveT() {
        return stationArriveT;
    }
    public void setStationArriveT(Station stationArriveT) {
        this.stationArriveT = stationArriveT;
    }
    public LinkedList<Station> getStations() {
        return stations;
    }
    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    // he lmethode kanzidu beha les stations li aywqef fehum
    public void ajouterStation(Station station) {
           int index = stations.size(); // henaya dert hed .size besh n3ref sh7al la taille dyel list
           stations.add(index-1, station);// dert index-1 besh deman ybqa fenma nbghi n ajouter shi gare itzadn qbel la fin dyel trajet ye3ni station d'arrive
           // exemple besh tfehmu : list feha : Casa Voyageur (gare depart )  , Tanger Ville (Gare arret)
        // daba ana baghe nzid Rabat Agdal ha fen ghadeya tji :  Casa Voyageur , Rabat Agdal , Tanger Ville
        // daba anzid gare akher d Kenitra ha fen ghade yji : Casa Voyageur , Rabat Agdal , Kenitra , Tanger Ville
    }
    // Hade la methode katshuf bha train fen wssel u sh7al mn gare baqe leh
    public void afficherStations(){
        if(stations.isEmpty()){
            System.out.println("Il n'ya aucun station . Le train atteint l'arret");
        }
        Iterator<Station> iterator = stations.iterator();
        while (iterator.hasNext()){
        Station station = iterator.next();
        System.out.println(station.toString());
        }
    }
}
