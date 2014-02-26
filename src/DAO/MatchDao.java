/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Coach;
import entities.Match;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public interface MatchDao {

    public Match selectMatch(int id) throws SQLException, IOException;

    public ResultSet selectAllMatch() throws SQLException, IOException;

    public ResultSet selectMatchByDate(String Date) throws SQLException, IOException;

    public ResultSet selectMatchByTerrain(int numTerrain) throws SQLException, IOException;

    public boolean insertMatch(String Date, int heure, int terrain, int type) throws SQLException, IOException;

    public boolean deleteMatch(int id) throws SQLException, IOException;

    public boolean updateMatch(int id, String date, int heure, int terrain, int type) throws SQLException, IOException;

}
