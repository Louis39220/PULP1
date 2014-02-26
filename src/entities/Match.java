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
    private int idP1;
    private int idP2;
    private int jour;
    private int heure;
    private int idTerrain;
    private int idArbitreChaise;
    private int idArbitreFilet;
    private int idArbitre[];
    private int idTeamRamasseur1;
    private int idTeamRamasseur2;
    private boolean type;

    public int getIdP1() { return idP1; }
    public int getIdP2() { return idP2; }
    public int getJour() { return jour; }
    public int getHeure() { return heure; }
    public int getIdTerrain() { return idTerrain; }
    public int getIdArbitreChaise() { return idArbitreChaise; }
    public int getIdArbitreFilet() { return idArbitreFilet; }
    public int[] getIdArbitre() { return idArbitre; }
    public int getIdTeamRamasseur1() { return idTeamRamasseur1; }
    public int getIdTeamRamasseur2() { return idTeamRamasseur2; }
    public boolean isSimple() { return type; }
}
