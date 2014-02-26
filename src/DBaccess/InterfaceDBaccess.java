/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBaccess;

import entities.Player;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public interface InterfaceDBaccess {

    public DBaccess getInstance() throws SQLException;

    public Player selectPlayer(String id) throws SQLException;

    public ResultSet selectAllPlayer() throws SQLException;

    public boolean insertPlayer(String name, String Surname, Date ddn, int rank) throws SQLException;

    public boolean deletePlayer(String id) throws SQLException;
    
    public boolean updatePlayer(int id, String name,String surname, Date ddn, int rank) throws SQLException;
    
    
    
}
