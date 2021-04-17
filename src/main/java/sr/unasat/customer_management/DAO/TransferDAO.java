package sr.unasat.customer_management.DAO;



import sr.unasat.customer_management.entities.Account;
import sr.unasat.customer_management.entities.Transfer;
import sr.unasat.customer_management.transfers.Type;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TransferDAO {

    private EntityManager entityManager;

    public TransferDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Transfer> listTransfer() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT t FROM Transfer t";
        TypedQuery<Transfer> query = entityManager.createQuery(jpql, Transfer.class);
        List<Transfer> transferList = query.getResultList();
        entityManager.getTransaction().commit();
        return transferList;
    }

    public void save(Transfer transfer){
        entityManager.getTransaction().begin();
        entityManager.persist(transfer);
        entityManager.getTransaction().commit();
    }

}
