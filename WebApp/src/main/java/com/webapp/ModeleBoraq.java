package com.webapp;

import SDIDproject.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ModeleBoraq {
    private String nome_porteur;
    private String searchKeyword;
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ArrayList<Voyageur> voyageurs = new ArrayList<>();
    private ArrayList<Train> trains = new ArrayList<>();
    private ArrayList<Station> stations = new ArrayList<>();
    private LinkedList<Horaire> horaires = new LinkedList<>();
    private String errorMessage;
    private Reservation selectedReservation = new Reservation();
    private String dateChoisie;
    private String gareDepart;
    private String gareArrivee;
    private String arriveeDateChoisie;
    private LinkedList<Horaire> retourHoraires = new LinkedList<>();
    private String retourDateChoisie;
    private double Prixadult ;
    private double Prixenfant;
    private int numAdults;
    private int numChildren;
    private String email_login;
    private String password_login;
    private CarteBancaire carteBancaire;
    // Getters and Setters

    public String getArriveeDateChoisie() {return arriveeDateChoisie;}

    public void setArriveeDateChoisie(String arriveeDateChoisie) {this.arriveeDateChoisie = arriveeDateChoisie;}

    public CarteBancaire getCarteBancaire() {return carteBancaire;}

    public void setCarteBancaire(CarteBancaire carteBancaire) {this.carteBancaire = carteBancaire;}

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ArrayList<Voyageur> getVoyageurs() {
        return voyageurs;
    }

    public void setVoyageurs(ArrayList<Voyageur> voyageurs) {
        this.voyageurs = voyageurs;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public LinkedList<Horaire> getHoraires() {
        return horaires;
    }

    public void setHoraires(LinkedList<Horaire> horaires) {
        this.horaires = horaires;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Reservation getSelectedReservation() {
        return selectedReservation;
    }

    public void setSelectedReservation(Reservation selectedReservation) {
        this.selectedReservation = selectedReservation;
    }

    public String getDateChoisie() {
        return dateChoisie;
    }

    public void setDateChoisie(String dateChoisie) {
        this.dateChoisie = dateChoisie;
    }

    public String getGareDepart() {  // Add this getter
        return gareDepart;
    }

    public void setGareDepart(String gareDepart) {  // Add this setter
        this.gareDepart = gareDepart;
    }

    public String getGareArrivee() {  // Add this getter
        return gareArrivee;
    }

    public void setGareArrivee(String gareArrivee) {  // Add this setter
        this.gareArrivee = gareArrivee;
    }

    // Utility methods
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void addVoyageur(Voyageur voyageur) {
        this.voyageurs.add(voyageur);
    }

    public void addTrain(Train train) {
        this.trains.add(train);
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public void addHoraire(Horaire horaire) {
        this.horaires.add(horaire);
    }
    public LinkedList<Horaire> getRetourHoraires() {
        return retourHoraires;
    }

    public void setRetourHoraires(LinkedList<Horaire> retourHoraires) {
        this.retourHoraires = retourHoraires;
    }

    public String getRetourDateChoisie() {
        return retourDateChoisie;
    }

    public void setRetourDateChoisie(String retourDateChoisie) {
        this.retourDateChoisie = retourDateChoisie;
    }

    public double getPrixadult() {
        return Prixadult;
    }

    public void setPrixadult(double prixadult) {
        Prixadult = prixadult;
    }

    public double getPrixenfant() {
        return Prixenfant;
    }

    public void setPrixenfant(double prixenfant) {
        Prixenfant = prixenfant;
    }
    public int getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(int numAdults) {
        this.numAdults = numAdults;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public String getEmail_login() {return email_login;}

    public void setEmail_login(String email_login) {this.email_login = email_login;}

    public String getPassword_login() {return password_login;}

    public void setPassword_login(String password_login) {this.password_login = password_login;}

    public String getNome_porteur() {return nome_porteur;}

    public void setNome_porteur(String nome_porteur) {this.nome_porteur = nome_porteur;}
}