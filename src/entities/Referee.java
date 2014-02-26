
package entities;

/**
 *
 * @author Jérôme
 */
public class Referee extends VIP
{
    private int nbMatch;
    private String category;

    public Referee( int refId, String refName, String refSurname, String refBirthDate, int nbMatch, String category) {
        super(refId, refName, refSurname, refBirthDate);
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
        return  "Referee{" +super.toString() + "\n nbMatch=" + nbMatch + "\n category=" + category + '}';
    }
    
    
}
