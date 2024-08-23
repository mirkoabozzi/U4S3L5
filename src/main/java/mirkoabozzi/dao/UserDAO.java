package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.User;
import mirkoabozzi.exceptions.NotFoundException;

import java.util.UUID;

public class UserDAO {
    private final EntityManager em;


    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("User " + user.getName() + " salvato nel DB");
    }

    public User getUserById(String userId) {
        User userFound = em.find(User.class, UUID.fromString(userId));
        if (userFound == null)
            throw new NotFoundException(userId);
        else return userFound;
    }
}
