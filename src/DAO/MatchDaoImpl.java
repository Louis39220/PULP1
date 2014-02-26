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

/**
 *
 * @author Louis
 */
public class MatchDaoImpl implements MatchDao {

    private Connection connexionDB;

    @Override
    public Match selectMatch(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Match m;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM match WHERE matchId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            m = rs.getObject(id, Match.class);
        }
        rs.close();
        connexionDB.close();
        return m;
    }

    @Override
    public ResultSet selectAllMatch() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        try (Statement st = connexionDB.createStatement()) {
            rs = st.executeQuery("SELECT * FROM match");
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

    @Override
    public ResultSet selectMatchByDate(String date) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM match WHERE matchDate= ?")) {
            PS.setString(1, date);
            rs = PS.executeQuery();
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

    @Override
    public ResultSet selectMatchByTerrain(int numTerrain) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Match m;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM match WHERE matchTerrain= ?")) {
            PS.setInt(1, numTerrain);
            rs = PS.executeQuery();
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

    @Override
    public boolean insertMatch(String date, int heure, int terrain, int type) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO match(matchLieu, matchDate,matchTrancheHoraire, matchType) values(?,?,?,?)")) {
            PS.setInt(2, terrain);
            PS.setString(1, date);
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
    public boolean updateMatch(int id, String date, int heure, int terrain, int type) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE match SET matchLieu=? matchDate=? matchTrancheHoraire=? matchType=? where matchId=?")) {
            ps.setInt(2, terrain);
            ps.setString(1, date);
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

}
