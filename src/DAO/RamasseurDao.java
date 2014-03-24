/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Ramasseur;
import entities.Referee;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Ludovic
 */
public interface RamasseurDao {
    public Ramasseur selectNomRamasseur() throws SQLException, IOException;
    
    public Ramasseur selectIdRamasseur() throws SQLException, IOException;
    
    public Ramasseur selectRamasseur(int id) throws SQLException, IOException;
}
