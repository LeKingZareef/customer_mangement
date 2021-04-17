package sr.unasat.customer_management.services;

import sr.unasat.customer_management.DAO.AccountDAO;
import sr.unasat.customer_management.DAO.AccountTypeDAO;
import sr.unasat.customer_management.DAO.CustomerDAO;
import sr.unasat.customer_management.DAO.RepaymentPlanDAO;
import sr.unasat.customer_management.DTO.AccountDTO;
import sr.unasat.customer_management.builders.AccountBuilder;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.RepaymentPlan;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;

@Path("/accounts")
public class AccountResource {
    private AccountDAO accountDAO = new AccountDAO(JPAconfig.getEntityManager());
    private CustomerDAO customerDAO = new CustomerDAO(JPAconfig.getEntityManager());
    private AccountTypeDAO accountTypeDAO = new AccountTypeDAO(JPAconfig.getEntityManager());
    private RepaymentPlanDAO repaymentPlanDAO = new RepaymentPlanDAO(JPAconfig.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> retrieveAll() {
        return accountDAO.listAccounts();
    }

    @Path("/delete")
    @DELETE
    public String deleteAccount(long id) {
        Account account = accountDAO.select(id);
        accountDAO.delete(account);
        return "Account Deleted!";
    }

    @Path("/save")
    @PUT
    public String saveAccount(AccountDTO accountDTO) {
        AccountType accountType = accountTypeDAO.select(accountDTO.getAccountTypeID());
        Customer customer = customerDAO.select(accountDTO.getCustomerID());
        RepaymentPlan repaymentPlan = repaymentPlanDAO.select(accountDTO.getRepaymentID());


        Account accountAdd = new AccountBuilder(accountDTO.getCurrency(),
                accountType,
                customer,
                repaymentPlan,
                accountDTO.getAmount(),
                accountDTO.getYield(),
                accountDTO.getStatus(),
                accountDTO.getDate_closed(),
                accountDTO.getCreated_by())
                .build();

        accountDAO.save(accountAdd);

        return "Acount has been Added !";
    }
}
