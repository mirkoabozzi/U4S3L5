package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import mirkoabozzi.entities.Catalog;
import mirkoabozzi.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
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

    public List<Catalog> findByPublishYear(String publishDate) {
        LocalDate date = LocalDate.parse(publishDate);
        TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c WHERE c.publication_date =:date", Catalog.class);
        query.setParameter("date", date);
        return query.getResultList();

    }

    public List<Catalog> findByAuthor(String author) {
        TypedQuery<Catalog> query = em.createQuery("SELECT c FROM Catalog c WHERE LOWER (c.author) = LOWER (:author)", Catalog.class);
        query.setParameter("author", author);
        return query.getResultList();
    }
}
