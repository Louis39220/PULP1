/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.ConnexionMysqlFactory;
import entities.Match;
import entities.Referee;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Louis
 */
public class MatchDaoImpl implements MatchDao {

    private Connection connexionDB;

    public MatchDaoImpl(Connection conn) {
        this.connexionDB = conn;
    }

    @Override
    public Match selectMatch(int id) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        ResultSet rs1=null;
        Match m;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchId= ?")) {
            PS.setInt(1, id);
            rs = PS.executeQuery();
            PreparedStatement ps1 = connexionDB.prepareStatement("Select * from pulp.attribmatch where matchId =?");
            ps1.setInt(1, rs.getInt(1));
            rs1 = ps1.executeQuery();
            rs1.next();
            m = new Match(rs.getInt(1),rs1.getInt(2), rs1.getInt(3), rs.getInt(3), rs.getInt(4), rs.getInt(2), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6), rs1.getInt(7), rs.getInt(5));
        }
        rs.close();
        rs1.close();
        connexionDB.close();
        return m;
    }

    @Override
    public int selectIdMatchByTerrainByDate(int numTerrain, int date) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        int id;
        PreparedStatement PS = connexionDB.prepareStatement("SELECT matchId FROM pulp.match WHERE matchLieu= ? AND matchDate=?");
        PS.setInt(1, numTerrain);
        PS.setInt(2, date);
        rs = PS.executeQuery();
        rs.next();
        id = rs.getInt("matchId");
        rs.close();
        connexionDB.close();
        return id;
    }

    @Override
    public int selectIdMatchByDateByHour(int date, int trancheHoraire) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        int id;
        PreparedStatement PS = connexionDB.prepareStatement("SELECT matchId FROM pulp.match WHERE matchTrancheHoraire= ? AND matchDate=?");
        PS.setInt(1, trancheHoraire);
        PS.setInt(2, date);
        rs = PS.executeQuery();
        rs.next();
        id = rs.getInt("matchId");
        rs.close();
        connexionDB.close();
        return id;
    }

    @Override
    public List<Match> selectAllMatch() throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        ResultSet rs1=null;
        Statement st = connexionDB.createStatement();
        rs = st.executeQuery("SELECT * FROM match");
        List<Match> lm = new ArrayList<>();
        while (rs.next()) {
            PreparedStatement ps1 = connexionDB.prepareStatement("Select * from pulp.attribmatch where matchId =?");
            ps1.setInt(1, rs.getInt(1));
            rs1 = ps1.executeQuery();
            rs1.next();
            lm.add(new Match(rs.getInt(1),rs1.getInt(2), rs1.getInt(3), rs.getInt(3), rs.getInt(4), rs.getInt(2), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6), rs1.getInt(7), rs.getInt(5)));
        }
        rs.close();
        rs1.close();
        connexionDB.close();
        return lm;
    }

    @Override
    public List<Match> selectMatchByDate(int date) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        ResultSet rs1=null;
        PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchDate= ?");
        PS.setInt(1, date);
        rs = PS.executeQuery();

        List<Match> lm = new ArrayList<>();
        while (rs.next()) {
            PreparedStatement ps1 = connexionDB.prepareStatement("Select * from pulp.attribmatch where matchId =?");
            ps1.setInt(1, rs.getInt(1));
            rs1 = ps1.executeQuery();
            rs1.next();
            lm.add(new Match(rs.getInt(1),rs1.getInt(2), rs1.getInt(3), rs.getInt(3), rs.getInt(4), rs.getInt(2), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6), rs1.getInt(7), rs.getInt(5)));
        }
        rs.close();
        rs1.close();
        connexionDB.close();
        return lm;
    }

    @Override
    public List<Match> selectMatchByDateByHour(int date, int matchTrancheHoraire) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        ResultSet rs1 = null;
        PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchDate= ? AND matchTrancheHoraire=?");
       // int id = selectIdMatchByDateByHour(date, matchTrancheHoraire);
        PS.setInt(1, date);
        PS.setInt(2, matchTrancheHoraire);
        rs = PS.executeQuery();

        List<Match> lm = new ArrayList<>();
        while (rs.next()) {
            PreparedStatement ps1 = connexionDB.prepareStatement("Select * from pulp.attribmatch where matchId =?");
            ps1.setInt(1, rs.getInt(1));
            rs1 = ps1.executeQuery();
            rs1.next();
            lm.add(new Match(rs.getInt(1),rs1.getInt(2), rs1.getInt(3), rs.getInt(3), rs.getInt(4), rs.getInt(2), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6), rs1.getInt(7), rs.getInt(5)));
        }
        rs.close();
        connexionDB.close();
        return lm;
    }

    @Override
    public List<Match> selectMatchByTerrainByDate(int date, int numTerrain) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        Match m;
        PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchLieu= ? AND matchDate=?");
        PS.setInt(1, numTerrain);
        PS.setInt(2, date);
        rs = PS.executeQuery();

        List<Match> lm = new ArrayList<>();
        while (rs.next()) {
            lm.add(new Match(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
        }
        rs.close();
        connexionDB.close();
        return lm;
    }

    @Override
    public boolean insertMatch(Match m) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement PS = connexionDB.prepareStatement("INSERT INTO pulp.match(matchLieu, matchDate,matchTrancheHoraire, matchType) values(?,?,?,?)")) {
            PS.setInt(1, m.getIdTerrain());
            PS.setInt(2, m.getJour());
            PS.setInt(3, m.getHeure());
            PS.setInt(4, m.getType());
            try {
                PS.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                PS.cancel();
                res = false;
            }
        }
        int id = selectIdMatchByTerrainByDateByHour(m.getJour(), m.getIdTerrain(), m.getHeure());
        RefereeDao rdao;
        rdao = DaoFactory.getRefereeDao();
        List<Referee> lr = new ArrayList<>();
        lr = rdao.selectRandom8RefereeLine();
        try (PreparedStatement ps1 = connexionDB.prepareStatement("INSERT INTO pulp.attribmatch(matchId,idP1,idP2,idArbitreChaise,idArbitreFilet,idTeamRamasseur1,idTeamRamasseur2,idA1,idA2,idA3,idA4,idA5,idA6,idA7,idA8) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            ps1.setInt(1, id);
            ps1.setInt(2, m.getIdP1());
            ps1.setInt(3, m.getIdP2());
            ps1.setInt(4, m.getIdArbitreChaise());
            ps1.setInt(5, m.getIdArbitreFilet());
            ps1.setInt(6, m.getIdTeamRamasseur1());
            ps1.setInt(7, m.getIdTeamRamasseur2());
            ps1.setInt(8, lr.get(0).getId());
            ps1.setInt(9, lr.get(1).getId());
            ps1.setInt(10, lr.get(2).getId());
            ps1.setInt(11, lr.get(3).getId());
            ps1.setInt(12, lr.get(4).getId());
            ps1.setInt(13, lr.get(5).getId());
            ps1.setInt(14, lr.get(6).getId());
            ps1.setInt(15, lr.get(7).getId());
            try {
                ps1.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps1.cancel();
                res = false;
            }
            connexionDB.close();
        }

        return res;
    }

    @Override
    public boolean deleteMatch(int id) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("DELETE FROM match where matchId= ?")) {
            ps.setInt(1, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps.cancel();
                res = false;
            }
            ps.close();
            connexionDB.close();
        }
        return res;
    }

    @Override
    public boolean updateMatch(int id, int date, int heure, int terrain, int type) throws SQLException, IOException {
        boolean res = true;
        connexionDB = ConnexionMysqlFactory.getInstance();
        try (PreparedStatement ps = connexionDB.prepareStatement("UPDATE pulp.match SET matchLieu=? matchDate=? matchTrancheHoraire=? matchType=? where matchId=?")) {
            ps.setInt(2, terrain);
            ps.setInt(1, date);
            ps.setInt(3, heure);
            ps.setInt(4, type);
            ps.setInt(5, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                ps.cancel();
                res = false;
            }
            ps.close();
            connexionDB.close();
        }
        return res;

    }

    @Override
    public List<Match> selectMatchByTerrain(int numTerrain) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        ResultSet rs1 = null;
        Match m;
        PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM match WHERE matchLieu= ?");
        PS.setInt(1, numTerrain);
        rs = PS.executeQuery();
        List<Match> lm = new ArrayList<>();
        while (rs.next()) {
            PreparedStatement ps1 = connexionDB.prepareStatement("Select * from pulp.attribmatch where matchId =?");
            ps1.setInt(1, rs.getInt(1));
            rs1 = ps1.executeQuery();
            rs1.next();
            lm.add(new Match(rs.getInt(1),rs1.getInt(2), rs1.getInt(3), rs.getInt(3), rs.getInt(4), rs.getInt(2), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6), rs1.getInt(7), rs.getInt(5)));
        }
        rs.close();
        rs1.close();
        connexionDB.close();
        return lm;
    }

    @Override
    public Match selectMatchByTerrainByDateByHour(int date, int numTerrain, int heure) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs;
        ResultSet rs1=null;
        Match m = null;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT * FROM pulp.match WHERE matchLieu=? AND matchTrancheHoraire=? AND matchDate=?")) {
            PS.setInt(1, numTerrain);
            PS.setInt(2, heure);
            PS.setInt(3, date);
            rs = PS.executeQuery();
            while (rs.next()) {
               PreparedStatement ps1 = connexionDB.prepareStatement("Select * from pulp.attribmatch where matchId =?");
            ps1.setInt(1, rs.getInt(1));
            rs1 = ps1.executeQuery();
            rs1.next();
            m = new Match(rs.getInt(1),rs1.getInt(2), rs1.getInt(3), rs.getInt(3), rs.getInt(4), rs.getInt(2), rs1.getInt(4), rs1.getInt(5), rs1.getInt(6), rs1.getInt(7), rs.getInt(5));
            }
            rs.close();
            connexionDB.close();
        }
        return m;
    }

    @Override
    public int selectIdMatchByTerrainByDateByHour(int date, int numTerrain, int heure) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs = null;
        int res = 0;
        try (PreparedStatement PS = connexionDB.prepareStatement("SELECT matchId FROM pulp.match WHERE matchLieu=? AND matchTrancheHoraire=? AND matchDate=?")) {
            PS.setInt(1, numTerrain);
            PS.setInt(2, heure);
            PS.setInt(3, date);
            try {
                rs = PS.executeQuery();
                rs.next();
                res = rs.getInt(1);

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            PS.close();
            rs.close();
        }
        return res;
    }

    @Override
    public int[] selectCourtByDayByHour(int jour, int heure) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs = null;
        int tab[] = null;
        int i = 0;
        Statement st = connexionDB.createStatement();
        try (PreparedStatement ps = connexionDB.prepareStatement("select matchLieu from pulp.match where matchId in(select matchId from pulp.match where matchDate=? AND matchTrancheHoraire=?)")) {
            ps.setInt(1, jour);
            ps.setInt(2, heure);
            try {
                rs = ps.executeQuery();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            while (rs.next()) {
                tab[i] = rs.getInt(1);
                i++;
            }
        }
        return tab;
    }

    @Override
    public int[] selectHeureByLieuByDate(int jour, int lieu) throws SQLException, IOException {
        connexionDB = ConnexionMysqlFactory.getInstance();
        ResultSet rs = null;
        int tab[] = null;
        int i = 0;
        Statement st = connexionDB.createStatement();
        try (PreparedStatement ps = connexionDB.prepareStatement("select matchTrancheHoraire from pulp.match where matchId in(select matchId from pulp.match where matchDate=? AND matchLieu=?)")) {
            ps.setInt(1, jour);
            ps.setInt(2, lieu);
            try {
                rs = ps.executeQuery();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            while (rs.next()) {
                tab[i] = rs.getInt(1);
                i++;
            }
        }
        return tab;
    }

}
