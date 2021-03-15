package sr.unasat.customer_management.DAO;

import sr.unasat.customer_management.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registerUser(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public List<User> listUsers() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        List<User> userList = query.getResultList();
        entityManager.getTransaction().commit();
        return userList;

    }

    public User selectUserByUsername(String username, String password) {
        User user = null;
        entityManager.getTransaction().begin();
        String jpql = "select u from User u where u.username = :username and u.password = :password";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            return user;
        } finally {
            entityManager.getTransaction().commit();
            return user;
        }
    }
}
