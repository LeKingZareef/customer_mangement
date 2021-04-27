package sr.unasat.customer_management.transfers;

import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.RepaymentPlan;
import sr.unasat.customer_management.entities.Transfer;

public abstract class Type {
    Customer customer;
    int amount;
    String value_date;
    String description;
    RepaymentPlan repaymentPlan;

    Type() {
    }

    public Transfer transfers() {
        Transfer transferToAccount = transferToAccount(customer, amount,value_date,
                description, repaymentPlan);
        return transferToAccount;
    }

    public abstract Transfer transferToAccount(Customer customer, int amount, String value_date,
                                               String description, RepaymentPlan repaymentPlan );

}
