
package entities;

import java.util.Date;

/**
 *
 * @author Louis
 */
public class Player extends VIP{

    
    private int playerRank;

    public Player(String vipId, String vipName, String vipSurname, Date vipBirthDate, int playerRank) {
        super(vipId, vipName, vipSurname, vipBirthDate);
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
        return super.toString() + "Player{" + "playerRank=" + playerRank + '}';
    }
    

}
