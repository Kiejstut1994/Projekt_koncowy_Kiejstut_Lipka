package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Component;
import pl.coderslab.classes.Purchaser;
import pl.coderslab.classes.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;



import org.springframework.stereotype.Component;
import pl.coderslab.classes.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }
    public User findByName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.name=:name");
        query.setParameter("name", name);
        List<User> wyniki= query.getResultList();
        return wyniki.get(0);
    }
    public User findBySurname(String surname) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.surname=:surname");
        query.setParameter("surname", surname);
        List<User> wyniki= query.getResultList();
        return wyniki.get(0);
    }
    public User findByNameandSurname(String name,String surname) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.name=:name and u.surname=:surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        List<User> wyniki= query.getResultList();
        return wyniki.get(0);
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }
    public void update(User user) {
        entityManager.merge(user);
    }





    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user));
    }
}

