
package entities;

import java.sql.Date;

/**
 *
 * @author Jérôme
 */
public abstract class VIP {
    protected int id;
    protected String name;
    protected String surname;
    protected String birthDate;



    public VIP(int id, String name, String surname, String birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString() {
        return "\n id=" + id + "\n name=" + name + "\n surname=" + surname + "\n birthDate=" + birthDate ;
    }

   
    
    
}
