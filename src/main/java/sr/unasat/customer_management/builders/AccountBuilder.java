package sr.unasat.customer_management.builders;

import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.RepaymentPlan;

import java.util.Date;

public class AccountBuilder {

    public String currency;
    public AccountType accountType;
    public Customer customer;
    public RepaymentPlan repaymentPlan;
    public Integer amount;
    public Integer yield;
    public String status;
    public Date date_open;
    public String date_closed;
    public String created_by;


    public AccountBuilder(String currency,
                          AccountType accountType,
                          Customer customer,
                          RepaymentPlan repaymentPlan,
                          Integer amount, Integer yield,
                          String status, Date date_open,
                          String date_closed,
                          String created_by) {
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

    public Account build(){
        return new Account(this);
    }
}
