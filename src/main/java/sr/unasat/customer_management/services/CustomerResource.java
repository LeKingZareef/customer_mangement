package sr.unasat.customer_management.services;

import sr.unasat.customer_management.DAO.CustomerDAO;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.Customer;

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
        List<Customer> customerList = customerDAO.findAll();
        return customerList;
    }

    @Path("/insert")
    @PUT
    public String insertCustomer(Customer customer) {
        customerDAO.insert(customer);
        return "Customer Added!";
    }

    @Path("/update")
    @POST
    public String updateCustomer(Customer customerNew) {
        Customer customer = customerDAO.select(customerNew.getId());
        customer.setCompany(customerNew.getCompany());
        customer.setEmail(customerNew.getEmail());
        customer.setName(customerNew.getName());
        customer.setPhone(customerNew.getPhone());
        customer.setSexe(customerNew.getSexe());
        customerDAO.update(customer);
        return "Customer Updated!";
    }

    @Path("/delete")
    @DELETE
    public String deleteCustomer(Customer customer) {
        customerDAO.delete(customer);
        return "Customer Deleted!";
    }
}
