
import DBaccess.DBaccess;
import java.sql.Date;
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
        try {
            Date ddn;
            
            DBaccess dba = new DBaccess();
            boolean insertPlayer = dba.insertPlayer("Louis", "Favret","08/10/1994" , 15);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
            
        
    }

}
