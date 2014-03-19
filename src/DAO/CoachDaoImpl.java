/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Coach;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Louis
 */
public class CoachDaoImpl implements CoachDao{
    private Connection connexionDB;
    
    public CoachDaoImpl(Connection conn){
        this.connexionDB=conn;
    }
    @Override
    public Coach selectCoach(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Coach c;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM coach WHERE playerId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            c = rs.getObject(id, Coach.class);
        }
        rs.close();
        connexionDB.close();
        return c;

    }

    @Override
    public List<Coach> selectAllCoach() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM coach");

        List<Coach> lc = new ArrayList<>();
        while(rs.next()){
            lc.add(new Coach(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6)));
        }
        rs.close();
        connexionDB.close();
        return lc;
    }

    @Override
    public boolean insertCoach(String name, String Surname, String ddn, int pCoached, int reput) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO coach(coachName,coachSurname,coachDateNaissance,playerCoached,coachReputation) values(?,?,?,?,?)")) {
            PS.setString(1, name);
            PS.setString(2, Surname);
            PS.setString(3, ddn);
            PS.setInt(4, pCoached);
            PS.setInt(5, reput);
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
    public boolean deleteCoach(int id) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM coach where coachId= ?")) {
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
    public boolean deleteCoachByName(String name, String surname, String birthdate) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM pulp.coach where COACHNAME= ? AND COACHSURNAME= ? AND COACHDATENAISSANCE= ?")) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, birthdate);
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
     * @param pCoached
     * @param reput
     * @return
     * @throws SQLException
     * @throws java.io.IOException
     */
    @Override
    public boolean updateCoach(int id, String name, String surname, String ddn, int pCoached, int reput) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE coach SET coachName=? coachSurname=? coachDateNaissance=? playerCoached=? coachReputation=? where coachId=?")) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, ddn);
            ps.setInt(4, pCoached);
            ps.setInt(5, reput);
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
