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
public interface RefereeDao {

    public Coach selectReferee(int id) throws SQLException;

    public ResultSet selectAllReferee() throws SQLException;

    public boolean insertReferee(String name, String Surname, String ddn, int nbMatch, String categorie) throws SQLException;

    public boolean deleteReferee(int id) throws SQLException;

    public boolean updateReferee(int id, String name, String surname, String ddn, int nbMatch, String categorie) throws SQLException;

}
