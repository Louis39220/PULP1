/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Match;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Louis
 */
public class MatchDaoImpl implements MatchDao {

    private Connection connexionDB;
    
     public MatchDaoImpl(Connection conn){
        this.connexionDB=conn;
    }

    @Override
    public Match selectMatch(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Match m;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            m = rs.getObject(id, Match.class);
        }
        rs.close();
        connexionDB.close();
        return m;
    }
    @Override
    public int selectIdMatchByTerrainByDate(int numTerrain, int date) throws SQLException, IOException{
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        int id;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT matchId FROM pulp.match WHERE matchLieu= ? AND matchDate=?")) {
            PS.setInt(1, numTerrain);
            PS.setInt(2, date);
            rs = PS.executeQuery();
            rs.next();
            id = rs.getInt("matchId");
        }
        rs.close();
        connexionDB.close();
        return id;   
    }
    
    @Override
    public int selectIdMatchByDateByHour(int date, int trancheHoraire) throws SQLException, IOException{
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        int id;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT matchId FROM pulp.match WHERE matchTrancheHoraire= ? AND matchDate=?")) {
            PS.setInt(1, trancheHoraire);
            PS.setInt(2, date);
            rs = PS.executeQuery();
            rs.next();
            id = rs.getInt("matchId");
        }
        rs.close();
        connexionDB.close();
        return id;
    }
    
    @Override
    public List<Match> selectAllMatch() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM match");
        List<Match> lm = new ArrayList<>();
        while(rs.next()){
            lm.add(new Match(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
        }
        rs.close();
        connexionDB.close();
        return lm;
    }

    @Override
    public ResultSet selectMatchByDate(int date) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchDate= ?")) {
            PS.setInt(1, date);
            rs = PS.executeQuery();
        }
        rs.close();
        connexionDB.close();
        return rs;
    }
    
    @Override
    public ResultSet selectMatchByDateByHour(int date, int matchTrancheHoraire) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchDate= ? AND matchTrancheHoraire=?")) {
            PS.setInt(1, date);
            PS.setInt(2, matchTrancheHoraire);
            rs = PS.executeQuery();
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

    @Override
    public ResultSet selectMatchByTerrainByDate( int date, int numTerrain) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Match m;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchLieu= ? AND matchDate=?")) {;
            PS.setInt(1, numTerrain);
            PS.setInt(2, date);
            rs = PS.executeQuery();
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

    @Override
    public boolean insertMatch(int date, int heure, int terrain, int type) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO match(matchLieu, matchDate,matchTrancheHoraire, matchType) values(?,?,?,?)")) {
            PS.setInt(2, terrain);
            PS.setInt(1, date);
            PS.setInt(3, heure);
            PS.setInt(4, type);
            try {
                PS.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                PS.cancel();
                res = false;
            }
            PS.close();
            connexionDB.close();
        }
        return res;

    }

    @Override
    public boolean deleteMatch(int id) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM match where matchId= ?")) {
            ps.setInt(1, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps.cancel();
                res = false;
            }
            ps.close();
            connexionDB.close();
        }
        return res;
    }

    @Override
    public boolean updateMatch(int id, int date, int heure, int terrain, int type) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE match SET matchLieu=? matchDate=? matchTrancheHoraire=? matchType=? where matchId=?")) {
            ps.setInt(2, terrain);
            ps.setInt(1, date);
            ps.setInt(3, heure);
            ps.setInt(4, type);
            ps.setInt(5, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps.cancel();
                res = false;
            }
            ps.close();
            connexionDB.close();
        }
        return res;

    }

    @Override
    public ResultSet selectMatchByTerrain(int numTerrain) throws SQLException, IOException {
               connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Match m;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM match WHERE matchLieu= ?")) {
            PS.setInt(1, numTerrain);
            rs = PS.executeQuery();
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

}
