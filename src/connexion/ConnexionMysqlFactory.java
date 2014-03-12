package connexion;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

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
    public static Connection getInstance() throws IOException, SQLException {
        if (connection == null) {
            try {
                Properties props = new Properties();
                FileInputStream fichier = new FileInputStream("src/connexion/connexion.properties");
                props.load(fichier);
                MysqlDataSource mds = new MysqlDataSource();
                mds.setUser(props.getProperty("user"));
                mds.setServerName(props.getProperty("serveur"));
                return (mds.getConnection());
            } 
            catch (IOException | SQLException e) {
                System.err.println("Erreur lors de la connection : " + e.getMessage());
            }
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
