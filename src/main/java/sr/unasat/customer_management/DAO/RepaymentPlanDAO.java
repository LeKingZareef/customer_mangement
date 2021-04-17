package sr.unasat.customer_management.DAO;


import sr.unasat.customer_management.entities.AccountType;
import sr.unasat.customer_management.entities.RepaymentPlan;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


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
}
