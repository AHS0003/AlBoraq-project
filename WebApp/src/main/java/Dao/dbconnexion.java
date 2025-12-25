package Dao;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class dbconnexion  {
    private static Connection connexion;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestion_Reservation","root","");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
