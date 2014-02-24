/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Louis
 */
public class ConnexionOracleFactory {
    
          // Attribut privé de gestion de la connexion à la bd Oracle
  private static Connection conn;

  // Ouvre une connexion stockée dans la variable conn
  public static Connection openConnection() throws SQLException
  {
try {
    Properties props = new Properties();
    FileInputStream fichier = new FileInputStream("connexion.properties");
    props.load(fichier);
    OracleDataSource ods = new OracleDataSource();
    ods.setDriverType(props.getProperty("pilote"));
    ods.setPortNumber(new Integer(props.getProperty("port")).intValue());
    ods.setServiceName(props.getProperty("service"));
    ods.setUser(props.getProperty("user"));
    ods.setPassword(props.getProperty("pwd"));
    ods.setServerName(props.getProperty("serveur"));
    return (ods.getConnection());
} catch (IOException | NumberFormatException | SQLException e) {
    System.err.println("Erreur lors de la lecture du fichier de configuration pour la connexion");
        return null;
  }
  }
  
  public void closeConnection() throws SQLException
  {
   conn.close();
  }
    
}
