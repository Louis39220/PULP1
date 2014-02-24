package entities;

import java.util.Date;

/**
 *
 * @author Jérôme
 */
public class Coach extends VIP
{
    
    private Player playerCoached;
    private int reputation;

    public Coach(Player playerCoached, int reputation, String vipId, String vipName, String vipSurname, Date vipBirthDate) {
        super(vipId, vipName, vipSurname, vipBirthDate);
        this.playerCoached = playerCoached;
        this.reputation = reputation;
    }

    public Player getPlayerCoached() {
        return playerCoached;
    }

    public void setPlayerCoached(Player playerCoached) {
        this.playerCoached = playerCoached;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return super.toString() + "Coach{" + "playerCoached=" + playerCoached + ", reputation=" + reputation + '}';
    }
    
    
}
