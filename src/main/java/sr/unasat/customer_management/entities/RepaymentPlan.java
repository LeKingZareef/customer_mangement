package sr.unasat.customer_management.entities;

import javax.persistence.*;

@Entity
public class RepaymentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private Long plan_nbr;
    private String currency;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gl_code", nullable=false)
    private AccountType accountType;

    private String value_date;
    private int amount;
    private int profit_amount;
    private String maturity_date;
    private String status;
    private String paid_date;

    public RepaymentPlan(Integer id,
                         Long plan_nbr,
                         String currency,
                         AccountType accountType,
                         String value_date,
                         int amount,
                         int profit_amount,
                         String maturity_date,
                         String status,
                         String paid_date) {
        this.id = id;
        this.plan_nbr = plan_nbr;
        this.currency = currency;
        this.accountType = accountType;
        this.value_date = value_date;
        this.amount = amount;
        this.profit_amount = profit_amount;
        this.maturity_date = maturity_date;
        this.status = status;
        this.paid_date = paid_date;
    }

    public  RepaymentPlan() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPlan_nbr() {
        return plan_nbr;
    }

    public void setPlan_nbr(Long plan_nbr) {
        this.plan_nbr = plan_nbr;
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

    public String getValue_date() {
        return value_date;
    }

    public void setValue_date(String value_date) {
        this.value_date = value_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(String paid_date) {
        this.paid_date = paid_date;
    }

    public String getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(String maturity_date) {
        this.maturity_date = maturity_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProfit_amount() {
        return profit_amount;
    }

    public void setProfit_amount(int profit_amount) {
        this.profit_amount = profit_amount;
    }

    @Override
    public String toString() {
        return "RepaymentPlan{" +
                "id=" + id +
                ", plan_nbr=" + plan_nbr +
                ", currency='" + currency + '\'' +
                ", accountType=" + accountType +
                ", value_date='" + value_date + '\'' +
                ", amount=" + amount +
                ", profit_amount=" + profit_amount +
                ", status='" + status + '\'' +
                ", paid_date='" + paid_date + '\'' +
                '}';
    }
}
