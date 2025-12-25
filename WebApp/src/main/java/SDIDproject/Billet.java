package SDIDproject;

import java.io.Serializable;

public class Billet implements Serializable {
    private static int billetID=0; // numero tickets
    private Reservation reservation; // reservation li feha detais d kulshi

    public Billet(Reservation reservation) {
        billetID++;
        this.reservation = reservation;
    }
    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    // Lmatbu3 dyel tickets
    public String printBilletsPDF() {
        return "======= Ticket PDF ======= \n" +"Ticket #" + billetID +
                "\n Voyageur: " + reservation.getVoyageur().getNom()+
                "\n Train: " + reservation.getTrain().getTrainType() + reservation.getTrain().getTrainID()+
                "\nHoraire: " + reservation.getHoraire().toString() +
                "\nCompartiment: " + reservation.getCompartiment().getNumeroCompartiment()+
                "\nPlace: " + reservation.getPlace().getPlaceNo() +
                "\nPrix: " + reservation.getPrix() + "DH\n"+"==========================";
    }
}

