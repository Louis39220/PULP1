/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBaccess;

import connexion.ConnexionOracleFactory;
import entities.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBaccess {

    private Connection connexionDB;

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
    
    public Player selectPlayer(String id) throws SQLException{
        connexionDB = ConnexionOracleFactory.openConnection();
        PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM player WHERE playerId= ?");
        PS.setString(1, id);
        ResultSet rs =  PS.executeQuery();
        Player p = new Player(rs.getString("PLAYERID"),rs.getString("PLAYERNAME"),rs.getString("PLAYERSURNAME"),rs.getDate("PLAYERDATENAISSANCE"),rs.getInt("PLAYERRANK"));
        return p;
    }
}
