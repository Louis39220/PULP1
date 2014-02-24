/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBaccess;

import connexion.ConnexionOracleFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class DBaccess {

    private final Connection connexionDB;

    private DBaccess() throws SQLException {
        connexionDB = ConnexionOracleFactory.openConnection();
    }

    // L'unique instance de la classe
    private static DBaccess instance = null;

    /**
     * Cette fonction retourne l'unique instance de la classe
     * @return 
     * @throws java.sql.SQLException
     */
    public static DBaccess getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBaccess();
        }
        return instance;
    }

}
