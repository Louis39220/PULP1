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
import java.util.List;

/**
 *
 * @author Louis
 */
public interface MatchDao {

    public Match selectMatch(int id) throws SQLException, IOException;
    
    public int selectIdMatchByTerrainByDate(int numTerrain, int date) throws SQLException, IOException;
    
    public int selectIdMatchByDateByHour(int date, int trancheHoraire) throws SQLException, IOException;

    public List<Match> selectAllMatch() throws SQLException, IOException;

    public List<Match> selectMatchByDate(int date) throws SQLException, IOException;
    
    public List<Match> selectMatchByTerrainByDate( int date, int numTerrain) throws SQLException, IOException;
    
    public Match selectMatchByTerrainByDateByHour(int date, int numTerrain,int heure) throws SQLException, IOException;
    
    public List<Match> selectMatchByDateByHour(int date, int matchTrancheHoraire) throws SQLException, IOException;

    public List<Match> selectMatchByTerrain(int numTerrain) throws SQLException, IOException;

    public boolean insertMatch(Match m) throws SQLException, IOException;

    public boolean deleteMatch(int id) throws SQLException, IOException;

    public boolean updateMatch(int id, int date, int heure, int terrain, int type) throws SQLException, IOException;
    
    public int selectIdMatchByTerrainByDateByHour(int date, int numTerrain,int heure) throws SQLException, IOException;
}
