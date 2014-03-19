/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Player;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Louis
 */
public interface PlayerDao {

    public Player selectPlayer(int id) throws SQLException, IOException;

    public List<Player> selectAllPlayer() throws SQLException, IOException;

    public boolean insertPlayer(String name, String Surname, String ddn, int rank) throws SQLException, IOException;

    public boolean deletePlayer(int id) throws SQLException, IOException;

    public boolean updatePlayer(int id, String name, String surname, String ddn, int rank) throws SQLException, IOException;

    public List<Player> selectPlayerOfMatchByDayHour(int heure, int day) throws SQLException, IOException;

    public List<Player> selectPlayerofMatchByCourtHour(int court, int heure) throws SQLException, IOException;
    
}
