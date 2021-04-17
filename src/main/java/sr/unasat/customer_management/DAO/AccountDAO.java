package sr.unasat.customer_management.DAO;


import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountDAO {
    private EntityManager entityManager;

    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addAccount(Account account){
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
    }


    public List<Account> listAccounts() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT a FROM Account a";
        TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
        List<Account> accountListList = query.getResultList();
        entityManager.getTransaction().commit();
        return accountListList;

    }
}
