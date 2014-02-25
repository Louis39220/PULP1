
import DAO.DaoFactory;
import DAO.PlayerDaoImpl;
import java.sql.SQLException;

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

    public static void main(String[] args) throws SQLException {
        PlayerDaoImpl pdao =  DaoFactory.getPlayerDao();
        try {
            pdao.insertPlayer("Louis", "FAVRET", "08/10/1994", 14);
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion:" + e.getMessage());
        }

    }

}
