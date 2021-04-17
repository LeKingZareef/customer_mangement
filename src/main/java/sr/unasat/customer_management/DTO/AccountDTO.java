package sr.unasat.customer_management.DTO;

import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.RepaymentPlan;

import java.util.Date;

public class AccountDTO {


    private String currency;
    private Long gl_code;
    private Long customerID;
    private Integer repaymentID;
    private Integer amount;
    private Integer yield;
    private String status;
    private Date date_open;
    private String date_closed;
    private String created_by;

    public AccountDTO(String currency,
                      Long gl_code,
                      Long customerID,
                      Integer repaymentID,
                      Integer amount,
                      Integer yield,
                      String status,
                      Date date_open,
                      String date_closed,
                      String created_by) {
        this.currency = currency;
        this.gl_code = gl_code;
        this.customerID = customerID;
        this.repaymentID = repaymentID;
        this.amount = amount;
        this.yield = yield;
        this.status = status;
        this.date_open = date_open;
        this.date_closed = date_closed;
        this.created_by = created_by;
    }

    public AccountDTO () {
    }

    public String getCurrency() {
        return currency;
    }

    public Long getGl_code() {
        return gl_code;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public Integer getRepaymentID() {
        return repaymentID;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getYield() {
        return yield;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate_open() {
        return date_open;
    }

    public String getDate_closed() {
        return date_closed;
    }

    public String getCreated_by() {
        return created_by;
    }
}
