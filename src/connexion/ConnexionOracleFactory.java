/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public class ConnexionOracleFactory {
    
          // Attribut privé de gestion de la connexion à la bd Oracle
  private Connection conn;

  // Ouvre une connexion stockée dans la variable conn
  public void openConnection() throws SQLException
  {
   String userid = "p01234567";
   String password = "iut2013";
   String URL = "jdbc:oracle:thin:@iuta.univ-lyon1.fr:1521:orcl";
   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver() );
   conn = DriverManager.getConnection(URL,userid,password);
   if(conn != null){System.out.println("Connexion etablie");}
  }
  public void closeConnection() throws SQLException
  {
   conn.close();
  }
    
}
