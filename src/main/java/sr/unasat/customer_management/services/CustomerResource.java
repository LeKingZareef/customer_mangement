package sr.unasat.customer_management.services;

import sr.unasat.customer_management.DAO.CustomerDAO;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.customer_decorator.Joined;
import sr.unasat.customer_management.customer_decorator.Minor;
import sr.unasat.customer_management.customer_decorator.Normal;
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
        return customerDAO.findAll();
    }

    @Path("/save")
    @PUT
    public String saveCustomer(Customer customer) {
        int customertype  = customer.getType();
        sr.unasat.customer_management.customer_decorator.Customer Normal = new Normal();
        if ( customertype == 1) {
            Normal = new Minor(Normal);
            Normal.getType();
        } else  if (customertype == 2) {
            Normal = new Joined(Normal);
            Normal.getType();
        } else {
            Normal.getType();
        }
        customer.setType(customertype);
        customerDAO.save(customer);
        return "Customer Added!";
    }

    @Path("/update")
    @POST
    public String updateCustomer(Customer customerUpdated) {
        Customer customer = customerDAO.select(customerUpdated.getId());
        customer.setCompany(customerUpdated.getCompany());
        customer.setEmail(customerUpdated.getEmail());
        customer.setName(customerUpdated.getName());
        customer.setPhone(customerUpdated.getPhone());
        customer.setSexe(customerUpdated.getSexe());
        customer.setId_number(customerUpdated.getId_number());
        customer.setType(customerUpdated.getType());
        customerDAO.update(customer);
        return "Customer Updated!";
    }


    @Path("/delete")
    @DELETE
    public String deleteCustomer(long id) {
        Customer customer = customerDAO.select(id);
        customerDAO.delete(customer);
        return "Customer Deleted!";
    }
}
