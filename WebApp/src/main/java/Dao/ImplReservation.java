package Dao;

import SDIDproject.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ImplReservation implements IReservation {
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private ArrayList<Voyageur> voyageurs = new ArrayList<Voyageur>();
    private ArrayList<Train> trains = new ArrayList<Train>();
    private ArrayList<Station> stations = new ArrayList<Station>();

    @Override
    public void ajouterVoyageur(Voyageur vg) {
        Connection conn = dbconnexion.getConnexion(); // obtenir la connexion
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO voyageur (nom, email, numero_telephone, age) VALUES (?, ?, ?, ?)");
            ps.setString(1, vg.getNom());
            ps.setString(2, vg.getEmail());
            ps.setString(3, vg.getNumero());
            ps.setInt(4, vg.getAge());
            ps.executeUpdate();
            System.out.println("Voyageur ajouté avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CarteBancaire getCarteBancaireByNomPorteur(String nomPorteur) {
        Connection conn = dbconnexion.getConnexion();
        CarteBancaire carte = null;
        String query = "SELECT * FROM CarteBancaire WHERE nom_porteur = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nomPorteur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carte = new CarteBancaire(
                        rs.getInt("id_carte"),
                        rs.getString("nom_porteur"),
                        rs.getString("numero_carte"),
                        rs.getInt("mois_expiration"),
                        rs.getInt("annee_expiration"),
                        rs.getString("code_verification")
                );
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carte;
    }

    public Voyageur recherchervoyageurByEmail(String email) {
        Connection conn = dbconnexion.getConnexion();
        Voyageur voyageur = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM voyageur WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voyageur = new Voyageur(rs.getString("nom"), rs.getString("email"), rs.getString("numero_telephone"), rs.getInt("age"));
                voyageur.setCode(rs.getInt("unique_code_voyageur")); // Ensure the unique code is set
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyageur;
    }

    public boolean verifierauthentification(String email, String password) {
        Connection conn = dbconnexion.getConnexion();
        boolean isAuthenticated = false;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM login WHERE email_login = ? AND password_login = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isAuthenticated = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    public void ajouterauthentification(String email, String password) {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO login (email_login, password_login) VALUES (?, ?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Login ajouté avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Horaire getHoraireById(int idHoraire) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        Horaire horaire = null;

        String query = """
            SELECT h.horaire_id, h.station_depart_id, h.station_arrive_id, h.heure_depart, h.heure_arrive,
                   t.train_id, t.train_type,
                   sd.station_id as departId, sd.name as departName, sd.location as departLocation,
                   sa.station_id as arriveId, sa.name as arriveName, sa.location as arriveLocation
            FROM horaire h
            JOIN train t ON h.train_id = t.train_id
            JOIN station sd ON h.station_depart_id = sd.station_id
            JOIN station sa ON h.station_arrive_id = sa.station_id
            WHERE h.horaire_id = ?
        """;

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idHoraire);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Create Station objects
                    Station stationDepart = new Station(
                            rs.getInt("departId"),
                            rs.getString("departName"),
                            rs.getString("departLocation")
                    );

                    Station stationArrive = new Station(
                            rs.getInt("arriveId"),
                            rs.getString("arriveName"),
                            rs.getString("arriveLocation")
                    );

                    // Create Train object based on type
                    Train train = new Train(
                            rs.getString("train_type"),
                            rs.getInt("train_id")
                    );

                    // Create Horaire object
                    horaire = new Horaire(
                            rs.getInt("horaire_id"),
                            stationDepart,
                            stationArrive,
                            rs.getTime("heure_depart").toLocalTime(),
                            rs.getTime("heure_arrive").toLocalTime(),
                            train
                    );
                }
            }
        }

        return horaire;
    }

    @Override
    public LinkedList<Horaire> afficherhoraire(Station station_depart, Station station_arrive) {
        Connection conn = dbconnexion.getConnexion();
        String query = """
        SELECT h.*, t.train_id, t.train_type,
               sd.station_id as depart_id, sd.name as depart_name, sd.location as depart_location,
               sa.station_id as arrive_id, sa.name as arrive_name, sa.location as arrive_location
        FROM horaire h
        JOIN train t ON h.train_id = t.train_id
        JOIN station sd ON h.station_depart_id = sd.station_id
        JOIN station sa ON h.station_arrive_id = sa.station_id
        WHERE h.station_depart_id = ? AND h.station_arrive_id = ?
        ORDER BY h.heure_depart
    """;

        // Use a local list instead of the class member
        LinkedList<Horaire> horaires = new LinkedList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, station_depart.getStationID());
            ps.setInt(2, station_arrive.getStationID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Create Station objects
                Station stationDepart = new Station(
                        rs.getInt("depart_id"),
                        rs.getString("depart_name"),
                        rs.getString("depart_location")
                );

                Station stationArrive = new Station(
                        rs.getInt("arrive_id"),
                        rs.getString("arrive_name"),
                        rs.getString("arrive_location")
                );

                // Create Train object based on type
                Train train;
                String trainType = rs.getString("train_type");
                if (trainType.equalsIgnoreCase("Boraq")) {
                    train = new Boraq();
                } else {
                    train = new Train(
                            trainType,
                            80,  // Default capacityFirstClass
                            400, // Default capacitySecondClass
                            2,   // Default compartimentFirstClass
                            5    // Default compartimentSecondClass
                    );
                }
                train.setTrainID(rs.getInt("train_id"));

                // Create Horaire object
                Horaire horaire = new Horaire(
                        rs.getInt("horaire_id"),
                        stationDepart,
                        stationArrive,
                        rs.getTime("heure_depart").toLocalTime(),
                        rs.getTime("heure_arrive").toLocalTime(),
                        train
                );

                horaires.add(horaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horaires; // Return the local list
    }

    @Override
    public void supprimervoyageur(int id_voyageur) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM voyageur WHERE unique_code_voyageur=?");
            ps.setInt(1, id_voyageur);
            ps.executeUpdate();
            System.out.println("Voyageur supprimé avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Voyageur recherchervoyageur(String nomComplet) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        Voyageur voyageur = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM voyageur WHERE nom = ?");
            ps.setString(1, nomComplet);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voyageur = new Voyageur(rs.getString("nom"), rs.getString("email"), rs.getString("numero_telephone"), rs.getInt("age"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyageur;
    }

    @Override
    public ArrayList<Voyageur> affichervoyageurs() throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM voyageur");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voyageur voyageur = new Voyageur(rs.getString("nom"), rs.getString("email"), rs.getString("numero_telephone"), rs.getInt("age"));
                voyageurs.add(voyageur);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyageurs;
    }
    @Override
    public void ajouterreservation(Reservation rs) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO reservation (unique_code_voyageur, train_id, horaire_id, compartiment, place, id_carte, prix, travel_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setInt(1, rs.getVoyageur().getCode());
            ps.setInt(2, rs.getTrain().getTrainID());
            ps.setInt(3, rs.getHoraire().getId());
            ps.setInt(4, rs.getCompartiment().getNumeroCompartiment());
            ps.setInt(5, rs.getPlace().getPlaceNo());
            ps.setInt(6, rs.getCarte().getIdCarte());
            ps.setDouble(7, rs.getPrix());
            ps.setDate(8, java.sql.Date.valueOf(rs.getDatereservation()));
            ps.executeUpdate();
            System.out.println("Reservation ajoutée avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerreservation(int id_reservation) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM reservation WHERE reservation_id=?");
            ps.setInt(1, id_reservation);
            ps.executeUpdate();
            System.out.println("Reservation supprimée avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Train> affichertouttrains() throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM train");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Train train = new Train(rs.getString("train_type"), rs.getInt("train_id"));
                trains.add(train);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    @Override
    public ArrayList<Station> affichertoutstations() throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM station");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Station station = new Station(rs.getInt("station_id"), rs.getString("name"), rs.getString("location"));
                stations.add(station);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }

    @Override
    public double AdultPrix(Station station_depart, Station station_arrive) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        double price = 0.0;
        String query = "SELECT prix FROM Prix_Adult WHERE station_depart_id = ? AND station_arrive_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, station_depart.getStationID());
            ps.setInt(2, station_arrive.getStationID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("prix");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public double EnfantPrix(Station station_depart, Station station_arrive) throws SQLException {
        Connection conn = dbconnexion.getConnexion();
        double price = 0.0;
        String query = "SELECT prix FROM Prix_Enfant WHERE station_depart_id = ? AND station_arrive_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, station_depart.getStationID());
            ps.setInt(2, station_arrive.getStationID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("prix");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
}