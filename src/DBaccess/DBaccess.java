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
import java.sql.Statement;
import java.sql.Date;


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
        ResultSet rs;
        Player p;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM player WHERE playerId= ?")) {
            PS.setString(1, id);
            rs = PS.executeQuery();
            p = rs.getObject(id, Player.class);
        }
        rs.close();
        connexionDB.close();
        return p;
         
    }
    
    public ResultSet selectAllPlayer() throws SQLException{
        connexionDB = ConnexionOracleFactory.openConnection();
        ResultSet rs;
        try (Statement st = connexionDB.createStatement()) {
            rs = st.executeQuery("SELECT * FROM player");
        }
        rs.close();
        connexionDB.close();
        return rs;   
    }
    
    public boolean insertPlayer(String name, String Surname, Date ddn, int rank) throws SQLException{
        boolean res = true;
        connexionDB = ConnexionOracleFactory.openConnection();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO player(PLAYERNAME,PLAYERSURNAME,PLAYERDATENAISSANCE,PLAYERRANK) values(?,?,?,?)")) {
            PS.setString(1, name);
            PS.setString(2, Surname);
            PS.setDate(3, ddn);
            PS.setInt(4, rank);
            try {
                PS.executeQuery(); 
            }
            catch(SQLException e){
                System.err.println(e.getMessage());
                PS.cancel();
                res=false;
            }
            connexionDB.close();
        }
        return res;
    }
    
}
