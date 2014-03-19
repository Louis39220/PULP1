/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Player;
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
public class PlayerDaoImpl implements PlayerDao {

    private Connection connexionDB;

    public PlayerDaoImpl(Connection connexionDB) {
        this.connexionDB = connexionDB;
    }

    @Override
    public Player selectPlayer(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Player p;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM player WHERE playerId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            p = new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
        }
        rs.close();
        connexionDB.close();
        return p;

    }

    @Override
    public List<Player> selectAllPlayer() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM player");
        List<Player> lp = new ArrayList<>();
        while (rs.next()) {
            lp.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        rs.close();
        connexionDB.close();
        return lp;
    }

    @Override
    public boolean insertPlayer(String name, String Surname, String ddn, int rank) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO player(PLAYERNAME,PLAYERSURNAME,PLAYERDATENAISSANCE,PLAYERRANK) values(?,?,?,?)")) {
            PS.setString(1, name);
            PS.setString(2, Surname);
            PS.setString(3, ddn);
            PS.setInt(4, rank);
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
    public boolean deletePlayer(int id) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM player where PLAYERID= ?")) {
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

    /**
     *
     * @param id
     * @param name
     * @param surname
     * @param ddn
     * @param rank
     * @return
     * @throws SQLException
     * @throws java.io.IOException
     */
    @Override
    public boolean updatePlayer(int id, String name, String surname, String ddn, int rank) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE player SET playername=? playersurname=? playerdatenaissance=? playerrank=? where playerId=?")) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, ddn);
            ps.setInt(4, rank);
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
    public List<Player> selectPlayerOfMatchByDayHour(int heure, int day) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs = null;
        List<Player> lp = new ArrayList<>();
        Statement st = connexionDB.createStatement();
        try (PreparedStatement ps = connexionDB.prepareStatement("select * from pulp.player where playerId in (select idP1 from pulp.attribmatch where matchId in "
                + "(select matchId from pulp.match where matchtrancheHoraire=? and matchDate=?))")) {
            ps.setInt(1, heure);
            ps.setInt(2, day);
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    lp.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        try (PreparedStatement ps = connexionDB.prepareStatement("select * from pulp.player where playerId in (select idP2 from pulp.attribmatch where matchId in "
                + "(select matchId from pulp.match where matchTrancheHoraire=? and matchDate=?))")) {
            ps.setInt(1, heure);
            ps.setInt(2, day);
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    lp.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        connexionDB.close();
        return lp;
    }

    @Override
    public List<Player> selectPlayerofMatchByCourtHour(int court, int heure) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs = null;
        List<Player> lp = new ArrayList<>();
        Statement st = connexionDB.createStatement();
        try (PreparedStatement ps = connexionDB.prepareStatement("select * from pulp.player where playerId in (select idP1 from pulp.attribmatch where matchId in "
                + "(select matchId from pulp.match where matchLieu=? and matchDate=?))")) {
            ps.setInt(1, heure);
            ps.setInt(2, court);
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    lp.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        try (PreparedStatement ps = connexionDB.prepareStatement("select * from pulp.player where playerId in (select idP2 from pulp.attribmatch where matchId in "
                + "(select matchId from pulp.match where matchLieu=? and matchDate=?))")) {
            ps.setInt(1, heure);
            ps.setInt(2, court);
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    lp.add(new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        connexionDB.close();
        return lp;
    }

}
