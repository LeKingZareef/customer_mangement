package sr.unasat.customer_management;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sr.unasat.customer_management.DAO.CustomerDAO;
import sr.unasat.customer_management.entities.Customer;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.User;

public class CustomerDAOJpaIntegrationTest {

    private CustomerDAO customerDAO;

    @Before
    public void setUp() throws Exception {
        customerDAO = new CustomerDAO(JPAconfig.getEntityManager());
    }

    @After
    public void tearDown() throws Exception {
        JPAconfig.shutdown();
    }

    @Test
    public void findAll() {
        //Given
        String name = "Zareef";
        String company = "ABC";
        String sexe = "Male";
        String phone = "115";
        String email = "hi@mail.com";

        Customer customer = new Customer();
        customer.setName(name);
        customer.setCompany(company);
        customer.setSexe(sexe);
        customer.setPhone(phone);
        customer.setEmail(email);

        customerDAO.save(customer);

        //When
        List<Customer> result = customerDAO.findAll();

        //Then
        result.stream().forEach(System.out::println);
    }

    @Test
    public void delete() {
//        Given
        Customer customer = customerDAO.select(1);
//        When
        customerDAO.delete(customer);

//        Then
        System.out.println("Customer Deleted");


    }


}