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
    private final static String url = "jdbc:mysql://localhost:3306/pulp?:3306/mysql";
    private final static String user = "root";
    private final static String pwd = "";

    // Ouvre une connexion s'il n'en existe pas déja une
    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                System.err.println("Erreur lors de la connection : " + e.getMessage());
            }
        }
        return connection;
    }

    

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
