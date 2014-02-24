
package entities;

import java.util.Date;

/**
 *
 * @author Jérôme
 */
public class Referee extends VIP
{
    private int nbMatch;
    private String category;

    public Referee(int nbMatch, String category, String vipId, String vipName, String vipSurname, Date vipBirthDate) {
        super(vipId, vipName, vipSurname, vipBirthDate);
        this.nbMatch = nbMatch;
        this.category = category;
    }

    public int getNbMatch() {
        return nbMatch;
    }

    public void setNbMatch(int nbMatch) {
        this.nbMatch = nbMatch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + "Referee{" + "nbMatch=" + nbMatch + ", category=" + category + '}';
    }
    
    
}
