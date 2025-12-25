package Dao;

import SDIDproject.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface IReservation {
    void ajouterVoyageur(Voyageur vg);
    Voyageur recherchervoyageurByEmail(String email);
    CarteBancaire getCarteBancaireByNomPorteur(String nomPorteur);
    LinkedList<Horaire> afficherhoraire(Station station_depart , Station station_arrivee);
    void supprimervoyageur(int id_voyageur)throws SQLException;
    Voyageur recherchervoyageur(String nomComplet) throws SQLException;
    ArrayList<Voyageur> affichervoyageurs()throws SQLException;
    void ajouterreservation(Reservation rs) throws SQLException;
    void supprimerreservation(int id_reservation) throws SQLException;
    ArrayList<Train> affichertouttrains()throws SQLException;
    ArrayList<Station>affichertoutstations()throws SQLException;
    double AdultPrix(Station station_depart , Station station_arrive) throws SQLException;
    double EnfantPrix (Station station_depart , Station station_arrive) throws SQLException;
    void ajouterauthentification(String email, String password);
    boolean verifierauthentification(String email, String password);
}
