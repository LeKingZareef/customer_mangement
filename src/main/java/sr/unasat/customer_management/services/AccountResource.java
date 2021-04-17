package sr.unasat.customer_management.services;

import sr.unasat.customer_management.DAO.AccountDAO;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/accounts")
public class AccountResource {
    private AccountDAO accountDAO = new AccountDAO(JPAconfig.getEntityManager());

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
}
