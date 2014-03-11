/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ludovic
 */

public class Match {
    private int idMatch;
    private int idP1;
    private int idP2;
    private int idP3;
    private int idP4;
    private int jour;
    private int heure;
    private int idTerrain;
    private int idArbitreChaise;
    private int idArbitreFilet;
    private int idTeamRamasseur1;
    private int idTeamRamasseur2;
    private int type;

    public int getIdP1() { return idP1; }
    public int getIdP2() { return idP2; }
    public int getJour() { return jour; }
    public int getHeure() { return heure; }
    public int getIdTerrain() { return idTerrain; }
    public int getIdArbitreChaise() { return idArbitreChaise; }
    public int getIdArbitreFilet() { return idArbitreFilet; }
    public int getIdTeamRamasseur1() { return idTeamRamasseur1; }
    public int getIdTeamRamasseur2() { return idTeamRamasseur2; }
    public int isSimple() { return type; }
    public int getIdMatch() { return idMatch; }
    public int getIdP3() { return idP3; }
    public int getIdP4() { return idP4; }
    public int getType() { return type; }

    public Match(int idMatch, int terrain, int date, int heure, int type) {
        this.idMatch = idMatch;
        this.heure = heure;
        this.idTerrain = terrain;
        this.jour = date;
        this.type = type;
    }

    public void setIdMatch(int idMatch) { this.idMatch = idMatch; }
    public void setIdP1(int idP1) { this.idP1 = idP1; }
    public void setIdP2(int idP2) { this.idP2 = idP2; }
    public void setIdP3(int idP3) { this.idP3 = idP3; }
    public void setIdP4(int idP4) { this.idP4 = idP4; }
    public void setJour(int jour) { this.jour = jour; }
    public void setHeure(int heure) { this.heure = heure; }
    public void setIdTerrain(int idTerrain) { this.idTerrain = idTerrain; }
    public void setIdArbitreChaise(int idArbitreChaise) { this.idArbitreChaise = idArbitreChaise; }
    public void setIdArbitreFilet(int idArbitreFilet) { this.idArbitreFilet = idArbitreFilet; }
    public void setIdTeamRamasseur1(int idTeamRamasseur1) { this.idTeamRamasseur1 = idTeamRamasseur1; }
    public void setIdTeamRamasseur2(int idTeamRamasseur2) { this.idTeamRamasseur2 = idTeamRamasseur2; }
    public void setType(int type) { this.type = type; }
}
