package sr.unasat.customer_management.customer_decorator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {
        Customer customer = new Normal();
        System.out.println(customer.getType() + "  " + customer.idType());

        customer = new Joined(customer);
        System.out.println(customer.getType() + "  " + customer.idType());

        customer = new Minor(customer);
        System.out.println(customer.getType() + "  " + customer.idType());


    }
}