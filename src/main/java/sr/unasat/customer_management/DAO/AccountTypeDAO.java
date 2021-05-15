package sr.unasat.customer_management.DAO;


import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.AccountType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class AccountTypeDAO {
    private EntityManager entityManager;

    public AccountTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<AccountType> listTypes() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT at FROM AccountType at";
        TypedQuery<AccountType> query = entityManager.createQuery(jpql, AccountType.class);
        List<AccountType> accountTypeList = query.getResultList();
        entityManager.getTransaction().commit();
        return accountTypeList;
    }

    public AccountType select(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select at from AccountType at where at.id = :id";
        TypedQuery<AccountType> query = entityManager.createQuery(jpql, AccountType.class);
        query.setParameter("id", id);
        AccountType accountType = query.getSingleResult();
        entityManager.getTransaction().commit();
        return accountType;
    }

}
