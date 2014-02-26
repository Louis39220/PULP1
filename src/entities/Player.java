
package entities;

import java.util.Date;

/**
 *
 * @author Louis
 */
public class Player extends VIP{

    
    private int playerRank;

    public Player(String playerId, String playerName, String playerSurname, Date playerBirthDate, int playerRank) {
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
