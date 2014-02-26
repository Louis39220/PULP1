/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public interface PlayerDao {

    public Player selectPlayer(int id) throws SQLException;

    public ResultSet selectAllPlayer() throws SQLException;

    public boolean insertPlayer(String name, String Surname, String ddn, int rank) throws SQLException;

    public boolean deletePlayer(int id) throws SQLException;

    public boolean updatePlayer(int id, String name, String surname, String ddn, int rank) throws SQLException;

}
