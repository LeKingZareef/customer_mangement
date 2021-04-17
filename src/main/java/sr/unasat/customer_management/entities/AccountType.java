package sr.unasat.customer_management.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AccountType {
    @Id
    private Long gl_code;
    private String name;
    private String arab_name;
    private String occupation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", nullable = false,
            columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date created_on = new Date();

    public AccountType(Long gl_code, String name, String arab_name, String occupation, Date created_on) {
        this.gl_code = gl_code;
        this.name = name;
        this.arab_name = arab_name;
        this.occupation = occupation;
        this.created_on = created_on;
    }

    public AccountType() {

    }

    @PreUpdate
    public void updateAccountType(){
        this.created_on = new Date();
    }


    public Long getGl_code() {
        return gl_code;
    }

    public void setGl_code(Long gl_code) {
        this.gl_code = gl_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArab_name() {
        return arab_name;
    }

    public void setArab_name(String arab_name) {
        this.arab_name = arab_name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "gl_code=" + gl_code +
                ", name='" + name + '\'' +
                ", arab_name='" + arab_name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", created_on=" + created_on +
                '}';
    }
}
