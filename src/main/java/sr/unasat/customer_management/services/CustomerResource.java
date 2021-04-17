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
        return customerDAO.findAll();
    }

    @Path("/save")
    @PUT
    public String saveCustomer(Customer customer) {
        customerDAO.save(customer);
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
        customer.setId_number(customerNew.getId_number());
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
