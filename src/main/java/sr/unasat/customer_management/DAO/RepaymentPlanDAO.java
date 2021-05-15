package sr.unasat.customer_management.DAO;


import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.RepaymentPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class RepaymentPlanDAO {
    private EntityManager entityManager;

    public RepaymentPlanDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public RepaymentPlan select(Integer id) {
        entityManager.getTransaction().begin();
        String jpql = "select rp from RepaymentPlan rp where rp.id = :id";
        TypedQuery<RepaymentPlan> query = entityManager.createQuery(jpql, RepaymentPlan.class);
        query.setParameter("id", id);
        RepaymentPlan repaymentPlan = query.getSingleResult();
        entityManager.getTransaction().commit();
        return repaymentPlan;
    }

    public void save(RepaymentPlan repaymentPlan) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(repaymentPlan);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<RepaymentPlan> selectLast() {
        entityManager.getTransaction().begin();
        String jpql = "select rp from RepaymentPlan rp order by id desc";
        TypedQuery<RepaymentPlan> query = entityManager.createQuery(jpql, RepaymentPlan.class);
        query.setMaxResults(1).getResultList();
        List<RepaymentPlan> repaymentPlanList = query.getResultList();
        entityManager.getTransaction().commit();
        return repaymentPlanList;
    }


}
