package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.Catalog;

public class CatalogDAO {
    private final EntityManager em;

    public CatalogDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalog catalog) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalog);
        transaction.commit();
        System.out.println("Elemento " + catalog.getTitle() + " salvato");
    }

}
