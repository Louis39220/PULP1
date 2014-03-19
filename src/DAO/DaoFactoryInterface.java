/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public interface DaoFactoryInterface {
    
    public PlayerDaoImpl getPlayerDao() throws IOException, SQLException;
    
    public RefereeDaoImpl getRefereeDao() throws IOException, SQLException;
    
    public CoachDaoImpl getCoachDao() throws IOException, SQLException;
    
    public MatchDaoImpl getMatchDao() throws IOException, SQLException;
    
    public Match_playerDaoImpl getMatchPlayerDao() throws IOException, SQLException;
    
}
