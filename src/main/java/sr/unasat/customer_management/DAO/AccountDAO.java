package sr.unasat.customer_management.DAO;


import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.Customer;
import sr.unasat.customer_management.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountDAO {
    private EntityManager entityManager;

    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Account> listAccounts() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT a FROM Account a";
        TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
        List<Account> accountListList = query.getResultList();
        entityManager.getTransaction().commit();
        return accountListList;
    }

    public void save(Account account) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(account);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public Account select(long id) {
        entityManager.getTransaction().begin();
        String jpql = "select a from Account a where a.id = :id";
        TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
        query.setParameter("id", id);
        Account account = query.getSingleResult();
        entityManager.getTransaction().commit();
        return account;
    }

    public void update(Account account){
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
    }

    public void delete(Account account) {
        entityManager.getTransaction().begin();
        entityManager.remove(account);
        entityManager.getTransaction().commit();
    }
}
