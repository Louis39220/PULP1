package TestDB;


import DAO.DaoFactory;
import DAO.PlayerDao;
import DAO.PlayerDaoImpl;
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
        PlayerDao pdao =  DaoFactory.getPlayerDao();
        try {
            pdao.insertPlayer("Louis", "FAVRET", "08/10/1994", 14);
        } catch (IOException | SQLException e) {
            System.err.println("Erreur lors de l'insertion:" + e.getMessage());
        }
    }

}
