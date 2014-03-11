/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionMysqlFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public class Match_playerDaoImpl {
    
    private Connection connexionDB;
    
    public Match_playerDaoImpl(Connection conn){
        this.connexionDB=conn;
    }
    
    public int selectIdPlayer(int matchId) throws IOException, SQLException{
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        int id;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT matchId FROM pulp.player_match WHERE matchId= ?")) {
            PS.setInt(1, matchId);
            rs = PS.executeQuery();
            rs.next();
            id = rs.getInt("matchId");
        }
        rs.close();
        connexionDB.close();
        return id;
    }
    
}
