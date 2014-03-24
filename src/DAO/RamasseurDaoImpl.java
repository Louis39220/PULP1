/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Player;
import entities.Ramasseur;
import entities.Referee;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ludovic
 */
public class RamasseurDaoImpl implements RamasseurDao{
    private Connection connexionDB;

    public RamasseurDaoImpl(Connection connexionDB) {
        this.connexionDB = connexionDB;
    }
    
    @Override
    public Ramasseur selectNomRamasseur() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Ramasseur r = null;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM ramasseurs")) {
            rs = PS.executeQuery();
            Random rand = new Random(); 
            List<Ramasseur> lr = new ArrayList<>();
            while (rs.next()) lr.add(new Ramasseur(rs.getInt(1),rs.getString(2)));
            int alea;
            alea = rand.nextInt(lr.size());
            r = lr.get(alea);
        }
        rs.close();
        connexionDB.close();
        return r;
    }
    
    @Override
    public Ramasseur selectIdRamasseur() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Ramasseur r = null;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM ramasseurs")) {
            rs = PS.executeQuery();
            Random rand = new Random(); 
            List<Ramasseur> lr = new ArrayList<>();
            while (rs.next()) lr.add(new Ramasseur(rs.getInt(1),rs.getString(2)));
            int alea = rand.nextInt(lr.size());
            r = lr.get(alea);
        }
        rs.close();
        connexionDB.close();
        return r;
    }
    
    @Override
    public Ramasseur selectRamasseur(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Ramasseur r = null;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM ramasseurs WHERE ramasseursId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            rs.next();
            r = new Ramasseur(rs.getInt(1), rs.getString(2));
        }
        rs.close();
        connexionDB.close();
        return r;
    }
}
