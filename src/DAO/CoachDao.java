/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Coach;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Louis
 */
public interface CoachDao {

    public Coach selectCoach(int id) throws SQLException, IOException;

    public List<Coach> selectAllCoach() throws SQLException, IOException ;

    public boolean insertCoach(String name, String Surname, String ddn, int pCoached, int reput) throws SQLException, IOException;

    public boolean deleteCoach(int id) throws SQLException, IOException;
    
    public boolean deleteCoachByName(String name, String surname, String birthdate) throws SQLException, IOException;

    public boolean updateCoach(int id, String name, String surname, String ddn, int pCoached, int reput) throws SQLException, IOException;

}
