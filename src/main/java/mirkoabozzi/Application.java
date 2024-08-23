package mirkoabozzi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mirkoabozzi.dao.CatalogDAO;
import mirkoabozzi.dao.UserDAO;
import mirkoabozzi.entities.Book;
import mirkoabozzi.entities.Magazine;
import mirkoabozzi.entities.User;
import mirkoabozzi.enums.PeriodicityType;
import mirkoabozzi.exceptions.NotFoundException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogDAO cd = new CatalogDAO(em);
        UserDAO ud = new UserDAO(em);

        Book book1 = new Book("Il Signore Degli Anelli", LocalDate.of(1982, 2, 1), 530, "Tolkien", "romanzo");
        Book book2 = new Book("Harry Potter e la pietra filosofale", LocalDate.of(1997, 2, 6), 344, "Rowling", "Romanzo");
        Book book3 = new Book("Harry Potter e la camera dei segreti", LocalDate.of(1998, 5, 8), 375, "Rowling", "Romanzo");
        Book book4 = new Book("Le Cronache di Narnia", LocalDate.of(2008, 10, 25), 1168, "Lewis", "Fantasy");
        Magazine magazine1 = new Magazine("La Nuova Sardegna", LocalDate.of(1881, 10, 5), 10, PeriodicityType.MONTHLY);
        Magazine magazine2 = new Magazine("Unione Sarda", LocalDate.of(1889, 10, 11), 15, PeriodicityType.MONTHLY);
        Magazine magazine3 = new Magazine("La Gazzetta Dello Sport", LocalDate.of(1896, 10, 29), 10, PeriodicityType.HALF_YEARLY);
        Magazine magazine4 = new Magazine("Tutto Sport", LocalDate.of(1946, 10, 15), 20, PeriodicityType.MONTHLY);
        User mirko = new User("Mirko", "Abozzi", LocalDate.of(1990, 9, 12), 1234);
        User laura = new User("Laura", "Bianchi", LocalDate.of(1985, 5, 23), 5678);
        User andrea = new User("Andrea", "Rossi", LocalDate.of(1992, 11, 30), 9101);
        User chiara = new User("Chiara", "Verdi", LocalDate.of(1988, 2, 14), 2345);


//       aggiungi elemento al db
//        cd.save(book1);
//        cd.save(book2);
//        cd.save(book3);
//        cd.save(book4);
//        cd.save(magazine1);
//        cd.save(magazine2);
//        cd.save(magazine3);
//        cd.save(magazine4);

//        aggiungi utenti al DB
//        ud.save(mirko);
//        ud.save(laura);
//        ud.save(andrea);
//        ud.save(chiara);

        try {

//      cerca elemento per isbn
            System.out.println("Elemento tramite ISBN " + cd.getByASIN("87ee5874-05c7-4bcb-9f1f-a41d4fd7778a"));

//        Elimina elemento per isbn
//            cd.deleteByISBN("da9da08d-f47e-4049-a827-174baf1dbc2");

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }


//     trova elemento per data pubblicazione
        System.out.println("Trova tramite data pubblicazione");
        cd.findByPublishYear("1982-02-01").forEach(System.out::println);

//        trova per autore
        System.out.println("Trova per autore");
        cd.findByAuthor("rowling").forEach(System.out::println);

//        Filtra per titolo o parte del titolo

        System.out.println("Filtra titolo o parte del titolo");
        cd.filterTitle("la").forEach(System.out::println);

        em.close();
        emf.close();
    }
}
