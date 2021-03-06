/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Referee;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public Referee selectReferee(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Referee r;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM referee WHERE refereeId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            rs.next();
            r = new Referee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
        }
        rs.close();
        connexionDB.close();
        return r;

    }

    @Override
    public List<Referee> selectAllReferee() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM referee");

        List<Referee> lr = new ArrayList<>();
        while(rs.next()){
            lr.add(new Referee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
        }
        rs.close();
        connexionDB.close();
        return lr;
    }
    
    @Override
     public List<Referee> selectRandom8RefereeLine()throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM referee WHERE refereeCategorie='ligne'");
        Random rand = new Random(); 
        List<Referee> lr = new ArrayList<>();
        while(rs.next()){
            lr.add(new Referee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
        }
        int alea;
        List<Referee> lr8 = new ArrayList<>();
        for(int i=0;i<8;i++){
            alea = rand.nextInt(lr.size());
            lr8.add(lr.get(alea));
            lr.remove(alea);
        }
        
        rs.close();
        connexionDB.close();
        return lr8;
     }

    @Override
    public boolean insertReferee(String name, String Surname, String ddn, int nbMatch, String categorie) throws SQLException, IOException {
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
    public boolean deleteReferee(int id) throws SQLException, IOException {
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
    
    @Override
    public boolean deleteRefereeByName(String name, String surname, String birthdate) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM pulp.referee where REFEREENAME= ? AND REFEREESURNAME= ? AND REFEREEDATENAISSANCE= ?")) {
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
     * @param nbMatch
     * @param categorie
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateReferee(int id, String name, String surname, String ddn, int nbMatch, String categorie) throws SQLException, IOException {
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

    @Override
    public int selectNbMatch(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        int res = -1;
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT refereeNbMatch FROM pulp.referee WHERE refereeId = ?")) {
            PS.setInt(1, id);
            try {
                rs = PS.executeQuery();
                rs.next();
                res = rs.getInt(1);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                PS.cancel();
            }
            PS.close();
            connexionDB.close();
        }
        return res;
    }
    
    @Override
     public Referee selectRefereeRandomRefereeChaise()throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM referee WHERE refereeCategorie='chaise' AND refereeNbMatch < 4");
        Random rand = new Random(); 
        List<Referee> lr = new ArrayList<>();
        Referee ref = null;
        while(rs.next()){
            lr.add(new Referee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
        }
        int alea;
        
        alea = rand.nextInt(lr.size());
        ref = lr.get(alea);
        
        rs.close();
        connexionDB.close();
        return ref;
     }
    
    @Override
     public Referee selectRefereeRandomRefereeFilet()throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM referee WHERE refereeCategorie='filet' AND refereeNbMatch < 4");
        Random rand = new Random(); 
        List<Referee> lr = new ArrayList<>();
        Referee ref = null;
        while(rs.next()){
            lr.add(new Referee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
        }
        int alea;
        
        alea = rand.nextInt(lr.size());
        ref = lr.get(alea);
        
        rs.close();
        connexionDB.close();
        return ref;
     }
}
