/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import connexion.ConnexionMysqlFactory;
import java.sql.Connection;

/**
 *
 * @author Louis
 */
public class DaoFactory {
    protected static final Connection conn= ConnexionMysqlFactory.getInstance();
    
    //retourne un objet Player interagissant avec la BDD
    public static PlayerDaoImpl getPlayerDao() {
        return new PlayerDaoImpl(conn);
    }
    
    //Retourne un objet referee interagissant avec la BDD
    public static RefereeDaoImpl getRefereeDao(){
        return new RefereeDaoImpl(conn);
    }
    
    //Retourne un objet Coach interagissant avec la BDD
    public static CoachDaoImpl getCoachDAao(){
        return new CoachDaoImpl(conn);
    }
    
}
