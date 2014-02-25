
package entities;

import java.util.Date;

/**
 *
 * @author Jérôme
 */
public abstract class VIP {
    protected String id;
    protected String name;
    protected String surname;
    protected Date birthDate;



    public VIP(String id, String name, String surname, Date birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString() {
        return "\n id=" + id + "\n name=" + name + "\n surname=" + surname + "\n birthDate=" + birthDate ;
    }

   
    
    
}
