package TestDB;


import DAO.DaoFactory;
import DAO.MatchDao;
import entities.Match;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        MatchDao mdao;
        mdao = DaoFactory.getMatchDao();
        List<Match>lm = new ArrayList<>();
        try {
            lm = mdao.selectMatchByDateByHour(27, 11);
            for(Match m : lm){
                System.out.println(m.toString());
            }
          
        } catch (IOException | SQLException e) {
            System.err.println("Erreur lors de l'insertion:" + e.getMessage());
        }
    }

}
