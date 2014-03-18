package TestDB;


import DAO.CoachDao;
import DAO.DaoFactory;
import DAO.MatchDao;
import DAO.MatchDaoImpl;
import DAO.Match_playerDaoImpl;
import DAO.PlayerDao;
import DAO.PlayerDaoImpl;
import DAO.RefereeDaoImpl;
import DAO.match_playerDao;
import entities.Match;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Louis
 */
public class TestDB {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws SQLException, IOException {
        MatchDaoImpl rdao =  DaoFactory.getMatchDao();
        try {
            Match m = new Match(1, 2, 26, 8, 1, 1, 2, 4, 5, 0);
            rdao.insertMatch(m);
          
        } catch (IOException | SQLException e) {
            System.err.println("Erreur lors de l'insertion:" + e.getMessage());
        }
    }

}
