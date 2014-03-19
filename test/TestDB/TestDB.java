package TestDB;


import DAO.CoachDao;
import DAO.DaoFactory;
import DAO.DaoFactoryInterface;
import DAO.MatchDao;
import DAO.MatchDaoImpl;
import DAO.Match_playerDaoImpl;
import DAO.PlayerDao;
import DAO.PlayerDaoImpl;
import DAO.RefereeDaoImpl;
import DAO.match_playerDao;
import entities.Match;
import entities.Player;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private static final DaoFactoryInterface fact = null;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws SQLException, IOException {
        PlayerDaoImpl rdao;
        rdao = fact.getPlayerDao();
        try {
            List<Player> lp = new ArrayList<>();
            lp = rdao.selectPlayerOfMatchByDayHour(8, 26);
            for(Player p : lp){
                System.out.println(p.toString());
            }
          
        } catch (IOException | SQLException e) {
            System.err.println("Erreur lors de l'insertion:" + e.getMessage());
        }
    }

}
