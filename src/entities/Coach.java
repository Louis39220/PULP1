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

    public Coach(String coachId, String coachName, String coachSurname, Date coachBirthDate, Player playerCoached, int reputation) {
        super(coachId, coachName, coachSurname, coachBirthDate);
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
        return "Coach{" + super.toString()  + "\n playerCoached=" + playerCoached + "\n reputation=" + reputation + '}';
    }
    
    
}
