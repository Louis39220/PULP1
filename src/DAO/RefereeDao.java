/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Coach;
import entities.Referee;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Louis
 */
public interface RefereeDao {

    public Referee selectReferee(int id) throws SQLException, IOException;

    public List<Referee> selectAllReferee() throws SQLException, IOException;
    
    public List<Referee> selectRandom8RefereeLine()throws SQLException, IOException; 

    public boolean insertReferee(String name, String Surname, String ddn, int nbMatch, String categorie) throws SQLException, IOException;

    public boolean deleteReferee(int id) throws SQLException, IOException;
    
    public boolean deleteRefereeByName(String name, String surname, String birthdate) throws SQLException, IOException;

    public boolean updateReferee(int id, String name, String surname, String ddn, int nbMatch, String categorie) throws SQLException, IOException;

    public int selectNbMatch(int id) throws SQLException, IOException;
    
    public Referee selectRefereeRandomRefereeChaise()throws SQLException, IOException;
    
    public Referee selectRefereeRandomRefereeFilet()throws SQLException, IOException;
}
