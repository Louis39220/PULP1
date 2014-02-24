/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Louis
 */
public class Player {

    private String playerId;
    private String playerName;
    private String playerSurname;
    private Date playerDdn;
    private int playerRank;

    public Player(String playerId, String playerName, String playerSurname, Date playerDdn, int playerRank) {
        this.playerId=playerId;
        this.playerName = playerName;
        this.playerSurname = playerSurname;
        this.playerDdn = playerDdn;
        this.playerRank = playerRank;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public Date getPlayerDdn() {
        return playerDdn;
    }

    public void setPlayerDdn(Date playerDdn) {
        this.playerDdn = playerDdn;
    }

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

}
