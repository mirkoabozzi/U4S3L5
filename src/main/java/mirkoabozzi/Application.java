package mirkoabozzi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mirkoabozzi.dao.CatalogDAO;
import mirkoabozzi.entities.Book;
import mirkoabozzi.entities.Magazine;
import mirkoabozzi.enums.PeriodicityType;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogDAO cd = new CatalogDAO(em);

        Book book1 = new Book("Il Signore Degli Anelli", LocalDate.of(1982, 2, 1), 530, "Tolkien", "romanzo");
        Book book2 = new Book("Harry Potter e la pietra filosofale", LocalDate.of(1997, 2, 6), 344, "Rowling", "Romanzo");
        Book book3 = new Book("Harry Potter e la camera dei segreti", LocalDate.of(1998, 5, 8), 375, "Rowling", "Romanzo");
        Book book4 = new Book("Le Cronache di Narnia", LocalDate.of(2008, 10, 25), 1168, "Lewis", "Fantasy");
        Magazine magazine1 = new Magazine("La Nuova Sardegna", LocalDate.of(1881, 10, 5), 10, PeriodicityType.MONTHLY);
        Magazine magazine2 = new Magazine("Unione Sarda", LocalDate.of(1889, 10, 11), 15, PeriodicityType.MONTHLY);
        Magazine magazine3 = new Magazine("La Gazzetta Dello Sport", LocalDate.of(1896, 10, 29), 10, PeriodicityType.HALF_YEARLY);
        Magazine magazine4 = new Magazine("Tutto Sport", LocalDate.of(1946, 10, 15), 20, PeriodicityType.MONTHLY);


//        cd.save(book1);
//        cd.save(book2);
//        cd.save(book3);
//        cd.save(book4);
//        cd.save(magazine1);
//        cd.save(magazine2);
//        cd.save(magazine3);
//        cd.save(magazine4);


        System.out.println(cd.getByASIN("87ee5874-05c7-4bcb-9f1f-a41d4fd7778a"));


    }
}
