/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Louis
 */
public interface match_playerDao {
    
    public int selectIdPlayer(int matchId) throws IOException, SQLException;
}
