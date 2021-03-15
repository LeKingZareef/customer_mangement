package sr.unasat.customer_management;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sr.unasat.customer_management.DAO.CustomerDAO;
import sr.unasat.customer_management.DAO.UserDAO;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.User;
import sr.unasat.customer_management.entities.UserLevel;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class UserDAORegistrationTest {

    public UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAO(JPAconfig.getEntityManager());
    }

    @After
    public void tearDown() throws Exception {
        JPAconfig.shutdown();
    }

    @Test
    public void registerUser() {
        //Given
        String username = "zsoeto";
        String password = "1234";
        String name = "Zareef Soetodrono";

        UserLevel userLevel = new UserLevel();
        userLevel.setRole("Administrator");

        UserLevel level = userLevel;


        //When
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setLevel(level);

        userDAO.registerUser(user);

        //Then
        List<User> result = userDAO.listUsers();
        result.stream().forEach(System.out::println);

    }


    @Test
    public void loginUser() {
        //Given
        String username = "zsoeto";
        String password = "1234";

        //When
        User user = userDAO.selectUserByUsername(username, password);

        //Then
        assertEquals(user.getUsername(), username);
        assertEquals(user.getPassword(), password);
    }

    @Test
    public void loginUserWithWrongCredentials() {
        //Given
        String username = "zsoeto";
        String password = "12345";

        //When
        User user = userDAO.selectUserByUsername(username, password);

        //Then
        Assert.assertEquals(null, user);
    }
}