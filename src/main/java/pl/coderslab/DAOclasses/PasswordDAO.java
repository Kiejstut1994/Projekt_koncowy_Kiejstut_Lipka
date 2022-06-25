package pl.coderslab.DAOclasses;

import org.springframework.stereotype.Component;
import pl.coderslab.classes.Password;
import pl.coderslab.classes.Purchaser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PasswordDAO {
    @PersistenceContext
    EntityManager entityManager;
    public void savePassword(Password password) {
        entityManager.persist(password);
    }
    public void update(Password password) {
        entityManager.merge(password);
    }
    public Password findById(int id) {
        return entityManager.find(Password.class, id);
    }
    public void delete(Password password) {
        entityManager.remove(entityManager.contains(password) ?
                password: entityManager.merge(password));
    }
    public Password findByPassword(String password) {
        Query query = entityManager.createQuery("SELECT p FROM Password p where p.password=:password");
        query.setParameter("password", password);
        List<Password> wyniki= query.getResultList();//wymnik 1 to resultat
        return wyniki.get(0);
    }


}
