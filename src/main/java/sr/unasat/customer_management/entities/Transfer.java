package sr.unasat.customer_management.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "repayment_id", referencedColumnName = "id")
    private RepaymentPlan repaymentPlan;

    private int amount;
    private String value_date;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", nullable = false,
            columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date created_on = new Date();

    public Transfer () {
    }


    @PreUpdate
    public void updateAccount(){
        this.created_on = new Date();
    }

    public Transfer(Customer customer,
                    AccountType accountType,
                    int amount,
                    String value_date,
                    String description,
                    RepaymentPlan repaymentPlan) {
        this.customer = customer;
        this.amount = amount;
        this.value_date = value_date;
        this.description = description;
        this.repaymentPlan = repaymentPlan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RepaymentPlan getRepaymentPlan() {
        return repaymentPlan;
    }

    public void setRepaymentPlan(RepaymentPlan repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getValue_date() {
        return value_date;
    }

    public void setValue_date(String value_date) {
        this.value_date = value_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", customer=" + customer +
                ", repaymentPlan=" + repaymentPlan +
                ", amount='" + amount + '\'' +
                ", value_date='" + value_date + '\'' +
                ", description='" + description + '\'' +
                ", created_on=" + created_on +
                '}';
    }
}
