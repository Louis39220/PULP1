/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Coach;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public interface CoachDao {

    public Coach selectCoach(int id) throws SQLException;

    public ResultSet selectAllCoach() throws SQLException;

    public boolean insertCoach(String name, String Surname, String ddn, int pCoached, int reput) throws SQLException;

    public boolean deleteCoach(int id) throws SQLException;

    public boolean updateCoach(int id, String name, String surname, String ddn, int pCoached, int reput) throws SQLException;

}
