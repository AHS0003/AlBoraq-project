package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnexion  {
    private static Connection connexion;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connexion=DriverManager.getConnection("jdbc:mysql://alboraq-db:3306/gestion_reservation","alboraq","alboraq123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnexion() {
        return connexion;
    }
    public static void setConnexion(Connection connexion) {
        dbconnexion.connexion = connexion;
    }
}