package sr.unasat.customer_management.entities;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String company;
    private String sexe;
    private String phone;
    private String email;
    private String id_number;
    private int type;

    public Customer(String name,
                    String company,
                    String sexe,
                    String phone,
                    String email,
                    String id_number,
                    int type) {
        this.name = name;
        this.company = company;
        this.sexe = sexe;
        this.phone = phone;
        this.email = email;
        this.id_number = id_number;
        this.type = type;
    }

    public Customer () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", sexe='" + sexe + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", id_number='" + id_number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

