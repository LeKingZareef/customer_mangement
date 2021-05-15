package sr.unasat.customer_management.DTO;

public class RepaymentDTO {
    private Long plan_nbr;
    private String currency;
    private Long accountType;
    private String value_date;
    private int amount;
    private int profit_amount;
    private String maturity_date;
    private String status;
    private String paid_date;

    public RepaymentDTO(Long plan_nbr,
                        String currency,
                        Long accountType,
                        String value_date,
                        int amount,
                        int profit_amount,
                        String maturity_date,
                        String status,
                        String paid_date) {
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

    public RepaymentDTO() {

    }

    public Long getPlan_nbr() {
        return plan_nbr;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getAccountType() {
        return accountType;
    }

    public String getValue_date() {
        return value_date;
    }

    public int getAmount() {
        return amount;
    }

    public int getProfit_amount() {
        return profit_amount;
    }

    public String getMaturity_date() {
        return maturity_date;
    }

    public String getStatus() {
        return status;
    }

    public String getPaid_date() {
        return paid_date;
    }
}
