package entities;

/**
 *
 * @author Jérôme
 */
public class Coach extends VIP
{
    
    private int playerCoached;
    private int reputation;

    public Coach(int coachId, String coachName, String coachSurname, String coachBirthDate, int playerCoached, int reputation) {
        super(coachId, coachName, coachSurname, coachBirthDate);
        this.playerCoached = playerCoached;
        this.reputation = reputation;
    }

    public int getPlayerCoached() {
        return playerCoached;
    }

    public void setPlayerCoached(int playerCoached) {
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
