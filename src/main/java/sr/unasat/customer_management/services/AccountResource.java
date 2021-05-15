package sr.unasat.customer_management.services;

import sr.unasat.customer_management.DAO.*;
import sr.unasat.customer_management.DTO.AccountDTO;
import sr.unasat.customer_management.DTO.RepaymentDTO;
import sr.unasat.customer_management.DTO.TransferDTO;
import sr.unasat.customer_management.builders.AccountBuilder;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.*;
import sr.unasat.customer_management.transfers.Cash;
import sr.unasat.customer_management.transfers.InternetBanking;
import sr.unasat.customer_management.transfers.Type;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/accounts")
public class AccountResource {
    private AccountDAO accountDAO = new AccountDAO(JPAconfig.getEntityManager());
    private CustomerDAO customerDAO = new CustomerDAO(JPAconfig.getEntityManager());
    private AccountTypeDAO accountTypeDAO = new AccountTypeDAO(JPAconfig.getEntityManager());
    private RepaymentPlanDAO repaymentPlanDAO = new RepaymentPlanDAO(JPAconfig.getEntityManager());
    private TransferDAO transferDAO = new TransferDAO(JPAconfig.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> retrieveAll() {
        return accountDAO.listAccounts();
    }

    @Path("/type")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountType> retrieveType() {
        return accountTypeDAO.listTypes();
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

        return "Account has been Added !";
    }

    @Path("/update")
    @POST
    public String updateAccount(Account accountUpdated) {
        Account account = accountDAO.select(accountUpdated.getId());
        account.setStatus(accountUpdated.getStatus());
        accountDAO.update(account);
        return  "Account has been updated";
    }


    @Path("/payments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transfer> retrieveAllTransfers() {
        return transferDAO.listTransfer();
    }

    @Path("/payment")
    @PUT
    public String paymentAccount(TransferDTO transferDTO) {
        AccountType accountType = accountTypeDAO.select(transferDTO.getAccountTypeID());
        Customer customer = customerDAO.select(transferDTO.getCustomerID());
        RepaymentPlan repaymentPlan = repaymentPlanDAO.select(transferDTO.getRepaymentID());
        Type type = null;
        if (transferDTO.getTransferType() == 1) {
            type = new Cash(customer, transferDTO.getAmount(),transferDTO.getValue_date(), transferDTO.getDescription(),  repaymentPlan);
        } else if (transferDTO.getTransferType() == 2) {
            type = new InternetBanking(customer,  transferDTO.getAmount(),transferDTO.getValue_date(), transferDTO.getDescription(), repaymentPlan);
        }

        transferDAO.save(type.transfers());
        return "Payment is done";
    }


    @Path("/repayment")
    @PUT
    public String saveRepayment(RepaymentDTO repaymentDTO) {
        AccountType accountType = accountTypeDAO.select(repaymentDTO.getAccountType());
        RepaymentPlan repaymentPlan = new RepaymentPlan();
        repaymentPlan.setAccountType(accountType);
        repaymentPlan.setAmount(repaymentDTO.getAmount());
        repaymentPlan.setStatus(repaymentDTO.getStatus());
        repaymentPlan.setCurrency(repaymentDTO.getCurrency());
        repaymentPlan.setMaturity_date(repaymentDTO.getMaturity_date());
        repaymentPlan.setProfit_amount(repaymentDTO.getProfit_amount());
        repaymentPlan.setValue_date(repaymentDTO.getValue_date());
        repaymentPlan.setPlan_nbr(repaymentDTO.getPlan_nbr());
        repaymentPlanDAO.save(repaymentPlan);
        return "Repayment Plan Added!";
    }

    @Path("/repayment/last")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RepaymentPlan> retrieveLastRepayment() {
        return repaymentPlanDAO.selectLast();
    }

}
