package sr.unasat.customer_management.services;

import sr.unasat.customer_management.DAO.UserDAO;
import sr.unasat.customer_management.DTO.UserDTO;
import sr.unasat.customer_management.config.JPAconfig;
import sr.unasat.customer_management.entities.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserResource {
    private UserDAO userDAO =  new UserDAO(JPAconfig.getEntityManager());

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User login(UserDTO userDTO) {
        User user = userDAO.selectUserByUsername(userDTO.getUsername(), userDTO.getPassword());
        return user;
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> retrieveAll() {
        List<User> userList = userDAO.listUsers();
        return userList;
    }

}
