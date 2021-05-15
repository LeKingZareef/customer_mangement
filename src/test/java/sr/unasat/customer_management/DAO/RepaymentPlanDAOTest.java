package sr.unasat.customer_management.DAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.RepaymentPlan;

import java.util.List;

public class RepaymentPlanDAOTest {

    public RepaymentPlanDAO repaymentPlanDAO;

    @Before
    public void setUp() throws Exception {
        repaymentPlanDAO = new RepaymentPlanDAO(JPAconfig.getEntityManager());
    }

    @After
    public void tearDown() throws Exception {
        JPAconfig.shutdown();
    }

    @Test
    public void selectLastTest() {
//        User user = userDAO.selectUserByUsername(username, password);
        List<RepaymentPlan> repaymentPlan = repaymentPlanDAO.selectLast();
        repaymentPlan.stream().forEach(System.out::println);
    }
}