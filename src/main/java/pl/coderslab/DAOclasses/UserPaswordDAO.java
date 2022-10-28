package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Component;
import pl.coderslab.classes.User;
import pl.coderslab.classes.UserPassword;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserPaswordDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void saveUserpassword(UserPassword userPassword) {
        entityManager.persist(userPassword);
    }
    public void delete(UserPassword userPassword) {
        entityManager.remove(entityManager.contains(userPassword) ?
                userPassword : entityManager.merge(userPassword));
    }
    public void update(UserPassword userPassword) {
        entityManager.merge(userPassword);
    }

}

