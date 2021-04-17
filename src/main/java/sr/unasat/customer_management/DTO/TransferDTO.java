package sr.unasat.customer_management.DTO;

public class TransferDTO {

    private Long accountTypeID;
    private Long customerID;
    private Integer repaymentID;
    private int amount;
    private String value_date;
    private String description;
    private int transferType;

    public TransferDTO(Long accountTypeID,
                       Long customerID,
                       Integer repaymentID,
                       int amount,
                       String value_date,
                       String description,
                       int transferType) {
        this.accountTypeID = accountTypeID;
        this.customerID = customerID;
        this.repaymentID = repaymentID;
        this.amount = amount;
        this.description = description;
        this.transferType = transferType;
    }

    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public Integer getRepaymentID() {
        return repaymentID;
    }

    public int getAmount() {
        return amount;
    }

    public String getValue_date() {
        return value_date;
    }

    public String getDescription() {
        return description;
    }

    public int getTransferType() {
        return transferType;
    }
}
