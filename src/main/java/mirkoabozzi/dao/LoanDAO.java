package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import mirkoabozzi.entities.Loan;

import java.util.List;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("Prestito " + loan + " salvato");
    }

    public List<Loan> getLoanByUserCard(int cardId) {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.user.cardId = :cardId", Loan.class);
        query.setParameter("cardId", cardId);
        return query.getResultList();
    }
}
