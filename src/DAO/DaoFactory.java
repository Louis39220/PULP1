/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionMysqlFactory;
import java.sql.Connection;

import java.io.IOException;
import java.sql.SQLException;

public class DaoFactory{
    

    protected static Connection conn ;
    
    //retourne un objet Player interagissant avec la BDD
 
    public static PlayerDaoImpl getPlayerDao() throws IOException, SQLException {
        conn = ConnexionMysqlFactory.getInstance();
        return new PlayerDaoImpl(conn);
    }
    
    //Retourne un objet referee interagissant avec la BDD
    
    public static RefereeDaoImpl getRefereeDao() throws IOException, SQLException{
        conn = ConnexionMysqlFactory.getInstance();
        return new RefereeDaoImpl(conn);
    }
    
    //Retourne un objet Coach interagissant avec la BDD
   
    public static CoachDaoImpl getCoachDao() throws IOException, SQLException{
        conn = ConnexionMysqlFactory.getInstance();
        return new CoachDaoImpl(conn);
    }
    
    //retourne un objet Match interagissant avec la BDD
   
    public static MatchDaoImpl getMatchDao() throws IOException, SQLException{
        conn = ConnexionMysqlFactory.getInstance();
        return new MatchDaoImpl(conn);
    }
    
 
    public static Match_playerDaoImpl getMatchPlayerDao() throws IOException, SQLException{
        conn = ConnexionMysqlFactory.getInstance();
        return new Match_playerDaoImpl(conn);
    }
}
