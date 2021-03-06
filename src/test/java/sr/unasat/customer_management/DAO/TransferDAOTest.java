package sr.unasat.customer_management.DAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sr.unasat.customer_management.builders.AccountBuilder;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.*;
import sr.unasat.customer_management.transfers.Cash;
import sr.unasat.customer_management.transfers.Type;

import java.util.List;

import static org.junit.Assert.*;

public class TransferDAOTest {
    public TransferDAO transferDAO;
    public CustomerDAO customerDAO;
    public AccountTypeDAO accountTypeDAO;
    public RepaymentPlanDAO repaymentPlanDAO;

    @Before
    public void setUp() throws Exception {
        transferDAO = new TransferDAO(JPAconfig.getEntityManager());
        customerDAO = new CustomerDAO(JPAconfig.getEntityManager());
        accountTypeDAO = new AccountTypeDAO(JPAconfig.getEntityManager());
        repaymentPlanDAO = new RepaymentPlanDAO(JPAconfig.getEntityManager());
    }

    @After
    public void tearDown() throws Exception {
        JPAconfig.shutdown();
    }


    @Test
    public void save() {
        Customer customer = customerDAO.select(7);
        RepaymentPlan repaymentPlan = repaymentPlanDAO.select(1);
        int amount = 500;
        String value_date = "2021-12-01";
        String description = "Pyament of car loan";

        Transfer transfer = new Transfer();
        transfer.setCustomer(customer);
        transfer.setAmount(amount);
        transfer.setValue_date(value_date);
        transfer.setDescription(description);
        transfer.setRepaymentPlan(repaymentPlan);

        Type type = new Cash(customer, 300, "2021-09-31", "Hello",  repaymentPlan);

        transferDAO.save(type.transfers());

        List<Transfer> result = transferDAO.listTransfer();
        result.stream().forEach(System.out::println);

    }
}