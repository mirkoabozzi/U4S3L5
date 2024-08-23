package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.Catalog;
import mirkoabozzi.exceptions.NotFoundException;

import java.util.UUID;

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

    public Catalog getByASIN(String catalogISBN) {
        Catalog elementFound = em.find(Catalog.class, UUID.fromString(catalogISBN));
        if (elementFound == null)
            throw new NotFoundException(catalogISBN);
        else return elementFound;
    }

    public void deleteByISBN(String catalogISBN) {
        Catalog elementFound = this.getByASIN(catalogISBN);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(elementFound);
        transaction.commit();
        System.out.println("Elemento " + elementFound.getTitle() + " eliminato");
    }
}
