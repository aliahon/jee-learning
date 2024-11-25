package mod.sco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {

    // Connection object to hold the database connection
    private static Connection conn = null;

    // Method to establish and return the database connection
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scolarité", "root", "");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Erreur : Impossible de charger le driver de la base de données.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur : Impossible d'établir la connexion à la base de données.");
            }
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur : Impossible de fermer la connexion à la base de données.");
            }
        }
    }
}
