package sr.unasat.customer_management.DAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.*;

import java.sql.Struct;
import java.util.List;

import static org.junit.Assert.*;

public class AccountDAOTest {

    public AccountDAO accountDAO;

    @Before
    public void setUp() throws Exception {
        accountDAO = new AccountDAO(JPAconfig.getEntityManager());
    }

    @After
    public void tearDown() throws Exception {
        JPAconfig.shutdown();
    }

    @Test
    public void addAccount() {
        //Given
        String currency = "USD";

        AccountType accountType = new AccountType();
        accountType.setGl_code(110201L);
        accountType.setName("Tawaruq");
        accountType.setArab_name("Reverse Murabaha");
        accountType.setOccupation("Buy a Car");

        //Customer
        Customer customer = new Customer();
        customer.setName("Zareef");
        customer.setCompany("ABC");
        customer.setSexe("male");
        customer.setPhone("+597723341");
        customer.setId_number("FP001112");
        customer.setEmail("fincance@mail.com");

        //repayment plan
        RepaymentPlan repaymentPlan = new RepaymentPlan();
        repaymentPlan.setPlan_nbr(001L);
        repaymentPlan.setCurrency("SRD");
        repaymentPlan.setAccountType(accountType);
        repaymentPlan.setValue_date("2021-04-16");
        repaymentPlan.setMaturity_date("2022-04-16");


        int amount = 500;
        int yield =  25;
        String status = "approved";
        String created_by = "zareefsoeto";

        repaymentPlan.setProfit_amount(amount * yield/100);
        repaymentPlan.setAmount(amount);
        repaymentPlan.setStatus("Pending");

        //When
        Account account = new Account();

        account.setCurrency(currency);
        account.setAccountType(accountType);
        account.setCustomer(customer);
        account.setRepaymentPlan(repaymentPlan);
        account.setAmount(amount);
        account.setYield(yield);
        account.setStatus(status);
        account.setCreated_by(created_by);

        accountDAO.addAccount(account);

        //Then

        List<Account> result = accountDAO.listAccounts();
        result.stream().forEach(System.out::println);
    }
}