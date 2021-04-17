package sr.unasat.customer_management.transfers;

import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.RepaymentPlan;
import sr.unasat.customer_management.entities.Transfer;

public class InternetBanking extends Type{
    final double feeamount = 0;

    public InternetBanking (Customer customer,
                            AccountType accountType,
                            int amount,
                            String value_date,
                            String description,
                            RepaymentPlan repaymentPlan) {
        this.customer = customer;
        this.accountType = accountType;
        this.amount = amount;
        this.value_date = value_date;
        this.description = description;
        this.repaymentPlan = repaymentPlan;
    }

    public InternetBanking(Customer customer, AccountType accountType, int amount, String description, RepaymentPlan repaymentPlan) {
    }

    @Override
    public Transfer transferToAccount(Customer customer, AccountType accountType, int amount, String value_date,
                                      String description, RepaymentPlan repaymentPlan) {
        Transfer transfer = new Transfer();
        transfer.setCustomer(customer);
        transfer.setAccountType(accountType);
        transfer.setAmount(amount);
        transfer.setValue_date(value_date);
        transfer.setDescription(description);
        transfer.setRepaymentPlan(repaymentPlan);
        return transfer;
    }
}
