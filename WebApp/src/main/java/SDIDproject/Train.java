package SDIDproject;

import java.util.ArrayList;
import java.util.Iterator;

public class Train {
    private int trainID;
    private String trainType;
    private int capacityFirstClass;
    private int capacitySecondClass;
    private int compartimentFirstClass ;
    private int compartimentSecondClass ;
    private static int nbr_voyageur;
    private ArrayList<Voyageur> voyageurs;
    private ArrayList<Compartiment> compartiments;
    private static final int MAX_Compartiment = 7;
    public Train(String trainType,int trainID) {
        this.trainType = trainType;
        this.trainID = trainID;
    }
    public Train(String trainType, int capacityFirstClass, int capacitySecondClass, int compartimentFirstClass, int compartimentSecondClass) {
        this.trainType = trainType;
        this.capacityFirstClass = capacityFirstClass;
        this.capacitySecondClass = capacitySecondClass;
        this.compartimentFirstClass = compartimentFirstClass;
        this.compartimentSecondClass = compartimentSecondClass;
        this.voyageurs = new ArrayList<>();
        this.compartiments = new ArrayList<>();
        nbr_voyageur = 0;
    }
    // nlqaw lcompartiment
    public Compartiment trouverCompartiment(int numCompartiment) {
        for (Compartiment compartiment : compartiments) {
            if (compartiment.getClassCompartiment() == numCompartiment) {
                return compartiment;
            }
        }
        return null;
    }
    // henaya kanzidu les compartiment dyewelna
    public void addCompartiment(Compartiment compartiment) throws TrainException {
        if (compartiments.size() < MAX_Compartiment + 1 ) {
        compartiments.add(compartiment);
        }
        else {
            throw new TrainException("Cette compatriment est pleine ");
        }
    }
    // train sh7al yqder yhez mn personne
    public int CapaciteTotal(){
        return this.capacityFirstClass + this.capacitySecondClass;
    }
    // henaya kanzidu f train les voyageur
    public void addVoyageur(Voyageur voyageur) throws TrainException {
        if(voyageurs.size() < this.CapaciteTotal()) { // hed l condition katshuf wesh train baqe feh lblayass lakan baqe rah katzid l voyageur makansh katder leh exception
            voyageurs.add(voyageur);
            Train.nbr_voyageur++;
    }else {
            throw new TrainException("Ce train a atteint son maximuim , Veuillez selection un autre train ");
        }
    }
    // daba kinin nass b7ali ana kireservew gher hekak u ki7eydu 7it rech9at lehum dekshi lash ila shi wa7ad bgha y annuler train kan7eyduh tadaaaa
    public void deleteVoyageur(Voyageur voyageur) throws TrainException {
        if (voyageurs.remove(voyageur)) {
            Train.nbr_voyageur--;
        } else { // henaya la kan shi wa7ad jebha u kiqul lek baghe n annuler u huwa deja mamreservesh kanqulu leh ser f7alak
            throw new TrainException("Ce voyageur n'existe pas dans ce train");
        }
    }
    // daba henaya bghina nshufu les voyageur dyel train , mn 7eqna rah l app dyelna iwa rah heka kanshufuhum
    public void afficherVoyageur(){
        if(voyageurs.isEmpty()) {
            System.out.println("Aucun Voyageur dans ce train . Le train est vide");
        }else {
            Iterator<Voyageur> it = voyageurs.iterator();
            while(it.hasNext()) {
                Voyageur voyageur = it.next();
                System.out.println(voyageur.toString());
            }
        }
    }
    // getters setters
    public ArrayList<Compartiment> getCompartiments() {
        return compartiments;
    }
    public void setCompartiments(ArrayList<Compartiment> compartiments) {
        this.compartiments = compartiments;
    }
    public ArrayList<Voyageur> getVoyageurs() {
        return voyageurs;
    }
    public void setVoyageurs(ArrayList<Voyageur> voyageurs) {
        this.voyageurs = voyageurs;
    }
    public static int getNbr_voyageur() {
        return nbr_voyageur;
    }
    public static void setNbr_voyageur(int nbr_voyageur) {
        Train.nbr_voyageur = nbr_voyageur;
    }
    public int getCompartimentFirstClass() {
        return compartimentFirstClass;
    }

    public void setCompartimentFirstClass(int compartimentFirstClass) {
        this.compartimentFirstClass = compartimentFirstClass;
    }
    public int getCompartimentSecondClass() {
        return compartimentSecondClass;
    }

    public void setCompartimentSecondClass(int compartimentSecondClass) {
        this.compartimentSecondClass = compartimentSecondClass;
    }
    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getCapacityFirstClass() {
        return capacityFirstClass;
    }

    public void setCapacityFirstClass(int capacityFirstClass) {
        this.capacityFirstClass = capacityFirstClass;
    }

    public int getCapacitySecondClass() {
        return capacitySecondClass;
    }

    public void setCapacitySecondClass(int capacitySecondClass) {
        this.capacitySecondClass = capacitySecondClass;
    }
    // les info dyel trains
    @Override
    public String toString() {
        return "Train : " +
                " trainID = " + trainID +
                ",\n trainType = '" + trainType + '\'' +
                ",\ncapacityFirstClass = " + capacityFirstClass +
                ",\ncapacitySecondClass = " + capacitySecondClass +
                ",\ncompartimentFirstClass = " + compartimentFirstClass +
                ",\ncompartimentSecondClass = " + compartimentSecondClass +
                ",\nNombre Voyageur = " + nbr_voyageur;
    }

}
