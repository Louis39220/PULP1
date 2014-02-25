
package entities;

import java.sql.Date;

/**
 *
 * @author Louis
 */
public class Player extends VIP{

    
    private int playerRank;

    public Player(int playerId, String playerName, String playerSurname, String playerBirthDate, int playerRank) {
        super(playerId, playerName, playerSurname, playerBirthDate);
        this.playerRank = playerRank;
    }
    
    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    @Override
    public String toString() {
        return "Player{" + super.toString()+ "playerRank=" + playerRank + '}';
    }

 
    

}
