package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public class ConnexionMysqlFactory {
    private static Connection connection;

    // Ouvre une connexion stockée dans la variable conn
    public static Connection openConnection() throws SQLException {
        // get connection 
        String url = "jdbc:mysql://localhost:3306/pulp?:3306/mysql";
        String user = "root";
        String pwd = "";
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connection"+e.getMessage());
            return null;
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
