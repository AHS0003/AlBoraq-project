package SDIDproject;

import java.util.ArrayList;

public class Compartiment {
    public static final int MAX_SEATS = 60;// iwa hbabe hada lmax dyel lblayass
    private static int id_compartiment=0;
    private int classCompartiment; // first wela second
    private int numeroCompartiment; // mn 1 tal 7
    private ArrayList<Place> places; // lblayass yalah mab9ash

    // henaya
    public Compartiment(int classCompartiment, int numeroCompartiment) throws CompartimentException{
        if (classCompartiment != 1 && classCompartiment != 2) { // hena lakan shi wa7ad sekran wla deri sghir ghaden ywerek mn gher 1 er wla 2 eme class ash anqulu leh ?  nkhelikum ntuma tjawbu
            throw new CompartimentException("La classe du compartiment doit être 1 (Première Classe) ou 2 (Deuxième Classe).");
        }
        id_compartiment++;
        this.classCompartiment = classCompartiment;
        this.numeroCompartiment = numeroCompartiment;
        this.places = new ArrayList<>(); // henaya la list li feha les compartiment (dert array list u mashi linked list 7it masoqmash f tartib)
    }
    // kanreservew blassa
    public void addPlace(Place place) {
        if (place.estDisponible()) { // henaya ya ima ndiru hed contains ya ima ndiru des est disponible
            places.add(place); // knzidu blass ila kanat khawya u kina fl intervall dyelna
        } else {
            System.out.println("Le compartiment est plein . Voici les places libres : ");
            placeDisponible();
        }
    }
    // la shi wa7ad baghe yshuf wesh lblassa khawya
    public Place trouverPlace(int placeNo) {
        for (Place place : places) {
            if (place.getPlaceNo() == placeNo) {
                return place;
            }
        }
        return null;
    }
    // Les blyass li khawen , les mecs du bled
    public void placeDisponible() {
        System.out.println("Sièges disponibles dans le compartiment " + numeroCompartiment + ":");
        for (Place place : places) {
            if (place.getStatutPlace().equals("Libre")) {
                System.out.println(place.toString());
            }
        }
    }
    // tm7i blassa ze3ma tkhwiha
    public boolean removeSeat(Place place) {
        return places.remove(place);
    }
    // blayass 3amrin == compartiment 3emrat
    public boolean estPleineCompartiment() {
        return places.size() == MAX_SEATS;
    }
    // getters setters
    public ArrayList<Place> getPlaces() {
        return places;
    }
    public void setPlaces(ArrayList<Place> places) throws CompartimentException {
        if (places.size() > MAX_SEATS) {
            throw new CompartimentException("Un compartiment ne peut pas contenir plus de " + MAX_SEATS + " places ");
        }
        this.places = places;
    }
    public int getClassCompartiment() {
        return classCompartiment;
    }
    public void setClassCompartiment(int classCompartiment) throws CompartimentException{
        if (classCompartiment != 1 && classCompartiment != 2) {
            throw new CompartimentException("La classe du compartiment doit être 1 (Première Classe) ou 2 (Deuxième Classe).");
        }
        this.classCompartiment = classCompartiment;
    }

    public int getNumeroCompartiment() {
        return numeroCompartiment;
    }
    public void setNumeroCompartiment(int numeroCompartiment) {
        this.numeroCompartiment = numeroCompartiment;
    }
}
