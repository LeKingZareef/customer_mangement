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

    public Customer(String name,
                    String company,
                    String sexe,
                    String phone,
                    String email) {
        this.name = name;
        this.company = company;
        this.sexe = sexe;
        this.phone = phone;
        this.email = email;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", sexe='" + sexe + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

