package sr.unasat.customer_management.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    private String currency;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gl_code", nullable=false)
    private AccountType accountType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "repayment_id", referencedColumnName = "id")
    private RepaymentPlan repaymentPlan;

    private Integer amount;
    private Integer yield;
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_open", nullable = false,
            columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date date_open = new Date();

    private String date_closed;
    private String created_by;


    public Account(Long id,
                   String currency,
                   AccountType accountType,
                   Customer customer,
                   RepaymentPlan repaymentPlan,
                   Integer amount,
                   Integer yield,
                   String status,
                   Date date_open,
                   String date_closed,
                   String created_by) {
        this.id = id;
        this.currency = currency;
        this.accountType = accountType;
        this.customer = customer;
        this.repaymentPlan = repaymentPlan;
        this.amount = amount;
        this.yield = yield;
        this.status = status;
        this.date_open = date_open;
        this.date_closed = date_closed;
        this.created_by = created_by;
    }

    public Account() {

    }

    @PreUpdate
    public void updateAccount(){
        this.date_open = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getYield() {
        return yield;
    }

    public void setYield(Integer yield) {
        this.yield = yield;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate_open() {
        return date_open;
    }

    public void setDate_open(Date date_open) {
        this.date_open = date_open;
    }

    public String getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(String date_closed) {
        this.date_closed = date_closed;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public RepaymentPlan getRepaymentPlan() {
        return repaymentPlan;
    }

    public void setRepaymentPlan(RepaymentPlan repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", accountType=" + accountType +
                ", customer=" + customer +
                ", repaymentPlan=" + repaymentPlan +
                ", amount='" + amount + '\'' +
                ", yield='" + yield + '\'' +
                ", status='" + status + '\'' +
                ", date_open=" + date_open +
                ", date_closed='" + date_closed + '\'' +
                ", created_by='" + created_by + '\'' +
                '}';
    }
}
