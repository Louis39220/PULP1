
package entities;

import java.util.Date;

/**
 *
 * @author Jérôme
 */
public abstract class VIP {
    private String vipId;
    private String vipName;
    private String vipSurname;
    private Date vipBirthDate;

    public VIP(String vipId, String vipName, String vipSurname, Date vipBirthDate) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipSurname = vipSurname;
        this.vipBirthDate = vipBirthDate;
    }

    public String getVipId() {
        return vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public String getVipSurname() {
        return vipSurname;
    }

    public Date getVipBirthDate() {
        return vipBirthDate;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public void setVipSurname(String vipSurname) {
        this.vipSurname = vipSurname;
    }

    public void setVipBirthDate(Date vipBirthDate) {
        this.vipBirthDate = vipBirthDate;
    }

    @Override
    public String toString() {
        return "VIP{" + "vipId=" + vipId + ", vipName=" + vipName + ", vipSurname=" + vipSurname + ", vipBirthDate=" + vipBirthDate + '}';
    }
    
    
    
}
