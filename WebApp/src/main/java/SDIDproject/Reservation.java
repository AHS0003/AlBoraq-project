package SDIDproject;

import java.time.LocalDate;

public class Reservation {
    private static int id_reservation;
    private Voyageur voyageur;
    private Train train;
    private Horaire horaire;
    private Compartiment compartiment;
    private Place place;
    private CarteBancaire carte;
    private double prix;
    private LocalDate datereservation;
    public Reservation() {
        super();
    }
    public Reservation(Voyageur voyageur, Train train, Horaire horaire, Compartiment compartiment, Place place, double prix, CarteBancaire carte, LocalDate datereservation) {
        id_reservation++;
        this.voyageur = voyageur;
        this.train = train;
        this.horaire = horaire;
        this.compartiment = compartiment;
        this.place = place;
        this.prix = prix;
        this.carte = carte;
        this.datereservation = datereservation;
    }
    public int getId_reservation() {
        return id_reservation;
    }
    // reservation dyel lblassa fl compartiment
    public void reserverPlace() throws ReservationException {
        if (place.estDisponible()) {
            compartiment.addPlace(place);
            place.setStatutPlace("Occupee");
            System.out.println("Réservation réussie pour le voyageur " + voyageur.getNom());
        } else {
            throw new ReservationException("Cette place est deja occupee par une autre personne");
        }
    }
    // kfsh t7eyed reservation
    public void annulerReservation() throws Exception {
        if (!place.estDisponible()) {
            place.setStatutPlace("Libre");
            System.out.println("Réservation annulée pour le voyageur " + voyageur.getNom());
        } else {
            throw new ReservationException("La place n'est pas réservée.");
        }
    }
    public Voyageur getVoyageur() {
        return voyageur;
    }
    public void setVoyageur(Voyageur voyageur) {
        this.voyageur = voyageur;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public Horaire getHoraire() {
        return horaire;
    }
    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }
    public Compartiment getCompartiment() {
        return compartiment;
    }
    public void setCompartiment(Compartiment compartiment) {
        this.compartiment = compartiment;
    }
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public CarteBancaire getCarte() {return carte;}
    public void setCarte(CarteBancaire carte) {this.carte = carte;}
    @Override
    public String toString() {
        return "Reservation [id_reservation=" + id_reservation +
                ", voyageur=" + voyageur.getNom() +
                ", train=" + train.getTrainID() +
                ", horairedepart=" + horaire.getHeureDepart() + ", horairearrivee=" + horaire.getHeureArrive() +
                ", compartiment=" + compartiment.getNumeroCompartiment()+
                ", place=" + place.getPlaceNo() +
                ", prix=" + prix+"]";
    }

    public LocalDate  getDatereservation() {
        return datereservation;
    }
}
