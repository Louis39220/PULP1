/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Coach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Louis
 */
public class RefereeDaoImpl implements RefereeDao {

    private Connection connexionDB;

    public RefereeDaoImpl(Connection connexionDB) {
        this.connexionDB = connexionDB;
    }
    
    

    @Override
    public Coach selectReferee(int id) throws SQLException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Coach c;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM referee WHERE refereeId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            c = rs.getObject(id, Coach.class);
        }
        rs.close();
        connexionDB.close();
        return c;

    }

    @Override
    public ResultSet selectAllReferee() throws SQLException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        try (Statement st = connexionDB.createStatement()) {
            rs = st.executeQuery("SELECT * FROM referee");
        }
        rs.close();
        connexionDB.close();
        return rs;
    }

    @Override
    public boolean insertReferee(String name, String Surname, String ddn, int nbMatch, String categorie) throws SQLException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO referee(refereeName,refereeSurname,refereeDateNaissance,refereeNbMatch,refereeCategorie) values(?,?,?,?,?)")) {
            PS.setString(1, name);
            PS.setString(2, Surname);
            PS.setString(3, ddn);
            PS.setInt(4, nbMatch);
            PS.setString(5, categorie);
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
    public boolean deleteReferee(int id) throws SQLException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM referee where refereeId= ?")) {
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
     * @param nbMatch
     * @param categorie
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateReferee(int id, String name, String surname, String ddn, int nbMatch, String categorie) throws SQLException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE coach SET refereeName=? refereeSurname=? refereeDateNaissance=? refereeNbMatch=? refereeReputation=? where refereeId=?")) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, ddn);
            ps.setInt(4, nbMatch);
            ps.setString(5, categorie);
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
