package sr.unasat.customer_management.services;

import com.sun.xml.internal.bind.v2.TODO;
import sr.unasat.customer_management.DAO.CustomerDAO;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("customers")
public class CustomerResource {
    private CustomerDAO customerDAO = new CustomerDAO(JPAconfig.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> retrieveAll() {
        List<Customer> customerListList = customerDAO.findAll();
        return customerListList;
    }

//    TODO: Insert


//    TODO: Update


//    TODO: Delete
}
